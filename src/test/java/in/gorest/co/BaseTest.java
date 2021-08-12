package in.gorest.co;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import objects.UserObject;
import org.testng.annotations.BeforeClass;

import java.util.UUID;

import static configurations.Configuration.ACCESS_TOKEN;
import static configurations.Configuration.BASE_URI;
import static json.UserJson.userJson;

public class BaseTest {
    protected RequestSpecification requestSpec;
    protected RequestSpecification requestAuthSpec;
    protected String requestBody;
    protected UserObject userObject;

    public String getUserRequestBody() {
        userObject = new UserObject("Test User", getUniqueEmail(), "female", "active");
        return userJson(userObject);
    }

    public String getUniqueEmail() {
        String uniqueID = UUID.randomUUID().toString();
        return uniqueID + "@mailinator.com";
    }

    @BeforeClass
    public void createRequestSpecification() throws Exception {

        requestSpec = new RequestSpecBuilder().
                setBaseUri(BASE_URI).
                setContentType(ContentType.JSON).
                build();

        requestAuthSpec = new RequestSpecBuilder().
                setBaseUri(BASE_URI).
                addHeader("Authorization", "Bearer " + ACCESS_TOKEN).
                setContentType(ContentType.JSON).
                build();


        requestBody = getUserRequestBody();
    }


}
