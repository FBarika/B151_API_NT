package dersler.test_data;

import java.util.HashMap;
import java.util.Map;

public class HerokuAppTestData {

    public Map<String,String> bookingDatesMapper(String checkin,String checkout){
        Map<String,String> bookingdatesData = new HashMap<>();
        bookingdatesData.put("checkin","2018-01-01");
        bookingdatesData.put("checkout","2019-01-01");
        return bookingdatesData;
    }

    public Map<String,Object> expectedDataMapper(String firstname,String lastname,Integer totalprice,Boolean depositpaid,Map<String,String> bookingdates,String additionalneeds){
        Map<String,Object> expectedData = new HashMap<>();
        if (firstname!=null){
            expectedData.put("firstname", firstname);}
        if (lastname!=null){
            expectedData.put("lastname", lastname);}
        if (totalprice!=null){
            expectedData.put("totalprice", totalprice);}
        if (depositpaid!=null){
            expectedData.put("depositpaid", depositpaid);}
        if (bookingdates!=null){
            expectedData.put("bookingdates", bookingdates);}
        if (additionalneeds != null) {
            expectedData.put("additionalneeds", additionalneeds);
        }
        return expectedData;
    }



}
