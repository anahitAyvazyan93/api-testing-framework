package database;

import java.sql.*;

import static configurations.Configuration.*;

public class DatabaseConnector {
    static Connection con;

    public static void connectToDB() {
        con = null;
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager
                    .getConnection(DB_URL,
                            DB_USERNAME, DB_PASSWORD);

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Opened database successfully");


    }

    public static void closeDBConnection(){
        try {
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}