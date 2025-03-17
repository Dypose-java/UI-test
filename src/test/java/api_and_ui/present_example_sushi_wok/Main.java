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
    String cookie="_ym_uid=1727291633479176596; _ym_d=1727291633; default-city=false; cityTextId=msk; lang=ru; connect.sid=s%3AhWBay4JCw8MSE56ftWyd9RTTkAky5evA.vR0qmDZ3J2O%2FDP7sbgZLaLGfOLV8qFgPn88eZGXN7Pk; _sticky_param=b; _gcl_au=1.1.144102499.1741887509; _ym_isad=1; _ym_visorc=w; _gid=GA1.2.1403743463.1741887588; _ga=GA1.1.948291890.1741887509; _ga_565PTV2E7Y=GS1.1.1741887587.1.1.1741887765.60.0.0; _ga_TE53H5X77H=GS1.1.1741887508.1.1.1741887765.5.0.0";
@Disabled("периписать неахуй")
    @Test
    void check(){
      given().formParam("X-Requested-With","XMLHttpRequest").when().get("user/isExist").then().log().all().body("isUserExist",Matchers.is(false));
        System.out.println();
    }
}
