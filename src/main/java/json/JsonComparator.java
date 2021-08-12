package json;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonComparator {

    public static Boolean compareTwoJsonFiles(String jsonFromResponse, String jsonFromDB) throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        JsonNode tree1 = mapper.readTree(jsonFromResponse).get("data");
        JsonNode tree2 = mapper.readTree(jsonFromDB);

        return tree1.equals(tree2);
    }
}
