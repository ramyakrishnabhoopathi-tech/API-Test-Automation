
package utils;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class BaseRequest {

    public static RequestSpecification request(){

        RestAssured.baseURI =
                Config.getProperty("baseUrl");

        return RestAssured
                .given()
                .log().all()
                .header("Content-Type","application/json")
                .header("x-api-key",Config.getProperty("apiKey"));
    }
}