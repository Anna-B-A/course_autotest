import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {
    @BeforeAll
    public static void beforeClass(){
        String TOKEN = RestAssured.given()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "  \"username\": \"unickUserName7787\",\n" +
                        "  \"password\": \"someNewUserPassword7787\"\n" +
                        "}")
                .post("http://9b142cdd34e.vps.myjino.ru:49268/login")
                .then().assertThat().statusCode(200)
                .extract().body().jsonPath().getString("access_token");
    }

    static {
        RestAssured.useRelaxedHTTPSValidation();
        RestAssured.filters(new RequestLoggingFilter(System.out),
                new ResponseLoggingFilter(System.out));
        RestAssured.baseURI = "http://9b142cdd34e.vps.myjino.ru:49268";
    }
}
