import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class Get01 {

    /*
    1. Postman manuel API testi icin kullaniyoruz.
    2. REST-Assured Library otomasyon testi icin kullaniyoruz.
    3. Otomasyon kodlarinin yazimi icin su adimlari izliyoruz:
         a. Gereksinimleri anlama
         b. Test case'i yazma
              - Test case yazimi icin "Gherkin Language" kullaniyoruz.
              - "Gherkin" bazi keywordlere sahip, bunlar:
                 * Given: On kosullar
                 * When: Aksiyonlar--> Get, Put, ...
                 * Then: Donutler--> Dogrulama, response, ...
                 * And: Coklu islemler icin kullanilir.
         c. Testing kodunun yazimi
              - Set the URL
              - Set the expected data(POT-PUT-PATC)
              - Type code to request
              - Do Assertion
    */

    /*
        Given
            https://restful-booker.herokuapp.com/booking/3
        When
            User sends a GET Request to the url
        Then
            HTTP Status Code should be 200
        And
            Content Type should be JSON
        And
            Status Line should be HTTP/1.1 200 OK
     */
    @Test
    public void get01(){
        //  - Set the URL
        String url="https://restful-booker.herokuapp.com/booking/555";
        //  - Set the expected data(POT-PUT-PATC)

        //  - Type code to request
        Response response =given().when().get(url);
        response.prettyPrint();

        //  - Do Assertion
        response.then().assertThat().statusCode(200).contentType("application/json").statusLine("HTTP/1.1 200 OK");

        // "Status Code" nasil yazdirilir:
        System.out.println(response.statusCode());

        // "Content Type" nasil yazdirilir:
        System.out.println(response.contentType());

        // "Status Line" nasil yazdirilir:
        System.out.println(response.statusLine());

        // "Header" nasil yazdirilir:
        System.out.println(response.header("User-Agent"));

        // "Headers" nasil yazdirilir:
        System.out.println(response.headers());

        // "Time" nasil yazdirilir:
        System.out.println(response.getTime());


    }
}
