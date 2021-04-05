package ru.job4j.db;

import java.sql.*;

public class StatementDemo {
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        ConfigValues config = new ConfigValues();
        Class.forName(config.get("hibernate.connection.driver_class"));
        String url = config.get("hibernate.connection.url");
        String login = config.get("hibernate.connection.username");
        String password = config.get("hibernate.connection.password");
        return DriverManager.getConnection(url, login, password);
    }

    public static void main(String[] args) throws Exception {
        try (Connection connection = getConnection()) {
            try (Statement statement = connection.createStatement()) {
                String sql = String.format("create table if not exists demo_table(%s, %s);",
                        "id serial primary key",
                        "name varchar(255)"
                );
                statement.execute(sql);
                System.out.println(getTableScheme(connection, "demo_table"));
            }
        }
    }

    /**
     * метод проверяет, что таблица создалась и выводит ее схему, а именно ее столбцы и их типы.
     * @param cn
     * @param tableName
     * @return
     * @throws Exception
     */
    public static String getTableScheme(Connection cn, String tableName) throws Exception {
        StringBuilder scheme = new StringBuilder();
        DatabaseMetaData metaData = cn.getMetaData();
        try (ResultSet colums = metaData.getColumns(null, null, tableName, null)) {
            scheme.append(String.format("%-15s %-15s%n", "column", "type"));
            while (colums.next()) {
                scheme.append(String.format("%-15s %-15s%n",
                        colums.getString("COLUMN_NAME"),
                        colums.getString("TYPE_NAME")));
            }
        }
        return scheme.toString();
    }
}