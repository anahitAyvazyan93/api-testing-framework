package database;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class DBToJsonConvertor {

    public static String convertDBToJson() throws Exception {

        JSONParser parser = new JSONParser();
        JSONArray jsonArray = new JSONArray<>();
        JSONObject usersObj = (JSONObject) parser.parse(new FileReader("src/main/resources/json_templates/users.json"));
        JSONObject userObj = (JSONObject) parser.parse(new FileReader("src/main/resources/json_templates/user.json"));
        Connection con = DatabaseConnector.connectToDB();
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery("select * from users;");

        while (rs.next()) {
            userObj.put("id", rs.getInt("id"));
            userObj.put("name", rs.getString("name"));
            userObj.put("email", rs.getString("email"));
            userObj.put("gender", rs.getString("gender"));
            userObj.put("status", rs.getString("status"));
            jsonArray.add(userObj);
        }

        con.close();
        usersObj.put("data", jsonArray);

        return usersObj.toString();
    }
}
