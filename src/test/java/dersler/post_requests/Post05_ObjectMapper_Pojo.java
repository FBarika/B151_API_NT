package dersler.post_requests;

import com.fasterxml.jackson.databind.ObjectMapper;
import dersler.base_urls.JsonPlaceHolderBaseUrl;
import dersler.pojos.JsonPlaceHolderPojo;


import dersler.utils.ObjectMapperUtils;
import io.restassured.response.Response;
import org.junit.Test;

import static dersler.utils.ObjectMapperUtils.convertJsonToJava;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Post05_ObjectMapper_Pojo extends JsonPlaceHolderBaseUrl {

    /*
        Given
            1) https://jsonplaceholder.typicode.com/todos
            2) {
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
    public void post05() {

        //Set the Url
        spec.pathParam("first","todos");

        //Set the expected data
        JsonPlaceHolderPojo expectedData = new JsonPlaceHolderPojo(55,"Tidy your room",false);
        System.out.println("expectedData = " + expectedData);

        //Set the request and get the response
        Response response =given(spec).body(expectedData).when().post("{first}");
        response.prettyPrint();

        //Do Assertion
        JsonPlaceHolderPojo actualData = convertJsonToJava(response.asString(),JsonPlaceHolderPojo.class);
        assertEquals(201,response.statusCode());
        assertEquals(expectedData.getUserId(),actualData.getUserId());
        assertEquals(expectedData.getTitle(),actualData.getTitle());
        assertEquals(expectedData.getCompleted(),actualData.getCompleted());



    }
}
