package get_requests;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;
import pojos.BookingPojo;
import test_data.HerOkuAppTestData;
import utils.JsonUtil;

import static io.restassured.RestAssured.*;
import static junit.framework.TestCase.assertEquals;

public class Get15ObjectMapper extends HerOkuAppBaseUrl {
    /*
    Given
	            https://restful-booker.herokuapp.com/booking/2
        When
		 		I send GET Request to the URL
		Then
		 		Status code is 200
                {
    "firstname": "Oliver",
    "lastname": "Smith",
    "totalprice": 100,
    "depositpaid": true,
    "bookingdates": {
        "checkin": "2022-07-18",
        "checkout": "2022-07-19"
    },
    "additionalneeds": "Breakfast"
}
     */

    @Test
    public void get01(){

        //1. Step: Set the Url
        spec.pathParams("first", "booking", "second", 22);

        //2. Step: Set the expected data
        HerOkuAppTestData herOkuAppTestData=new HerOkuAppTestData();
        String expectedData= herOkuAppTestData.expectedDataInString("Oliver","Smith",100,true,"2022-07-18","2022-07-19","Breakfast");
        BookingPojo expectedDataPojo= JsonUtil.convertJsonToJavaObject(expectedData,BookingPojo.class);

        //3. Step: Send Post Request and get the Response
        Response response =given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        //4. Step: Do Assertion
        BookingPojo actualDataPojo=JsonUtil.convertJsonToJavaObject(response.asString(),BookingPojo.class);

        //Hard Assertion
    /*  assertEquals(200,response.getStatusCode());
        assertEquals(expectedDataPojo.getFirstname(),actualDataPojo.getFirstname());
        assertEquals(expectedDataPojo.getLastname(),actualDataPojo.getLastname());
        assertEquals(expectedDataPojo.getTotalprice(),actualDataPojo.getTotalprice());
        assertEquals(expectedDataPojo.getDepositpaid(),actualDataPojo.getDepositpaid());
        assertEquals(expectedDataPojo.getAdditionalneeds(),actualDataPojo.getAdditionalneeds());
        assertEquals(expectedDataPojo.getBookingdates().getCheckin(),actualDataPojo.getBookingdates().getCheckin());
        assertEquals(expectedDataPojo.getBookingdates().getCheckout(),actualDataPojo.getBookingdates().getCheckout());

    */

        //Soft Assertion

        //1. Adim: SoftAssert objesi olustur
        SoftAssert softAssert = new SoftAssert();

        //2. Adim: Assertion yap
        softAssert.assertEquals(actualDataPojo.getFirstname(),expectedDataPojo.getFirstname(), "firstname uyusmadi");
        softAssert.assertEquals(actualDataPojo.getLastname(),expectedDataPojo.getLastname(), "lastname uyusmadi");
        softAssert.assertEquals(actualDataPojo.getTotalprice(),expectedDataPojo.getTotalprice(), "total price uyusmadi");
        softAssert.assertEquals(actualDataPojo.getDepositpaid(),expectedDataPojo.getDepositpaid(), "depositpaid uyusmadi");
        softAssert.assertEquals(actualDataPojo.getAdditionalneeds(),expectedDataPojo.getAdditionalneeds(), "additionalneeds uyusmadi");
        softAssert.assertEquals(actualDataPojo.getBookingdates().getCheckin(),expectedDataPojo.getBookingdates().getCheckin(), "checkin uyusmadi");
        softAssert.assertEquals(actualDataPojo.getBookingdates().getCheckout(),expectedDataPojo.getBookingdates().getCheckout(), "checkout uyusmadi");

        //3. Adim: assertAll() methodunu calistir
        softAssert.assertAll();

    }
}
