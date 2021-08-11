import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static database.DBToJsonConvertor.convertDBToJson;
import static io.restassured.RestAssured.given;
import static json.JsonComparator.compareTwoJsonFiles;

public class UsersTest {

    private static RequestSpecification requestSpec;
    private static String jsonFromDB;

    @BeforeClass
    public static void createRequestSpecification() throws Exception {

        requestSpec = new RequestSpecBuilder().
                setBaseUri("http://gorest.co.in").
                setContentType(ContentType.JSON).
                build();

        jsonFromDB = convertDBToJson();
    }

    @Test
    public void usersListTest() throws Exception {

            String responseString = given().
                    spec(requestSpec).
                    when().
                    get("/public-api/users").
                    then().
                    assertThat().
                    statusCode(200).
                    extract().asString();

        Assert.assertTrue(compareTwoJsonFiles(responseString, jsonFromDB));
    }
}
