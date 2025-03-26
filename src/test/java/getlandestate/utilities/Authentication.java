package getlandestate.utilities;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Authentication {
    public static void main(String[] args) {
        System.out.println(generateToken("admin@gmail.com", "admin123!"));
    }

    public static String generateToken(){

<<<<<<< HEAD
        //set the url    https://medunna.com/api/authenticate
        String url ="http://64.227.123.49:8092/users/login";
        
        //set the payload
        String credentials ="{\n" +
                "  \"email\": \"hasibAdmin@gmail.com\",\n" +
                "  \"password\": \"Kaleem786hasib%\"\n" +
                "}";
        //send request get response
        Response response = given()
=======
        String url="http://64.227.123.49:8092/users/login";
        String credentials = "{\n" +
                "  \"email\": \""+email+"\",\n" +
                "  \"password\": \""+password+"\"\n" +
                "}";

        Response response=given()
>>>>>>> 3ff2aa3263c198ad5daad4c22f6a5a5a85939a7b
                .body(credentials)
                .contentType(ContentType.JSON)
                .when()
                .post(url);
<<<<<<< HEAD
=======

        return response.jsonPath().getString("token");
>>>>>>> 3ff2aa3263c198ad5daad4c22f6a5a5a85939a7b

        //return token
       return response.jsonPath().getString("token");
    }



}