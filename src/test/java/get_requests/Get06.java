package get_requests;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.Matchers.*;

public class Get06 extends HerOkuAppBaseUrl {
    /*
        Given
            https://restful-booker.herokuapp.com/booking/2
        When
            User send a GET request to the URL
        Then
            HTTP Status Code should be 200
        And
            Response content type is “application/json”
        And
            Response body should be like;
             {
                {
    "firstname": "Jim",
    "lastname": "Smith",
    "totalprice": 554,
    "depositpaid": true,
    "bookingdates": {
        "checkin": "2020-07-30",
        "checkout": "2022-04-24"
    }
}
     */
    @Test
    public void get01() {

        // 1. Step: Set the Url

        // https://restful-booker.herokuapp.com/booking/5
        spec.pathParams("first","booking","second", 6);

        // 2. Step: Set the expected data

        // 3. Step: Set the request and get response
        Response response= given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        // 4. Step: Do Assertion
        // 1. Yol
      /*  response.
                then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("firstname", equalTo("Jim"),
                        "lastname",equalTo("Smith"),
                        "totalprice",equalTo(554),
                        "depositpaid",equalTo(true),
                        "bookingdates.checkin", equalTo("2020-07-30"),
                        "bookingdates.checkout", equalTo("2021-10-01"));*/

        // 2. Yol: JsonPath Class kullanilir
        JsonPath json=response.jsonPath();
     /*   assertEquals("Jim",json.getString("firstname"));
        assertEquals("Smith",json.getString("lastname"));
        assertEquals(554,json.getInt("totalprice"));
        assertEquals(true,json.getBoolean("depositpaid"));
        assertEquals("2020-07-30",json.getString("bookingdates.checkin"));
        assertEquals("2021-10-01",json.getString("bookingdates.checkout")); */

        // 3. Yol: Soft Assertion
        // Soft Assertion icin 3 adim izlenir;

        // 1) SoftAssert Objesi olusturulur.
        SoftAssert softAssert = new SoftAssert();

        // 2) Obje araciligi ile assert yapilir.
        softAssert.assertEquals(json.getString("firstname"), "Jim", "firstname uyusmadi");
        softAssert.assertEquals(json.getString("lastname"), "Smith", "lastname uyusmadi");
        softAssert.assertEquals(json.getInt("totalprice"), 554, "totalprice uyusmadi");
        softAssert.assertEquals(json.getBoolean("depositpaid"), true, "depositpaid uyusmadi");
        softAssert.assertEquals(json.getString("bookingdates.checkin"), "2020-07-30", "checkin uyusmadi");
        softAssert.assertEquals(json.getString("bookingdates.checkout"), "2021-10-01", "checkout uyusmadi");

        // 3) assertAll() methodu kullanilir. Aksi taktirde kod her zaman pass olur.
        softAssert.assertAll();

    }
}