package getlandestate.utilities;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Authentication {

    public static String generateToken(){


        String url ="http://64.227.123.49:8092/users/login";

        //set the payload
        String credentials ="{\n" +
                "  \"email\": \"admin@gmail.com\",\n" +
                "  \"password\": \"admin123!\"\n" +
                "}";
        //send request get response
        Response response = given()
                .body(credentials)
                .contentType(ContentType.JSON)
                .when()
                .post(url);

        return response.jsonPath().getString("token");


    }



}