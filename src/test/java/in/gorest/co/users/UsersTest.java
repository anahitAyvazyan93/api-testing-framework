package in.gorest.co.users;

import in.gorest.co.BaseTest;
import io.restassured.path.json.JsonPath;
import objects.UserObject;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static database.DBToJsonConvertor.convertDBToJson;
import static io.restassured.RestAssured.given;
import static json.JsonComparator.compareTwoJsonFiles;
import static json.UserJson.userJson;
import static org.testng.Assert.assertTrue;

public class UsersTest extends BaseTest {

    private static String newUserId;


    @Test
    public void usersListTest() throws Exception {

            String responseString = given().
                    spec(requestSpec).
                    when().
                    get("/public-api/users").
                    then().
                    assertThat().
                    statusCode(200).
                    extract().
                    body().asString();

        String jsonFromDB = convertDBToJson();
        assertTrue(compareTwoJsonFiles(responseString, jsonFromDB), "Response doesn't meet with DB data");
    }

    @Test(priority = 1)
    public void createUserTest() {

        newUserId = given().
                spec(requestAuthSpec).
                and().
                body(requestBody).
                when().
                post("/public/v1/users").
                then().
                assertThat().
                statusCode(201).
                extract().
                        jsonPath().
                        getString("data.id");

    }

    @Test(dependsOnMethods = "createUserTest", priority = 2)
    public void getUserTest() {
        SoftAssert softAssert = new SoftAssert();

        JsonPath responseJson = given().
                spec(requestSpec).
                when().
                get("/public/v1/users/" + newUserId).
                then().
                assertThat().
                statusCode(200).
                extract().
                body().
                jsonPath();


        softAssert.assertEquals(responseJson.getString("data.name"),userObject.getName());
        softAssert.assertEquals(responseJson.getString("data.email"),userObject.getEmail());
        softAssert.assertEquals(responseJson.getString("data.gender"),userObject.getGender());
        softAssert.assertEquals(responseJson.getString("data.status"),userObject.getStatus());

        softAssert.assertAll();
    }

    @Test(dependsOnMethods = "createUserTest", priority = 3)
    public void updateUserTest() {
        SoftAssert softAssert = new SoftAssert();
        UserObject userToUpdate = new UserObject("Updated User", null, "male", null);
        String updateBody = userJson(userToUpdate);

        JsonPath responseJson = given().
                spec(requestAuthSpec).
                and().
                body(updateBody).
                when().
                patch("/public/v1/users/" + newUserId).
                then().
                assertThat().
                statusCode(200).
                extract().
                body().jsonPath();

        softAssert.assertEquals(responseJson.getString("data.name"),userToUpdate.getName());
        softAssert.assertEquals(responseJson.getString("data.email"),userObject.getEmail());
        softAssert.assertEquals(responseJson.getString("data.gender"),userToUpdate.getGender());
        softAssert.assertEquals(responseJson.getString("data.status"),userObject.getStatus());

        softAssert.assertAll();

    }

    @Test(dependsOnMethods = "createUserTest", priority = 4)
    public void deleteUserTest() {

        given().
                spec(requestAuthSpec).
                when().
                delete("/public/v1/users/" + newUserId).
                then().
                assertThat().
                statusCode(204);
    }
}
