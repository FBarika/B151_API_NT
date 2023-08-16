package dersler.get_requests;

import dersler.base_urls.HerokuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Get06 extends HerokuAppBaseUrl {
    /*
    Given
        https://restful-booker.herokuapp.com/booking/22
    When
        User send a GET request to the URL
    Then
        HTTP Status Code should be 200
    And
        Response content type is “application/json”
    And
        Response body should be like;
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
    public void Get() {

       //1.Set the Url
        spec.pathParams("first","booking",
                "second",22);
        //2.Set excepted data
        //3.Sent rep and get resp

        Response response = given(spec).when().get("{first}/{second}");
        response.prettyPrint();

        //4.Do assertion
        //1.Yol;
        response
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("firstname",equalTo("John"),
                        "lastname",equalTo("Smith"),
                        "totalprice",equalTo(111),
                        "depositpaid",equalTo(true),
                        "bookingdates.checkin",equalTo("2018-01-01"),
                        "bookingdates.checkout",equalTo("2019-01-01"),
                        "additionalneeds",equalTo("Lunch"));


        //response da sadece body'yi degil header'i daki verileri de hem soft hem hard assertion ile test edebiliriz

        //2.Yol;
        JsonPath json = response.jsonPath(); //response u jsonPath() methodu kullanarak JsonPath data cesidine dönüstürdük.
                                             //jsonpath datasindan response da datalara kolayca ulasabilirim.
       // System.out.println(json.getString("firstname"));
        assertEquals("John",json.getString("firstname"));
        assertEquals("Smith",json.getString("lastname"));
        assertEquals(111,json.getInt("totalprice"));
        assertTrue(json.getBoolean("depositpaid"));
        assertEquals("2018-01-01",json.getString("bookingdates.checkin"));
        assertEquals("2019-01-01",json.getString("bookingdates.checkout"));
        assertEquals("Lunch",json.getString("additionalneeds"));
        //jsonPath() de datamizi String'e Int'e List'e vs. cevirip ilerde get islemlerinde ve dogrulama yaparken kullanabiliriz

        //3.Yol(softAssertion)
        //Soft asserts TestNg ile gelen bir ozellik oldugu icin TestNg pom'a yuklenmeli
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(json.getString("firstname"),"John");
        softAssert.assertEquals(json.getString("lastname"),"Smith");
        softAssert.assertEquals(json.getInt("totalprice"),111);
        softAssert.assertTrue(json.getBoolean("depositpaid"));
        softAssert.assertEquals(json.getString("bookingdates.checkin"),"2018-01-01");
        softAssert.assertEquals(json.getString("bookingdates.checkout"),"2019-01-01");
        softAssert.assertEquals(json.getString("additionalneeds"),"Lunch");

        softAssert.assertAll();


    }



























}
