package database;

import org.apache.ibatis.jdbc.ScriptRunner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;

public class DatabaseInit {

    public static void initDb() throws Exception {

        Connection con = DatabaseConnector.connectToDB();
        Reader reader = new BufferedReader(new FileReader("src/main/resources/db_scripts/initiateDatabase.sql"));
        ScriptRunner sr = new ScriptRunner(con);
        sr.setAutoCommit(true);
        sr.setStopOnError(true);
        sr.runScript(reader);
        con.close();
    }
}
