package dersler.herokuapp_smoketest;

import dersler.base_urls.HerokuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static dersler.herokuapp_smoketest.C01_CreateBooking.bookingid;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C05_DeleteBooking extends HerokuAppBaseUrl {

    /*
    Given
      https://restful-booker.herokuapp.com/booking/:id
    When
      Kullanici DELETE request gönderir
    Then
      Status code = 201
    And
      Body:
         Created

     */

    @Test
    public void deleteBooking() {

        //Set the Url
        spec.pathParams("first","booking","second",bookingid);

        //Set the expected data
        String expectedData = "Created";
        //Genelde isimizi kolaylastirmak icin map ve pojo kullaniyorduk.
        //Burada bir tane data ve bu data String olunca String’I kullanmak daha uygun olur.

        //Send the request and get the response
        Response response = given(spec).when().delete("{first}/{second}");
        response.prettyPrint();

        //Do Assertion
        assertEquals(201,response.statusCode());
        assertEquals(expectedData,response.asString());


























    }
}
