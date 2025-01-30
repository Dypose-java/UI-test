package api_test.firstApi;

import io.restassured.RestAssured;
import org.aeonbits.owner.ConfigFactory;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Main {
    private final String BASE_URL ="https://selenoid.autotests.cloud/";
    /**
     * Given() — позволяет узнать, что было передано в запросе.
     * When() — указывает, с каким методом и на какой эндпойнт отправлять запрос.
     * Then() — определяет, как проверяется пришедший ответ.
     * Body() — проверяет тело ответа.
     * {
     * "total":20,"used":0,"queued":0,"pending":0,
     * "browsers":{
     * "chrome":{
     * "100.0":{},"113.0":{},"114.0":{},
     * "120.0":{},"121.0":{},"122.0":{},"123.0":{},"124.0":{},"125.0":{},"126.0":{},"99.0":{}},
     * "firefox":{
     * "122.0":{},"123.0":{},"124.0":{},"125.0":{}},
     * "opera":{
     * "106.0":{},"107.0":{},"108.0":{},"109.0":{}},
     * "playwright-chromium":{"1.28.1":{}
     * }
     * }
     * }
     * */
    @Test
    void getCheckTotal(){
        given().
                when().
        get(BASE_URL+"status").
                then().
                body("total",is(20)).
                log().all();
    }
    @Test
    void getcheckVersionChrome(){
        given().
                when().
                get(BASE_URL+"status").
                then().
                log().all().
                body("browsers.chrome",hasKey("100.0"));

    }
    /**https://selenoid.autotests.cloud/wd/hub/status
     * {"value":{"message":"Selenoid 1.11.3 built at 2024-05-25_12:34:40PM","ready":true}}
     * */

    @Test
    void postCheckWdHubStatus401(){
        given().
                when().
                get(BASE_URL+"wd/hub/status").
                then().
                log().all()
                .statusCode(401);
    }
    @Test
    void checkAuthWdHub(){
        given().
                when().auth().basic("user1","1234").
                get(BASE_URL+"wd/hub/status").
                then().
                log().all()
                .statusCode(200).
                body("value.ready",is(true));
    }
}
