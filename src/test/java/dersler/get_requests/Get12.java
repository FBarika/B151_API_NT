package dersler.get_requests;

import dersler.base_urls.GoRestBaseUrl;
import dersler.pojos.GoRestDataPojo;
import dersler.pojos.GoRestPojo;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get12 extends GoRestBaseUrl {
    /*
      Given
          https://gorest.co.in/public/v1/users/4495565
      When
          User send GET Request to the URL
      Then
          Status Code should be 200
      And
          Response body should be like
        {
          "meta": null,
          "data": {
                "id": 4495565,
                "name": "Chidaatma Patil",
                "email": "patil_chidaatma@greenfelder.test",
                "gender": "female",
                "status": "inactive"
          }
      }
  */

    @Test
    public void get12() {

        //Set the Url
        spec.pathParams("first","users","second",4495565);

        //Set the expected data
        GoRestDataPojo goRestData = new GoRestDataPojo("Chidaatma Patil","patil_chidaatma@greenfelder.test","female","inactive");
        GoRestPojo expectedData = new GoRestPojo(null,goRestData);
        System.out.println("expectedData = " + expectedData);


        //Send the request and get the response
        Response response = given(spec).when().get("{first}/{second}");
        response.prettyPrint();

        //Do Assertion
        GoRestPojo actualData = response.as(GoRestPojo.class);
        System.out.println("actualData = " + actualData);
        assertEquals(200,response.statusCode());
        assertEquals(expectedData.getMeta(),actualData.getMeta());
        assertEquals(goRestData.getName(),actualData.getData().getName());
        assertEquals(goRestData.getEmail(),actualData.getData().getEmail());
        assertEquals(goRestData.getGender(),actualData.getData().getGender());
        assertEquals(goRestData.getStatus(),actualData.getData().getStatus());

    }
}
