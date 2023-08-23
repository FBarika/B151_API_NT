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
import static org.junit.Assert.assertEquals;

public class C02_GetBookingById extends HerokuAppBaseUrl {

    /*
    Given
      https://restful-booker.herokuapp.com/booking/:id
    When
      Kullanici GET requestgönderir
    Then
      Status code = 200

    And

      Body:
      {
    "firstname": "Jim",
    "lastname": "Brown",
    "totalprice": 111,
    "depositpaid": true,
    "bookingdates": {
        "checkin": "2018-01-01",
        "checkout": "2019-01-01"
    },
    "additionalneeds": "Breakfast"
}
     */

    @Test
    public void getBookingById() {
        //Set the Url
        spec.pathParams("first","booking","second",bookingid);

        //Set the expected data
        BookingDatesPojo bookingDates = new BookingDatesPojo("2018-01-01","2019-01-01");
        BookingPojo expectedData = new BookingPojo("Jim","Brown",111,true,bookingDates,"Breakfast");

        //Send the request and get the reaponse
        Response response = given(spec).when().get("{first}/{second}");

        //Do Assertion
        BookingPojo actualData = convertJsonToJava(response.asString(),BookingPojo.class);

        assertEquals(200,response.statusCode());
        assertEquals(expectedData.getFirstname(),actualData.getFirstname());
        assertEquals(expectedData.getLastname(),actualData.getLastname());
        assertEquals(expectedData.getTotalprice(),actualData.getTotalprice());
        assertEquals(expectedData.getDepositpaid(),actualData.getDepositpaid());
        assertEquals(bookingDates.getCheckin(),actualData.getBookingdates().getCheckin());
        assertEquals(bookingDates.getCheckout(),actualData.getBookingdates().getCheckout());
        assertEquals(expectedData.getAdditionalneeds(),actualData.getAdditionalneeds());


    }
}
