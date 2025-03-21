package getlandestate.utilities;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.checkerframework.checker.units.qual.C;

import static io.restassured.RestAssured.given;

public class Authentication {

    public static String generateToken(String email, String password) {

        String url="http://64.227.123.49:8892/users/login";
        String credentials = "";


        Response response=given().when().contentType(ContentType.JSON).body(credentials).post(url);

        return response.jsonPath().getString("token");

    }


}
