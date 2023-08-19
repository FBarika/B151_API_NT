package dersler.post_requests;

import dersler.base_urls.JsonPlaceHolderBaseUrl;
import dersler.pojos.JsonPlaceHolderPojo;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Post03 extends JsonPlaceHolderBaseUrl {

    /*
    Given
       1) https://jsonplaceholder.typicode.com/todos
       2)  {
             "userId": 55,
             "title": "Tidy your room",
             "completed": false
           }
    When
        I send POST Request to the Url
    Then
        Status code is 201
    And
        response body is like
        {
            "userId": 55,
            "title": "Tidy your room",
            "completed": false,
            "id": 201
        }
     */

    @Test
    public void post03() {

        //Set the Url
        spec.pathParam("first","todos");

        //Set the expected data
        JsonPlaceHolderPojo expectedData = new JsonPlaceHolderPojo(55,"Tidy your room",false);

        //Send the request and get the response
        Response response = given(spec).body(expectedData).when().post("{first}");
        response.prettyPrint();

        //Do Assertion
        JsonPlaceHolderPojo actualData = response.as(JsonPlaceHolderPojo.class);
        assertEquals(201,response.statusCode());
        assertEquals(expectedData.getUserId(),actualData.getUserId());
        assertEquals(expectedData.getTitle(),actualData.getTitle());
        assertEquals(expectedData.getCompleted(),actualData.getCompleted());

    }

    /*

Biz intellij de hem UI(Selenium ile) - Api(Rest Assured ile ) - Database(JDBC ile) testi yapabiliriz

Postman da otomasyon yapilabilir. Lakin postman de sadece Api Testi yaparken Intellij de E2E testi yapabiliriz
UI Testi ---> API Testi ---> Database Testi === E2E TEST
 */
}
