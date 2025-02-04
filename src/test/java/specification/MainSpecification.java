package specification;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static helpers.CustomApiListiner.withCustomTemplate;
import static io.restassured.RestAssured.with;
import static io.restassured.filter.log.LogDetail.BODY;
import static io.restassured.filter.log.LogDetail.STATUS;

public class MainSpecification {

    public static RequestSpecification mainRequestSpecification() {
        return with()
                .log().uri()
                .log().headers()
                .log().body()
                .filter(withCustomTemplate())
                .contentType(ContentType.JSON);
    }
    public static ResponseSpecification mainResponseSpecification(int statuseCode){
        return new ResponseSpecBuilder().log(STATUS)
                .log(BODY)
                .expectStatusCode(statuseCode)
                .build();
    }

}
