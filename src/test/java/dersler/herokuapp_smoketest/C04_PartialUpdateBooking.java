package dersler.herokuapp_smoketest;

import dersler.base_urls.HerokuAppBaseUrl;
import dersler.test_data.HerokuAppTestData;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static dersler.herokuapp_smoketest.C01_CreateBooking.bookingid;
import static dersler.utils.ObjectMapperUtils.convertJsonToJava;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C04_PartialUpdateBooking extends HerokuAppBaseUrl {

    /*
    Given
      https://restful-booker.herokuapp.com/booking/:id
    And
      {
    "firstname" : "Ali",
    "lastname" : "Can"
       }
     When
      Kullanici PATCH request gönderir
     Then
      Status Code =200
     And
      {
    "firstname" : "Ali",
    "lastname" : "Can",
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
    public void partialUpdateBooking() {
        //Set the Url
        spec.pathParams("first","booking","second",bookingid);

        //Set the expected data
        //patch çok yapılmıyor ama patch için map çok uyumlu pojo kullanmadik o yüzden map kullandgimiz methodu kullandik.
        HerokuAppTestData obj = new HerokuAppTestData();
        Map<String,Object> expectedData = obj.expectedDataMapper("Ali","Can",null,null,null,null);

        //Send the request
        Response response = given(spec).body(expectedData).when().patch("{first}/{second}");
        response.prettyPrint();

        //Do Assertion
        Map<String,String> actualData = convertJsonToJava(response.asString(), HashMap.class);
        assertEquals(200,response.statusCode());
        assertEquals(expectedData.get("firstname"),actualData.get("firstname"));
        assertEquals(expectedData.get("lastname"),actualData.get("lastname"));



        /*
        Burda patch islemi ile sadece bir bolumu degistirdigimiz icin diger bolumleri
         null olarak yazdik. expectedDataMapper() methodunda zaten Parametrelerin null gelme ihtimaline
         karsi if li ifadeleri olusturduk. Patch islemi icin diye belirtmistik
         */


    }
}
