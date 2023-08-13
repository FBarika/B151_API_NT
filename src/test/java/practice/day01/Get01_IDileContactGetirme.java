package practice.day01;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Get01_IDileContactGetirme {

    @Test
    public void get01() {

        RestAssured.baseURI="https://thinking-tester-contact-list.herokuapp.com";
        RestAssured.basePath="/contacts/64d8ac0636c2810013fe7e3b";
        String token="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NGQ4OWMzNTlhNjk0ZTAwMTMwZjIyMzYiLCJpYXQiOjE2OTE5MTk1NDl9.4tGG7LBPaVadCmIWnHqKMNZZe24hLg_oNP0ATgUn1NA";

        Response response = given()
                .auth().oauth2(token)
                .when()
                .get();
        response.prettyPrint();

        response
                .then()
                .body("firstName",equalTo("Barika"))
                .body("lastName",equalToIgnoringCase("Ince"))
                .body("email",not(equalTo("fatma@fake.com")))
                .body("email",containsString("@fake.com"))
                .body("city",startsWith("Any"))
                .body("city",endsWith("own"))
                .body("stateProvince",anyOf(equalTo("KS"),equalTo("CA")))
                .body("country",allOf(equalTo("USA"),equalToIgnoringCase("usa")))
                .body("__v",greaterThan(-1));



    }
}
