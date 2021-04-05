package ru.job4j.db;

import java.sql.*;

public class TableEditor implements AutoCloseable {

    private Connection cn;

    public TableEditor() {
        initConnection();
    }

    public static void main(String[] args) throws Exception {
        TableEditor editor = new TableEditor();
        editor.createTable("table1");
        editor.addColumn("table1", "name1", "VARCHAR (20)");
        //editor.dropTable("table1");
        //editor.dropColumn("table1", "name1");
        editor.renameColumn("table1", "ddd", "fff");
        System.out.println(editor.getScheme("table1"));

    }

    private void initConnection() {
        ConfigValues config = new ConfigValues(); // вспомогательный класс для доступа к файлу .properties
        try {
            Class.forName(config.get("driver-class-name"));
            log("Postgresql JDBC Driver зарегестрирован!");
        } catch (ClassNotFoundException e) {
            log("Не получаеться найти JDBC Driver. Убедитесь что зависимость Maven задана правильно");
            e.printStackTrace();
        }
        try {
            cn = DriverManager.getConnection(config.get("url"),
                    config.get("username"), config.get("password"));
            if (cn != null) {
                log("Соединение успешно созданно! Можно добавлять данные");
            } else {
                log("Не удалось установить соединение!");
            }
        } catch (SQLException e) {
            log("Ошибка подключения!");
            e.printStackTrace();
        }
    }

    /**
     * создает пустую таблицу без столбцов с указанным именем;
     * @param tableName
     */
    public void createTable(String tableName) throws SQLException {
        String queryStatement = String.format("create table if not exists %s();", tableName);
        performStatement(queryStatement);
    }

    /**
     * создает и исполняет Statement.
     * @param queryStatement
     * @throws SQLException
     */
    private void performStatement(String queryStatement) throws SQLException {
        try (Statement st = cn.createStatement()) {
            st.execute(queryStatement);
        }
    }

    /**
     * удаляет таблицу по указанному имени;
     * @param tableName
     */
    public void dropTable(String tableName) throws SQLException {
        String queryStatement = String.format("drop table if exists %s;", tableName);
        performStatement(queryStatement);
    }

    /**
     * добавляет столбец в таблицу;
     * @param tableName
     * @param columnName
     * @param type
     */
    public void addColumn(String tableName, String columnName, String type) throws SQLException {
        String queryStatement = String.format("ALTER TABLE %s ADD COLUMN if not exists %s %s;", tableName, columnName, type);
        performStatement(queryStatement);
    }

    /**
     * удаляет столбец из таблицы;
     * @param tableName
     * @param columnName
     * @throws SQLException
     */
    public void dropColumn(String tableName, String columnName) throws SQLException {
        String queryStatement = String.format("ALTER TABLE %s DROP COLUMN if exists %s;", tableName, columnName);
        performStatement(queryStatement);
    }

    /**
     * переименовывает столбец.
     *
     * @param tableName
     * @param columnName
     * @param newColumnName
     */
    public void renameColumn(String tableName, String columnName, String newColumnName) throws SQLException {
        String queryStatement = String.format("ALTER TABLE %s RENAME COLUMN %s TO %s;", tableName, columnName, newColumnName);
        performStatement(queryStatement);
    }

    public String getScheme(String tableName) throws SQLException {
        StringBuilder scheme = new StringBuilder();
        DatabaseMetaData metaData = cn.getMetaData();
        try (ResultSet columns = metaData.getColumns(null, null, tableName, null)) {
            scheme.append(String.format("%-15s %-15s%n", "column", "type"));
            while (columns.next()) {
                scheme.append(String.format("%-15s %-15s%n",
                        columns.getString("COLUMN_NAME"),
                        columns.getString("TYPE_NAME")));
            }
        }
        return scheme.toString();
    }

    private void log(String s) {
        System.out.println(s);
    }

    @Override
    public void close() throws Exception {
        if (cn != null) {
            cn.close();
        }
    }
}
