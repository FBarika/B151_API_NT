package dersler.herokuapp_smoketest;

import dersler.base_urls.HerokuAppBaseUrl;
import dersler.pojos.BookingDatesPojo;
import dersler.pojos.BookingPojo;
import io.restassured.response.Response;
import org.junit.Test;

import static dersler.herokuapp_smoketest.C01_CreateBooking.bookingid;
import static dersler.utils.ObjectMapperUtils.convertJsonToJava;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C06_GetBookingById_NegativeTest extends HerokuAppBaseUrl {
     /*
    Given
        https://restful-booker.herokuapp.com/booking/:id
    When
        Kullanıcı GET request gönderir
    Then
        Status Code = 404
    And
        Body:
            Not Found
 */

    @Test
    public void getBookingById() {
        //Set the Url
        spec.pathParams("first","booking","second",bookingid);

        //Set the expected data
        String expectedData ="Not Found";

        //Send the request and get the reaponse
        Response response = given(spec).when().get("{first}/{second}");
        response.prettyPrint();

        //Do Assertion


        assertEquals(404,response.statusCode());
        assertEquals(expectedData,response.asString());

    }
}
