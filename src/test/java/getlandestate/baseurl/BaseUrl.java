package getlandestate.baseurl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static getlandestate.utilities.Authentication.generateToken;
import static io.restassured.RestAssured.*;

public class BaseUrl {

    public static RequestSpecification spec ;

    public static void setUp(String email, String password){
        String token = generateToken(email, password);
        if (token == null || token.isEmpty()) {
            throw new IllegalStateException("Le token est null ou vide. Vérifiez l'authentification.");
        }

        spec = new RequestSpecBuilder()
                .setBaseUri("http://64.227.123.49:8092/")
                .setContentType(ContentType.JSON)
                .addHeader("Authorization", "Bearer " + token)
                .build();
    }


}