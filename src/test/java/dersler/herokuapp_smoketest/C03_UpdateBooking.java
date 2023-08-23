package dersler.herokuapp_smoketest;

import dersler.base_urls.HerokuAppBaseUrl;
import dersler.pojos.BookingDatesPojo;
import dersler.pojos.BookingPojo;
import dersler.pojos.BookingResponsePojo;
import io.restassured.response.Response;
import org.junit.Test;

import static dersler.herokuapp_smoketest.C01_CreateBooking.bookingid;
import static dersler.utils.ObjectMapperUtils.convertJsonToJava;
import static io.restassured.RestAssured.given;

public class C03_UpdateBooking extends HerokuAppBaseUrl {

    /*
    Given
        https://restful-booker.herokuapp.com/booking/:id
    And
        {
            "firstname" : "James",
            "lastname" : "Brown",
            "totalprice" : 111,
            "depositpaid" : true,
            "bookingdates" : {
                "checkin" : "2018-01-01",
                "checkout" : "2019-01-01"
            },
            "additionalneeds" : "Breakfast"
        }
    When
        Kullanıcı PUT request gönderir
    Then
        Status Code = 200
    And
        Body:
            {
                "firstname" : "Jim",
                "lastname" : "Brown",
                "totalprice" : 111,
                "depositpaid" : true,
                "bookingdates" : {
                    "checkin" : "2018-01-01",
                    "checkout" : "2019-01-01"
                },
                "additionalneeds" : "Breakfast"
            }
 */

    @Test
    public void updateBooking() {

        //Set the Url
        spec.pathParams("first","booking","second",bookingid);

        //Set the expected data
        BookingDatesPojo bookingDates = new BookingDatesPojo("2018-01-01","2019-01-01");
        BookingPojo expectedData = new BookingPojo("Jim","Brown",111,true,bookingDates,"Breakfast");

        //Send the request and get the response
        Response response = given(spec).header("Cookie","token=a4872e12a86d89b").body(expectedData).when().put("{first}/{second}");

        //Do Assertion
        BookingPojo actualData = convertJsonToJava(response.asString(), BookingPojo.class);

























    }
}
