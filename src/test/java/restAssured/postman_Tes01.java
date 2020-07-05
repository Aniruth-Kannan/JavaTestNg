package restAssured;

import io.cucumber.core.gherkin.vintage.internal.gherkin.deps.com.google.gson.JsonObject;
import io.restassured.RestAssured;
import org.junit.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class postman_Tes01 {
    JsonObject requestBody =  new JsonObject();
    @BeforeTest
    public void setBaseUri(){
        RestAssured.baseURI = "https://postman-echo.com";
        requestBody.addProperty("authentication",true);
        System.out.println(requestBody);
    }

    @Test(priority = 0)
    public void verifyPostmanEchoBasicAuth(){
        RestAssured.basePath = "/basic-auth";
        String response =
        given()
                .auth().basic("postman","password")
                .header("Content-Type","application/json")
                .body(requestBody.toString())
        .when()
                .get()
        .then()
                .statusCode(200)
                .extract().asString();
        System.out.println("Response: " + response);
        Assert.assertTrue(response.contains("true"));
    }

    @Test(priority = 1)
    public void verifyPostmanEchoGet(){
        RestAssured.basePath = "/get?foo1=bar1&foo2=bar2";
        String response =
        given()
                .param("foo1","bar1")
                .param("foo2","bar2")
        .when()
               .get()
        .then()
                .statusCode(200)
                .extract().body().asString();
        System.out.println(response);
        Assert.assertTrue(response.contains("foo1"));
        Assert.assertTrue(response.contains("foo2"));
    }

    @Test(priority = 2)
    public void verifyPostmanEchoPost(){
        RestAssured.basePath = "/post";
        String requestBodyText = "Hello World!!..";
        String response =
        given()
                .header("Content-Type","text/plain")
                .body(requestBodyText)
        .when()
                .post()
        .then()
                .statusCode(200)
                .extract().body().asString();

        Assert.assertTrue(response.contains(requestBodyText));
    }

    @Test(priority = 3)
    public void verifyPostmanEchoPut() {
        RestAssured.basePath = "/put";
        String requestBodyText = "Hello World!!..";
        String response =
        given()
                .header("Content-Type","text/plain")
                .body(requestBodyText)
        .when()
                .put()
        .then()
                .statusCode(200)
                .extract().body().asString();

        Assert.assertTrue(response.contains(requestBodyText));
    }

    @Test(priority = 4)
    public void verifyPostmanEchoDelete(){
        RestAssured.basePath = "/delete";
        String requestBodyText = "Hello World!!..";
        String response =
        given()
                .header("Content-Type","text/plain")
                .body(requestBodyText)
        .when()
                .delete()
        .then()
                .statusCode(200)
                .extract().body().asString();

        Assert.assertTrue(response.contains(requestBodyText));
    }
}
