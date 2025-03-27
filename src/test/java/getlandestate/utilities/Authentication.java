package getlandestate.utilities;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.checkerframework.checker.units.qual.C;

import static io.restassured.RestAssured.given;

public class Authentication {

    public static void main(String[] args) {
        System.out.println(generateToken("admin@gmail.com", "admin123!"));
    }
    public static String generateToken(String email, String password){

        String url="http://64.227.123.49:8092/users/login";
        String credentials = "{\n" +
                "  \"email\": \""+email+"\",\n" +
                "  \"password\": \""+password+"\"\n" +
                "}";

        Response response=given()

                .body(credentials)
                .contentType(ContentType.JSON)
                .when()
                .post(url);

        //return token
       return response.jsonPath().getString("token");
    }

}


