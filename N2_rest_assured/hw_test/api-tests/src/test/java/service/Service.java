package service;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import schema.Schema;

public class Service {
    public static RequestSpecification prepareGet(){
        return RestAssured.given().accept(ContentType.JSON);
    }

    public static RequestSpecification preparePost(Schema body){
        return RestAssured.given().accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(body);
    }
}
