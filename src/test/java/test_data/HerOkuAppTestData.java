package test_data;

import pojos.BookingDatesPojo;
import pojos.BookingPojo;

import java.util.HashMap;
import java.util.Map;

public class HerOkuAppTestData {

    public Map<String,String> bookingDatesSetUp(String checkin, String checkout){

        Map<String,String> bookingDatesMap = new HashMap<>();
        bookingDatesMap.put("checkin",checkin);
        bookingDatesMap.put("checkout",checkout);

        return bookingDatesMap;
    }
    public Map<String,Object> expectedDateSetUp(String firstname, String lastname, int totalprice, boolean depositpaid, Map<String,String> bookingdates){

        Map<String,Object> expectedDataMap = new HashMap<>();
        expectedDataMap.put("firstname",firstname);
        expectedDataMap.put("lastname",lastname);
        expectedDataMap.put("totalprice",totalprice);
        expectedDataMap.put("depositpaid",depositpaid);
        expectedDataMap.put("bookingdates",bookingdates);

        return expectedDataMap;
    }
    public String expectedDataInString(String firstname, String lastname, Integer totalprice, Boolean depositpaid, String checkin,String checkout, String additionalneeds){
        String expectedData=" {\n" +
                "    \"firstname\": \"Oliver\",\n" +
                "    \"lastname\": \"Smith\",\n" +
                "    \"totalprice\": 100,\n" +
                "    \"depositpaid\": true,\n" +
                "    \"bookingdates\": {\n" +
                "        \"checkin\": \"2022-07-18\",\n" +
                "        \"checkout\": \"2022-07-19\"\n" +
                "    },\n" +
                "    \"additionalneeds\": \"Breakfast\"\n" +
                "}";
        return expectedData;
    }
}
