package get_requests;

import base_urls.GoRestBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.GoRestTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class Get10 extends GoRestBaseUrl {
    /*
        Given
            https://gorest.co.in/public/v1/users/2980
        When
            User send GET Request to the URL
        Then
            Status Code should be 200
        And
            Response body should be like
 {
    "meta": null,
    "data": {
        "id": 2980,
        "name": "The Hon. Kalpana Sinha",
        "email": "sinha_the_kalpana_hon@schmeler-koss.biz",
        "gender": "male",
        "status": "active"
    }
}
     */

    @Test
    public void get01(){

        //1. Step: Set the Url
        spec.pathParams("first", "users", "second",2986);

        //2. Step: Set the expected data
        GoRestTestData dataKey = new GoRestTestData();
        Map<String, String> dataKeyMap = dataKey.dataKeyMap("The Hon. Kalpana Sinha","sinha_the_kalpana_hon@schmeler-koss.biz","male","active");

        Map<String , Object> expectedData = dataKey.expectedDataMap(null,dataKeyMap);


        //3. Step: Send the request and get the response

        Response response = given().spec(spec).when().get("/{first}/{second}");

        Map<String, Object> actualDataMap = response.as(HashMap.class);

        //4. Step: Do Assertion

        assertEquals(expectedData.get("meta"),actualDataMap.get("meta"));
        assertEquals(dataKeyMap.get("name"),((Map)actualDataMap.get("data")).get("name"));
        assertEquals(dataKeyMap.get("email"),((Map)actualDataMap.get("data")).get("email"));
        assertEquals(dataKeyMap.get("gender"),((Map)actualDataMap.get("data")).get("gender"));
        assertEquals(dataKeyMap.get("status"),((Map)actualDataMap.get("data")).get("status"));



    }
}
