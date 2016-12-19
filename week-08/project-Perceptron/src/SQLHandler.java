/// Created by BB on 2016-12-15.

import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;


public class SQLHandler {

    private static Connection conn;
    private static Statement statement;
    private static Properties properties = new Properties();


    public static void createTable(ArrayList<String> columns) throws SQLException {
        config();
        System.out.println("Connecting to SQL Server...");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/perceptron", properties);
        statement = conn.createStatement();

        System.out.println("Dropping old data table...");
        statement.executeUpdate("DROP TABLE IF EXISTS DATA");

        System.out.println("Creating new data table...");
        StringBuilder sql = new StringBuilder();
        sql.append("CREATE TABLE DATA (id INTEGER not NULL, ");
        for (String column : columns) {
            sql.append(column);
            sql.append(" VARCHAR(255), ");
        }
        sql.append(" PRIMARY KEY ( id ))" );
        statement.executeUpdate(sql.toString());
        System.out.println("Finished. ");
    }

    public static void populateTable(ArrayList<ArrayList<String>> dataRows) throws SQLException {
        config();
        System.out.println("Connecting to SQL Server...");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/perceptron", properties);
        statement = conn.createStatement();
        int id = 0;
        System.out.println("Populating data table...");
        for (ArrayList<String> row : dataRows) {
            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO DATA VALUES (");
            sql.append(id);
            sql.append(", ");
            for (String value : row) {
                sql.append(value);
                sql.append(", ");
            }
            sql.setLength(sql.length()-2);
            sql.append(")");
            statement.executeUpdate(sql.toString());
            System.out.println("Row #" + id + " populated.");
            id++;
        }
        System.out.println("Finished. ");
    }

    public static double[] loadDataRow(int id, int usefulcolumns) throws SQLException {
        config();
        double[] out = new double[usefulcolumns];
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/perceptron", properties);
        statement = conn.createStatement();
        String sql = "SELECT * FROM DATA WHERE id =" + id;
        ResultSet row = statement.executeQuery(sql);
        while (row.next()) {
            for (int i = 2; i <= usefulcolumns+1; i++) {
                out[i-2] = Double.parseDouble(row.getString(i));
            }
        }
        return out;
    }

    private static void config() {
        properties.setProperty("user", "root");
        properties.setProperty("password", "Asdasd11_");
        properties.setProperty("useSSL", "false");
        properties.setProperty("autoReconnect", "true");
    }
}
