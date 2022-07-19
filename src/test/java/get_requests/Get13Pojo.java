package get_requests;

import base_urls.GoRestBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.GoRestDataPojo;
import pojos.GoRestResponseBodyPojo;

import static io.restassured.RestAssured.*;

public class Get13Pojo extends GoRestBaseUrl {

    /*
    Given
            https://gorest.co.in/public/v1/users/2508
        When
            User send GET Request to the URL
        Then
            Status Code should be 200
        And
            Response body should be like
            {
    "meta": null,
    "data": {
        "id": 2508,
        "name": "Akshita Nehru",
        "email": "nehru_akshita@jast.info",
        "gender": "female",
        "status": "active"
    }
}
     */

    @Test
    public void getPojo01() {

        //1. Step: Set the Url
        spec.pathParams("first", "users", "second", 2508);

        //2. Step: Set the expected data
        GoRestDataPojo goRestDataPojo = new GoRestDataPojo(2508,"Akshita Nehru","nehru_akshita@jast.info","female","active");
        GoRestResponseBodyPojo goRestResponseBodyPojo=new GoRestResponseBodyPojo(null, goRestDataPojo);

        //3. Step: Send Post Request and get the Response
        Response response=given().spec(spec).when().get("/{first}/{users}");
        response.prettyPrint();
    }
}
