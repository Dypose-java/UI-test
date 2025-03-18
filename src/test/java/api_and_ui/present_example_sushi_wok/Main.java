package api_and_ui.present_example_sushi_wok;

import api_and_ui.config.App;
import api_and_ui.helper.AllureRestAssuredFilter;
import api_and_ui.present_example_sushi_wok.config_sushi_wok.SushiConfig;
import api_and_ui.present_example_sushi_wok.pojo.UserSW;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;

import static com.codeborne.selenide.Selenide.*;
import static io.restassured.RestAssured.given;


public class Main {
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
        UserSW build = UserSW.builder().code("812592").phone("+7(968)845-06-92").build();
    }
}
