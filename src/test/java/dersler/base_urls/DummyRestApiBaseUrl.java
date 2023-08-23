package dersler.base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class DummyRestApiBaseUrl {

    protected RequestSpecification spec;

    @Before
    public void setUp() throws Exception {
        spec = new RequestSpecBuilder()
                .setBaseUri("https://dummy.restapiexample.com/api/v1")
                .setContentType(ContentType.JSON)
                .build();

    }

    //Her sorguda tekrar eden datalari buraya girecegiz.















































}
