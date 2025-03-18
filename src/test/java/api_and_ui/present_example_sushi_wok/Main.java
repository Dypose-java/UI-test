package api_and_ui.present_example_sushi_wok;

import api_and_ui.present_example_sushi_wok.config_sushi_wok.SushiConfig;
import api_and_ui.present_example_sushi_wok.helper.Specification;
import api_and_ui.present_example_sushi_wok.pojo.UserSWReguest;
import api_and_ui.present_example_sushi_wok.pojo.UserSWResponse;
import com.codeborne.selenide.Configuration;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;


public class Main {
    static String log = "", pas = "";
String cookie="_ym_uid=1727291633479176596; _ym_d=1727291633; default-city=false; cityTextId=msk; lang=ru; connect.s" +
        "id=s%3AhWBay4JCw8MSE56ftWyd9RTTkAky5evA.vR0qmDZ3J2O%2FDP7sbgZLaLGfOLV8qFgPn88eZGXN7Pk; _sticky_param=b; _gcl_" +
        "au=1.1.144102499.1741887509; _ga_TE53H5X77H=GS1.1.1741887508.1.0.1741887508.60.0.0; _ga=GA1.1.948291890.174" +
        "1887509; _ym_isad=1; _ym_visorc=w";
    @BeforeAll
    static void voidSetUp() {
        SushiConfig conf = SushiConfig.CONFIG;
        log = conf.getLog();
        pas = conf.getPas();
        RestAssured.baseURI = conf.getUrlApi();
        Configuration.baseUrl = conf.getUrlUI();
    }

    @Test
    void check() {
        UserSWReguest build = UserSWReguest.builder().code("231130").phone("+7(968)845-06-92").build();
        given(Specification.requestSpecification()).
                header("Cookie",cookie).
                body(build).
                when().post("user/register_or_auth").then().
                spec(Specification.responseSpecification(200)).extract().jsonPath().getList("user",  UserSWResponse.User.class)
    }
}
