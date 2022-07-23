package delete_request;

import base_urls.DummyRestApiBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.DummyApiDataPojo;
import pojos.DummyApiResponseBodyPojo;
import pojos.DummyRestApiDeletePojo;
import utils.JsonUtil;

import static io.restassured.RestAssured.*;
import static junit.framework.TestCase.*;

public class Delete02 extends DummyRestApiBaseUrl {

    /*
    URL: https://dummy.restapiexample.com/api/v1/delete/2
   HTTP Request Method: DELETE Request
   Test Case: Type by using Gherkin Language
   Assert:     i) Status code is 200
           ii) "status" is "success"
          iii) "data" is "2"
           iv) "message" is "Successfully! Record has been deleted"
     */
    /*
    Given
        https://dummy.restapiexample.com/api/v1/update/21
    When
        User sends the DELETE Request
    Then
        Status code is 200
    And
       "status" is "success"
    And
       "data" is "2"
    And
       "message" is "Successfully! Record has been deleted"
     */

    @Test
    public void delete01(){
        spec.pathParams("first", "delete", "second", 2);

        DummyRestApiDeletePojo expectedData = new DummyRestApiDeletePojo("success", "2", "Successfully! Record has been deleted");
        Response response = given().spec(spec).when().delete("/{first}/{second}");
        DummyRestApiDeletePojo actualData = JsonUtil.convertJsonToJavaObject(response.asString(), DummyRestApiDeletePojo.class);
        assertEquals(expectedData.getStatus(), actualData.getStatus());
        assertEquals(expectedData.getData(), actualData.getData());
        assertEquals(expectedData.getMessage(), actualData.getMessage());
    }
}
