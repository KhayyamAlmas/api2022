package get_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import org.junit.Test;

public class Get09 extends JsonPlaceHolderBaseUrl {
    /*
        Given
        https://restful-booker.herokuapp.com/booking/91
        When
        I send GET Request to the url
                Then
        Response body should be like that;
        {
            "firstname": "James",
                "lastname": "Brown",
                "totalprice": 111,
                "depositpaid": true,
                "bookingdates": {
            "checkin": "2018-01-01",
                    "checkout": "2019-01-01"
        },
            "additionalneeds": "Breakfast"
        }
        */
    @Test
    public void get01() {

        //1. Step: Set the Url
        spec.pathParams("first", "todos", "second", 91);

        //2. Step: Set the expected data

    }
}
