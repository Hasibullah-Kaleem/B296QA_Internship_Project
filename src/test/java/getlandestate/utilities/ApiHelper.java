package getLandEstate.utilities;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;

public class ApiHelper {

    public static Response sendGetRequest(RequestSpecification spec, String endpoint) {
        return given(spec).when().get(endpoint);
    }

    public static Response sendPostRequest(RequestSpecification spec, String endpoint, Object body) {
        return given(spec).body(body).when().post(endpoint);
    }

    public static Response sendPatchRequest(RequestSpecification spec, String endpoint, Object body) {
        return given(spec).body(body).when().patch(endpoint);
    }

    public static Response sendDeleteRequest(RequestSpecification spec, String endpoint) {
        return given(spec).when().delete(endpoint);
    }

}
