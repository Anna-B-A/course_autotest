import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.mapper.ObjectMapperDeserializationContext;
import io.restassured.mapper.ObjectMapperSerializationContext;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.opentest4j.AssertionFailedError;
import schema.*;
import service.CartService;

import java.util.ArrayList;
import java.util.List;


public class FirstTest extends BaseTest {
    private static RequestSpecification specification = RestAssured.given().contentType(ContentType.JSON);

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
        String responseBody = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(new AddCartRequest(1,2))
                .post("/cart")
                .then().assertThat().statusCode(201)
                .and()
                .extract().body().asString();

        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try {
            objectMapper.readValue(responseBody, SuccessMessage.class);
        } catch (JsonProcessingException e) {
            throw new AssertionFailedError(e.getMessage());
        }

    }

    @Test
    public void testGetCart(){
        RestAssured.given()
                .accept(ContentType.JSON)
                .get("/cart")
                .then()
                .extract().as(GetCartResponce.class);
    }
//    @Test
//    public void testGetCart(){
//        new CartService().getCart()
//                .then()
//                .assertThat()
//                .statusCode(200)
//                .and()
//                .extract().as(GetCartResponce.class);
//    }

    @Test
    public void testGetProducts(){
        RestAssured.given()
                .accept(ContentType.JSON)
                .get("/products")
                .then()
                .extract().as(new TypeRef<List<Cart>>() {
                });
    }



}
