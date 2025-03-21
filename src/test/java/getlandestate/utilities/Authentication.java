package getLandEstate.utilities;

import io.restassured.http.ContentType;

import javax.imageio.stream.ImageInputStream;

import static io.restassured.RestAssured.given;

public class Authentication {



    public static void main(String[] args) {

        System.out.println(token("admin@gmail.com", "admin123!"));

     //   System.out.println(token("manager@gmail.com", "manager123!"));
    }

    public static String token(String email, String password){


        String url= "http://64.227.123.49:8092/users/login";
        String body ="{\"email\": \""+email+"\",\"password\": \""+password+"\"}";


     return  given()
             .when()
             .body(body)
             .contentType(ContentType.JSON)
             .post(url)
             .jsonPath()
             .getString("token");


    }


}