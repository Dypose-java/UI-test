package test_my_back.speck;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static helpers.CustomApiListiner.withCustomTemplate;
import static io.restassured.RestAssured.with;

public class Specification {

    public static RequestSpecification mainRequest(ContentType contentType){
        return with()
                .log().uri()
                .log().headers()
                .log().body()
                .filter(withCustomTemplate())
                .baseUri("http://localhost")
                .port(8080)
                .basePath("/")
                .contentType(contentType);
    }

public static ResponseSpecification responseSpecification(int statusCode){
    return new ResponseSpecBuilder().log(LogDetail.BODY)
            .log(LogDetail.STATUS)
            .expectStatusCode(statusCode)
            .build();
}

}
