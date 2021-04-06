package ru.job4j.spammer;

import ru.job4j.db.ConfigValues;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ImportDB {
    private Connection cn = null;
    private String dump;

    public ImportDB(String dump) throws Exception {
        this.dump = dump;
        initConnection();
    }

    public ImportDB() {
    }

    public boolean initConnection() throws Exception {
        boolean result = false;
        ConfigValues config = new ConfigValues();
        String url = config.get("jdbc.url");
        String login = config.get("jdbc.username");
        String password = config.get("jdbc.password");
        Class.forName(config.get("jdbc.driver"));
        cn = DriverManager.getConnection(url, login, password);
        if (cn != null) {
            result = true;
            System.out.println("Соединение успешно созданно! Можно добавлять данные");
        }
        return result;
    }

    /**
     * Метод загружает строки из указаного файла и разбивает каждую на лексемы,
     * которые в свою очередь становяться параметрами обьекта User(name, email).
     * @return - List обьектов - User(name, email)
     * @throws IOException
     */
    public List<User> load() throws IOException {
        List<User> users = new ArrayList<>();
        users.clear();
        try (BufferedReader rd = new BufferedReader(new FileReader(dump))) {
            rd.lines().forEach(line -> {
                String[] tokens = line.split(";");
                users.add(
                        new User(tokens[0], tokens[1])
                );
            });
        }
        return users;
    }

    /**
     * метод сохраняет загруженый List с обьектами user, в БД
     * @param users - коллекция обьектов.
     * @return - возврашает модифицированую коллекцию users,
     * каждому обьекту добавляеться парметр id, сгенирированый в БД.
     * @throws SQLException
     */
    public List<User> save(List<User> users) throws SQLException {
        String sql = "INSERT INTO users(name, email) VALUES (?, ?)";
        for (User user : users) {
            try (PreparedStatement ps = cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ps.setString(1, user.getName());
                ps.setString(2, user.getEmail());
                ps.executeUpdate();
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) {
                        user.setId(rs.getInt(1));
                    }
                }
            }
        }
        return users;
    }

    public static void main(String[] args) throws Exception {
        ImportDB db = new ImportDB("dump.txt");
        //System.out.println(db.load());
        System.out.println(db.save(db.load()));

    }
}