package delete_request;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class Delete01 extends JsonPlaceHolderBaseUrl {

    /*
    Given
            https://jsonplaceholder.typicode.com/todos/198
        When
	 		I send DELETE Request to the Url
	 	Then
		 	Status code is 200
		 	And Response body is { }
     */

    @Test
    public void delete01(){
        //1. Set the Url
        spec.pathParams("first", "todos", "second", 198);

        //2. Step: Set the expected data get the Response
        Map<String,Object> expectedDataMap=new HashMap<>();

        //3. Step: Send the Delete Request and get the Response
        Response response =given().spec(spec).when().delete("/{first}/{second}");
        response.prettyPrint();

        //4. Step: Do Assertion
        //1. Yol
        Map<String,Object> actualMap= response.as(HashMap.class);
        response.then().assertThat().statusCode(200);
        assertEquals(actualMap,expectedDataMap);


        //2. Yol
        assertTrue(actualMap.size()==0);
        assertTrue(actualMap.isEmpty()); //Tavsiye edilen

        //Delete request yapmadan once "Post request" yapip o datayi silmeliyiz.
    }
}
