package randCheckApi;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static helpers.CustomApiListiner.withCustomTemplate;
import static io.restassured.RestAssured.with;
import static io.restassured.filter.log.LogDetail.BODY;
import static io.restassured.filter.log.LogDetail.STATUS;

public class Specification {
    static RequestSpecification mainRequestSpec(){
        return with().baseUri("https://api.spacexdata.com/v3")
                .log().body()
                .log().uri()
                .log().headers()
                .contentType(ContentType.JSON)
                .filter(withCustomTemplate());

    }
    public static ResponseSpecification mainResponseSpec(int statuseCode){
        return new ResponseSpecBuilder().log(STATUS)
                .log(BODY)
                .expectStatusCode(statuseCode)
                .build();
    }
}
