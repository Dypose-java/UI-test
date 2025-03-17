package api_and_ui.present_example_sushi_wok;

import api_and_ui.present_example_sushi_wok.config_sushi_wok.SushiConfig;
import api_and_ui.present_example_sushi_wok.pojo.UserSW;
import com.codeborne.selenide.Configuration;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;


public class dshfsdhfisd {
   static  String log="",pas="";
    @BeforeAll
    static void voidSetUp(){
        SushiConfig conf =SushiConfig.CONFIG;
        log=conf.getLog();
        pas=conf.getPas();
        RestAssured.baseURI=conf.getUrlApi();
        Configuration.baseUrl=conf.getUrlUI();

    }
    @Test
    void check(){
        UserSW.UserSWBuilder code = UserSW.builder().phone(log).code(pas);
        given()
                .contentType(ContentType.JSON).body(code).log().all()
                .when().post("/user/register_or_auth")
                .then().log().all()
                        .statusCode(200).body("user.id", Matchers.is("2126854"));

        System.out.println();
    }
}
