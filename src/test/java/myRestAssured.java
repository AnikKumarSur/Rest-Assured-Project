import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.commons.configuration.ConfigurationException;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class myRestAssured {
@Test
    public void doLogin() throws ConfigurationException {
        RestAssured.baseURI = "https://dailyfinanceapi.roadtocareer.net";
        Response res = given().contentType("application/json")
                .body("{\n" +
                        "    \"email\":\"admin@test.com\",\n" +
                        "    \"password\":\"admin123\"\n" +
                        "}")
                .when().post("/api/auth/login");

        //System.out.println("Response: " + res.asString());
    JsonPath jsonObject = res.jsonPath();
    String token = jsonObject.get("token");
    System.out.println("Token: " + token);
    Utils.setEnvVar("token", token);

    }
}
