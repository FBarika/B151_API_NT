package dersler.base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

import static dersler.utils.AuthenticationHerokuApp.generateToken;

public class GmiBankBaseUrl {

    protected RequestSpecification spec;

    @Before
    public void setUp() throws Exception {
        spec = new RequestSpecBuilder()
                .setBaseUri("https://gmibank.com")
                .setContentType(ContentType.JSON)
                .addHeader("Authorization","Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJtYXJrX3R3YWluIiwiYXV0aCI6IlJPTEVfQURNSU4sUk9MRV9NQU5BR0VSIiwiZXhwIjoxNjkzMzg4MTU3fQ.150AW4RSZvIdQwqaiIuFyyRlK-f76d5x6nyvzFE-juxIF0rm_lM4RGUBW-3AuyUKYVIv3e6pd1hzncfsyZy6Sg")
                .build();

    }

    /*
API Testlerinde Base URL Kullanımı ve Faydaları
    Bir API testini yazarken, sıklıkla aynı temel URL'yi (Base URL) kullanmamız gerekebilir.
    Base URL, API servisimize ulaşmak için kullanılan temel adresi temsil eder.
    Bu durumda, aynı Base URL'yi her test metodu içinde tekrar tekrar belirtmek yerine, kodunuzun daha düzenli,
    okunabilir ve yönetilebilir olması için "Base URL" olarak adlandırdığımız bir yapı oluşturabiliriz.

Bu Yapının Faydaları:
    Daha Az Tekrarlama: Her test metodu içinde aynı Base URL'yi yazmak yerine, bu yapıyı kullanarak
    sadece bir kez tanımlarsınız. Bu da kodunuzu daha az tekrarlamalı hale getirir ve bakımı kolaylaştırır.

    Daha Düzenli ve Okunabilir Kod: Test metotlarınızın içeriği daha temiz ve okunabilir olur çünkü her seferinde
    Base URL'yi düşünmek zorunda kalmazsınız.

    Değişiklik Yönetimi: Eğer Base URL değişirse, sadece bu yapıyı güncellemek yeterlidir.
    Tüm test metotlarını tek tek değiştirmek zorunda kalmazsınız.

Bu metodun içerisinde kullanılabilecek metotlar:
    setAccept(), setContentType(), setAuth() gibi..
 */















































}
