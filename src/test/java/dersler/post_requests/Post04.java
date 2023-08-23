package dersler.post_requests;


import dersler.base_urls.HerokuAppBaseUrl;
import dersler.pojos.BookingDatesPojo;
import dersler.pojos.BookingPojo;
import dersler.pojos.BookingResponsePojo;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Post04 extends HerokuAppBaseUrl {

    /*
        Given
          1)  https://restful-booker.herokuapp.com/booking
          2) {
                "firstname": "Ali",
                "lastname": "Can",
                "totalprice": 999,
                "depositpaid": true,
                "bookingdates": {
                    "checkin": "2021-09-21",
                    "checkout": "2021-12-21"
                 },
                 "additionalneeds": "Breakfast"
              }
        When
            I send POST Request to the URL
        Then
            Status code is 200
        And
            Response body is like
                 {
                    "bookingid": 16,
                    "booking" :{
                        "firstname": "Ali",
                        "lastname": "Can",
                        "totalprice": 999,
                        "depositpaid": true,
                        "bookingdates": {
                            "checkin": "2021-09-21",
                            "checkout": "2021-12-21"
                        },
                        "additionalneeds": "Breakfast"
                     }
                  }
     */

    @Test
    public void post04() {
        //Set the Url
        spec.pathParam("first","booking");

        //Set the expected data
        BookingDatesPojo bookingdates = new BookingDatesPojo("2021-09-21","2021-12-21");
        BookingPojo expectedData = new BookingPojo("Ali","Can",999,true,bookingdates,"additionalneeds");
        System.out.println("expectedData = " + expectedData);

        //Send the request and get the response
        Response response = given(spec).body(expectedData).when().post("{first}");
        response.prettyPrint();

        //Do Assertion
        BookingResponsePojo actualData =  response.as(BookingResponsePojo.class);
        System.out.println("actualData = " + actualData);
        assertEquals(200,response.statusCode());
        assertEquals(expectedData.getFirstname(),actualData.getBooking().getFirstname());
        assertEquals(expectedData.getLastname(),actualData.getBooking().getLastname());
        assertEquals(expectedData.getTotalprice(),actualData.getBooking().getTotalprice());
        assertEquals(expectedData.getDepositpaid(),actualData.getBooking().getDepositpaid());
        assertEquals(bookingdates.getCheckin(),actualData.getBooking().getBookingdates().getCheckin());
        assertEquals(bookingdates.getCheckout(),actualData.getBooking().getBookingdates().getCheckout());
        assertEquals(expectedData.getAdditionalneeds(),actualData.getBooking().getAdditionalneeds());



    }
}
/*
"firstname": "Ali",
                "lastname": "Can",
                "totalprice": 999,
                "depositpaid": true,
                "bookingdates": {
                    "checkin": "2021-09-21",
                    "checkout": "2021-12-21"
                 },
                 "additionalneeds": "Breakfast"
 */