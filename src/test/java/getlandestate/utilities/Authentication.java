package getlandestate.utilities;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Authentication {

    public static String generateToken(){

        //set the url    https://medunna.com/api/authenticate
        String url ="http://64.227.123.49:8092/users/login";
        
        //set the payload
        String credentials ="{\n" +
                "  \"email\": \"hasibAdmin@gmail.com\",\n" +
                "  \"password\": \"Kaleem786hasib%\"\n" +
                "}";
        //send request get response
        Response response = given()
                .body(credentials)
                .contentType(ContentType.JSON)
                .when()
                .post(url);

        //return token
       return response.jsonPath().getString("token");
    }



}