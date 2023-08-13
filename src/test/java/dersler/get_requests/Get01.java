package dersler.get_requests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Get01 {

       /*
            Given
                https://restful-booker.herokuapp.com/booking/1
            When
                Kullanıcı URL'e bir GET request gönderir
            Then
                HTTP Status Code 200 olmalı
            And
                Content Type "application/json" olmalı
            And
                Status Line "HTTP/1.1 200 OK" olmalı
        */
    //given() kismi testin basinda request'in hazirlanmasi asamasidir. Testin temel kosullarinin hazirlanmasi
    //when() kismi olusturulan kosullarin eyleme gecirilip gerceklesmesi

    @Test
    public void get01() {

        //1.Yöntem
        String url ="https://restful-booker.herokuapp.com/booking/1";

        //2.Yöntem
        //baseURI kismi degismezken basePath kismi degisebilir
        RestAssured.baseURI="https://restful-booker.herokuapp.com";
        RestAssured.basePath="/booking/1";
        //Burada get() methodunun icinde String deki gibi url yazmadan Restassured odlariyla bütün halinde calisir.

        Response response = given().when().get();//Response icine koymamizin sebebi gelen veriyi yazdirmak
        response.prettyPrint();


        //given() kismi testin basinda request'in hazirlanmasi asamasidir. Testin temel kosullarinin olusturdugumuz adimdir.
        // Orn: Rezervasyon bilgilerini siteye girme islemi

        //when() kismi olusturulan kosullarin eyleme gecirilip gerceklesmesi adimidir. get,put, post islemleri gibi...
        //Orn: Rezervasyonu onayla butonuna tiklanmasi

        //then() kismi eylemin sonuclarini kontrol etme islemidir, dogrulanmasidir.
        // Onceden belirlenen beklentilerin karsidan gelen cevaplarla karsilastirilmasi islemidir.
        // Orn:Rezervasyonunuz onaylanmistir mesajinin gorulmesi

        response.
                then().
                statusCode(200).        //status kodu dogruladik. Veriyi basarili bir sekilde getirdik. Islem olumlu
                contentType("application/json").    //Bize gelen verinin Json formatinda veridigni gösteriyor   .Bunu dogruladik
                statusLine("HTTP/1.1 200 OK");      //Bize status kodun detaylarini (protokolu, versiyon numarasini ve durum kodunu) veriyor.


    }
}
