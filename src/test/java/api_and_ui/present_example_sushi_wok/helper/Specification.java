package api_and_ui.present_example_sushi_wok.helper;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.with;

public class Specification {
    public static RequestSpecification requestSpecification() {
        return with().
                log().uri().log().headers().log().body()
                .header("X-Requested-With", "XMLHttpRequest")
                .contentType(ContentType.JSON);
    }

    public static ResponseSpecification responseSpecification(int statuseCode) {
        return new ResponseSpecBuilder().
                log(LogDetail.STATUS).
                log(LogDetail.BODY).
                expectStatusCode(statuseCode).
                build();
    }
}
