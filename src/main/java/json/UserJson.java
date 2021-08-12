package json;

import objects.UserObject;
import org.json.simple.JSONObject;

public class UserJson {

    public static String userJson(UserObject user) {

        JSONObject userObj = new JSONObject();
        if (user.getName() != null)
            userObj.put("name", user.getName());

        if (user.getEmail() != null)
            userObj.put("email", user.getEmail());

        if (user.getGender() != null)
            userObj.put("gender", user.getGender());

        if (user.getStatus() != null)
            userObj.put("status", user.getStatus());

        return userObj.toString();
    }
}
