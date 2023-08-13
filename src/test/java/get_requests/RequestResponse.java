package get_requests;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class RequestResponse {
    /*
    NOTLAR:
       1-Manuel Testler icin Postman kullanacagiz
       2-API otomasyon testleri icin REST Assured kütüphanesini kullanacagiz.
       3-Otomasyon kodlarini yazarken su adimlari takip edecegiz.
         a. Gereksinimleri anlama
         b. Test senaryolarini yazma
            i.Test senaryolarini yazarken Gherkin dilini kullanacagiz.
               -Given:Ön kosullar--> Endpoint,body
               -When :Islemler : Get,Post,Put, Delete,...
               -Then :Dönütler : Assertion,Close ...
               -And : Coklu islemlerin yapilacagi zaman kullanilir.
         c.  Otomasyon kodlarini yazarken su adimlari takip ederiz.
                1- Set the URL  = Url'i tanimla
                2- Set the expected data = Beklenen datalari ayarla
                3- Send the raquest and get the response = Istegi gonder ve cevabi al
                4- Do assertion = Dogrulama yap

             200 Success
             300 Redirection
             400 Client Error
             500 Server Error
     */

    //                1- Set the URL  = Url'i tanimla
    //                2- Set the expected data = Beklenen datalari ayarla
    //                3- Send the raquest and get the response = Istegi gonder ve cevabi al
    //                4- Do assertion = Dogrulama yap

         /*
        post ve put islemlerinde request'in body bolumune ihtiyac duyulurken
         get ve delete islemlerinde request'in body bolumune gerek yoktur.
         */


    public static void main(String[] args) {
        String url = "https://petstore.swagger.io/v2/pet/7867";
        Response response = given().when().get(url);
        response.prettyPrint(); //bununla sadece body kismi yaziliyor.

        //Status code nasil yazdirilir?
        int status= response.statusCode();//response.getStatusCode() seklinde de cagirabiliriz.
        System.out.println("Status Code: " + response.statusCode());

        //Content Type nasil yazdirilir?

        System.out.println("Content Type: " + response.contentType());

        //Status Line nasil yazdirilir?
        System.out.println("Status Line: " + response.statusLine());

        //Header bölümündeki bir veri nasil yazdirilir?
        System.out.println("Header | Server: " + response.header("Server"));

        //Headers bölümündeki bir veri nasil yazdirilir?
        System.out.println("Headers | Server: " + response.headers());

        //Time bilgisi nasil yazdirilir?
        System.out.println("Time: " + response.time());

    }


}
