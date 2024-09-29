import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FirstTest {
    private static RequestSpecification specification = RestAssured.given().contentType(ContentType.JSON);

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
        RestAssured.baseURI = "http://9b142cdd34e.vps.myjino.ru:49268";
        RestAssured.filters(new RequestLoggingFilter(System.out),
                new ResponseLoggingFilter(System.out),
                new AuthFilter(TOKEN));
    }

    @Test
    public void testCase(){
        RestAssured.given()
                .accept("application/json")
                .get("/products")
                .then().assertThat().statusCode(200);
    }

    @Test
    public void testCreateUser(){
        RestAssured.given(specification)
                .body("{\n" +
                        "  \"username\": \"unickUserName7787\",\n" +
                        "  \"password\": \"someNewUserPassword7787\"\n" +
                        "}")
                .post("/register")
                .then().assertThat().statusCode(201);
    }

//    @Test
//    public void testLogin(){
//        RestAssured.given().log().all()
//                .contentType(ContentType.JSON)
//                .body("{\n" +
//                        "  \"username\": \"unickUserName7787\",\n" +
//                        "  \"password\": \"someNewUserPassword7787\"\n" +
//                        "}")
//                .post("http://9b142cdd34e.vps.myjino.ru:49268/login")
//                .then().log().all().assertThat().statusCode(200);
//    }

    @Test
    public void testToken(){
        RestAssured.given()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "  \"product_id\": 1,\n" +
                        "  \"quantity\": 2\n" +
                        "}")
                .post("/cart")
                .then().assertThat().statusCode(201)
                .and()
                .assertThat().body(JsonSchemaValidator.matchesJsonSchema("{\n" +
                        "   \"message\": \"Product added to card successfully\"\n" +
                        "}"));
    }





}
