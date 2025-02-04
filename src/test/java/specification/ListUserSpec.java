package specification;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static helpers.CustomApiListiner.withCustomTemplate;
import static io.restassured.RestAssured.*;
import static io.restassured.filter.log.LogDetail.*;
import static io.restassured.http.ContentType.*;
import static org.hamcrest.CoreMatchers.notNullValue;

public class ListUserSpec {

    public static RequestSpecification requestListUser =with()
            .log().uri()
            .log().headers()
            .log().body()
            .filter(withCustomTemplate())
            .contentType(JSON);

    public static ResponseSpecification responseListUser = new ResponseSpecBuilder()
            .log(STATUS)
            .log(BODY)
            .expectStatusCode(200)
            .expectBody("data",notNullValue())
            .build();

}
