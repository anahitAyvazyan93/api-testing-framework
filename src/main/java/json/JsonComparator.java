package json;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonComparator {

    public static Boolean compareTwoJsonFiles(String json1, String json2) throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        JsonNode tree1 = mapper.readTree(json1);
        JsonNode tree2 = mapper.readTree(json2);

        return tree1.equals(tree2);
    }
}
