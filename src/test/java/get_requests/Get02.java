package get_requests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;

public class Get02 {

    /*
        Given
            https://restful-booker.herokuapp.com/booking/0
        When
            Kullanıcı URL'e bir GET request gönderir
        Then
            HTTP Status code 404 olmalı
        And
            Status Line "HTTP/1.1 404 Not Found" olmalı
        And
            Response body "Not Found" içermeli
        And
            Response body "TechProEd" içermemeli
        And
            Server değeri "Cowboy" olmalı
    */
    @Test
    public void get02() {

        /*
        1- Set the URL = URL'i tanımla
        2- Set the expected data = Beklenen dataları ayarla
        3- Send the request and get the response = İsteği gönder ve cevabı al
        4- Do assertion = Doğrulama yap
         */

        RestAssured.baseURI="https://restful-booker.herokuapp.com";
        RestAssured.basePath="/booking/0";

        given()
                .when()
                .get()
                .then()
                .statusCode(404)
                .statusLine("HTTP/1.1 404 Not Found")
                .body(containsString("Not Found"))//Core matchers'dan import ettik
                .body(not(containsString("TechProEd")))//Core matchers'dan import ettik
                .header("Server","Cowboy");

        //2.yol Bu sekilde de assert edilebilir.
        Response response= given().when().get();
        response.then().statusCode(404).statusLine("HTTP/1.1 404 Not Found");
        assertTrue(response.asString().contains("Not Found"));
        assertFalse(response.asString().contains("TechProEd"));
        assertEquals("Cowboy",response.header("Server"));

    }

    //Hamcrest Matchers
}
