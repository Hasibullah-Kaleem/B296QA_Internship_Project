package getlandestate.utilities;

import io.restassured.http.ContentType;
import io.restassured.response.Response;


import static io.restassured.RestAssured.given;

public class Authentication {

/*
    public static void main(String[] args) {

        System.out.println(generatetoken("boukmanager@gmail.com", "12345678Bouk@"));

        //   System.out.println(token("manager@gmail.com", "manager123!"));
    }
*/
    public static String generateToken(String email, String password) {


        String url = "http://64.227.123.49:8092/users/login";
        String body = "{\"email\": \"" + email + "\",\"password\": \"" + password + "\"}";


        Response response = given()
                .when()
                .body(body)
                .contentType(ContentType.JSON)
                .post(url);


        return response.jsonPath().getString("token");

    }


}