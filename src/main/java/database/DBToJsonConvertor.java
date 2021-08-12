package database;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class DBToJsonConvertor {

    public static String convertDBToJson() throws Exception {

        JSONArray jsonArray = new JSONArray();

        Connection con = DatabaseConnector.connectToDB();
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery("select * from users;");

        while (rs.next()) {
            JSONObject userObj = new JSONObject();
            userObj.put("id", rs.getInt("id"));
            userObj.put("name", rs.getString("name"));
            userObj.put("email", rs.getString("email"));
            userObj.put("gender", rs.getString("gender"));
            userObj.put("status", rs.getString("status"));
            jsonArray.add(userObj);
        }

        con.close();

        return jsonArray.toString();
    }
}
