package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.RestAssuredConfig;
import io.restassured.filter.Filter;
import io.restassured.http.*;
import io.restassured.mapper.ObjectMapper;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import io.restassured.specification.*;

import java.io.File;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.security.KeyStore;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class BaseUrl {

    public static RequestSpecification spec;

    public static void setUp(String email, String password) {

  /*String baseUri="http://64.227.123.49/";

    spec = new RequestSpecBuilder()
            .setBaseUri(baseUri)
            .setContentType(ContentType.JSON)
           // .addHeader("Authorization")//POSTMAN DE POST LOGIN AUTHORIZATIONA


    }*/


    }


}