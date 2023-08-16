package post_requests;

import dersler.base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

public class Post01 extends JsonPlaceHolderBaseUrl {

    /*
    Given
       1) https://jsonplaceholder.typicode.com/todos
       2)  {
             "userId": 55,
             "title": "Tidy your room",
             "completed": false
           }
        When
            Kullanıcı URL'e bir POST request gönderir
        Then
            Status code 201 olmalı
        And
            Response şu şekilde olmalı:
            {
                "userId": 55,
                "title": "Tidy your room",
                "completed": false,
                "id": 201
            }
     */

    @Test
    public void post01() {

        //1.Set the Url
        spec.pathParam("first","todos");

        //2.Set the expected data
        String payLoad="{\n" +
                "    \"userId\": 55,\n" +
                "    \"title\": \"Tidy your room\",\n" +
                "    \"completed\": false\n" +
                "}";

        //3.Send the request and get the response
        Response response =given(spec).body(payLoad).when().post("{first}");
        response.prettyPrint();

        //4.Do assertion

        assertEquals(201,response.statusCode());
        JsonPath json = response.jsonPath();
        assertEquals(55,json.getInt("userId"));
        assertEquals("Tidy your room",json.getString("title"));
        assertTrue(json.getBoolean("completed"));
        assertEquals(201,json.getInt("id"));






    }

    @Test
    public void post01Map() {

        //1.Set the Url
        spec.pathParam("first","todos");

        //2.Set the expected data
        Map<String,Object> expectedData = new HashMap<>();
        expectedData.put("userId",55);
        expectedData.put("title","Tidy your room");
        expectedData.put("completed",false);
        System.out.println(expectedData);

        //3.Send the request and get the response
        Response response =given(spec).body(expectedData).when().post("{first}");
        //Serialization=Java map datasinin Json datasina cevrilmesi
        response.prettyPrint();

        //4.Do assertion
        Map<String,Object> actualData = response.as(HashMap.class);
        // De-Serialization = Json objesinin Java Map objesine çevrilmesidir.
        //Biz map gondermeye calisiyoruz karsi taraf json data bekliyor. Bu nedenle IllegalStateException aliriz.
        //Serialization icin (veri donusumu) Jackson (Databind) eklentisini pom a yukleyerek handle edebiliriz

       assertEquals(201,response.statusCode());
       assertEquals(expectedData.get("userId"),actualData.get("userId"));
       assertEquals(expectedData.get("title"),actualData.get("title"));
       assertEquals(expectedData.get("completed"),actualData.get("completed"));


    }
}
