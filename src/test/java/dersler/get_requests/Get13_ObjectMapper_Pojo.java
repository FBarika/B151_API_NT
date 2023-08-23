package dersler.get_requests;

import dersler.base_urls.JsonPlaceHolderBaseUrl;
import dersler.pojos.JsonPlaceHolderPojo;
import io.restassured.response.Response;
import org.junit.Test;

import static dersler.test_data.JsonPlaceHolderTestData.convertJsonToString;
import static dersler.utils.ObjectMapperUtils.convertJsonToJava;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get13_ObjectMapper_Pojo extends JsonPlaceHolderBaseUrl {

     /*
        Given
            https://jsonplaceholder.typicode.com/todos/198
        When
            I send GET Request to the URL
        Then
            Status code is 200
        And response body is like
            {
                "userId": 10,
                "id": 198,
                "title": "quis eius est sint explicabo",
                "completed": true
            }
    */

    @Test
    public void get13() {

        //Set the Url
        spec.pathParams("first", "todos", "second", 198);

        //Set the expected data
        String body = convertJsonToString(10,"quis eius est sint explicabo",true);
        JsonPlaceHolderPojo expectedData = convertJsonToJava(body, JsonPlaceHolderPojo.class);
        System.out.println("expectedData = " + expectedData);

        //Send the request and get the response
        Response response = given(spec).when().get("{first}/{second}");
        response.prettyPrint();

        //Do Assertion
        JsonPlaceHolderPojo actualData = convertJsonToJava(response.asString(),JsonPlaceHolderPojo.class);
        System.out.println("actualData = " + actualData);

        assertEquals(200,response.statusCode());
        assertEquals(expectedData.getUserId(),actualData.getUserId());
        assertEquals(expectedData.getTitle(),actualData.getTitle());
        assertEquals(expectedData.getCompleted(),actualData.getCompleted());

    }







    }
