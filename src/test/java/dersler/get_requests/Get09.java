package dersler.get_requests;

import dersler.base_urls.HerokuAppBaseUrl;
import dersler.base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get09 extends HerokuAppBaseUrl {
    /*
    Given
        https://restful-booker.herokuapp.com/booking/91
    When
        I send GET Request to the url
    Then
        Response body should be like that;
            {
                "firstname": "John",
                "lastname": "Smith",
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
    public void Get09() {

        //Set the Url
        spec.pathParams("first","booking","second",91);

        //Set the expected data
        Map<String,String> bookingdatesData = new HashMap<>();
        bookingdatesData.put("checkin","2018-01-01");
        bookingdatesData.put("checkout","2019-01-01");
        System.out.println("bookingdatesData = " + bookingdatesData);

        Map<String,Object> expectedData = new HashMap<>();
        expectedData.put("firstname","John");
        expectedData.put("lastname","Smith");
        expectedData.put("totalprice",111);
        expectedData.put("depositpaid",true);
        expectedData.put("bookingdates",bookingdatesData);
        expectedData.put("additionalneeds","Breakfast");
        System.out.println("expectedData = " + expectedData);

        //Send request and get the response
        Response response = given(spec).when().get("{first}/{second}");
        response.prettyPrint();

        //Do Assertion
        Map<String,Object> actualData = response.as(HashMap.class);
        assertEquals(expectedData.get("firstname"),actualData.get("firstname"));
        assertEquals(expectedData.get("lastname"),actualData.get("lastname"));
        assertEquals(expectedData.get("totalprice"),actualData.get("totalprice"));
        assertEquals(expectedData.get("depositpaid"),actualData.get("depositpaid"));
        assertEquals(expectedData.get("additionalneeds"),actualData.get("additionalneeds"));
        assertEquals(bookingdatesData.get("checkin"),((Map)actualData.get("bookingdates")).get("checkin"));
        assertEquals(bookingdatesData.get("checkout"),((Map)actualData.get("bookingdates")).get("checkout"));



        //Object obj = new HashMap();
        //((Map)obj).get("sda"); type casting yapiyoruz.





    }
}
