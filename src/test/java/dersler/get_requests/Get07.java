package dersler.get_requests;

import dersler.base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Get07 extends JsonPlaceHolderBaseUrl {

    /*
        Given
           https://jsonplaceholder.typicode.com/todos
        When
           Kullanıcı URL'e bir GET request gönderir
        Then
           1) Status code 200 olmalı
           2) "Id"leri 190 dan büyük olanları konsola yazdırın
              "Id"si 190 dan büyük 10 adet veri olduğunu doğrulayın
           3) "Id"si 5 den küçük olan tüm kullanıcıların "userid"lerini yazdırın
              "Id"si 5 den küçük olan 4 kullanıcı olduğunu doğrulayın
           4) "Id" si 5 ten küçük tüm kullanıcıların "title" larını yazdırın
              "delectus aut autem" başlığının, id numarası 5 den küçük bir kullanıcıya ait olduğunu doğrulayın
     */

    @Test
    public void get07() {

        //Groovy Language
        //Groovy language list icindeki json'lari sorgulama yapip data geri cagirmamizi saglar

        spec.pathParam("first","todos");

        Response response = given(spec).when().get("{first}");
        //response.prettyPrint();

        assertEquals(200,response.statusCode());

        JsonPath json = response.jsonPath();
        //Id"leri 190 dan büyük olanları konsola yazdırın
        List<Object> idList = json.getList("findAll{it.id>190}.id");
        System.out.println("ID List = " + idList);
        //findAll{} bir tablo icinde arama yapmak icin kullaniriz.
        // {} icine item 'in kisaltmasi olan it yazilir ve hangi veriyi istiyorsak onun sartini ekleriz
        //{} icinde sarti koyunca sarta uyan tum veriler gelirken {} den sonra . koyup neyi almak istiyorsak o veriyi yazarsak sadece o veriyi aliriz

        //Id"si 190 dan büyük 10 adet veri olduğunu doğrulayın
        assertEquals(10,idList.size());

        //Id"si 5 den küçük olan tüm kullanıcıların "userid"lerini yazdırın
        List<Integer> userIdList = json.getList("findAll{it.id<5}.userId");
        System.out.println("userIdList = " + userIdList);

        //Id"si 5 den küçük olan 4 kullanıcı olduğunu doğrulayın
        assertEquals(4,userIdList.size());

        //Id" si 5 ten küçük tüm kullanıcıların "title" larını yazdırın
        List<String> titleList = json.getList("findAll{it.id<5}.title");
        System.out.println("titleList = " + titleList);

        //delectus aut autem" başlığının, id numarası 5 den küçük bir kullanıcıya ait olduğunu doğrulayın
        assertTrue(titleList.contains("delectus aut autem"));

        System.out.println(json.getList("findAll{it.title=='delectus aut autem'}.id"));


    }
}
