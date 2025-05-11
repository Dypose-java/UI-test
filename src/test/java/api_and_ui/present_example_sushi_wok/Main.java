package api_and_ui.present_example_sushi_wok;

import api_and_ui.present_example_sushi_wok.config_sushi_wok.SushiConfig;
import api_and_ui.present_example_sushi_wok.helper.Specification;
import api_and_ui.present_example_sushi_wok.pojo.Addr;
import api_and_ui.present_example_sushi_wok.pojo.User;
import api_and_ui.present_example_sushi_wok.pojo.UserSWReguest;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.restassured.RestAssured;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;


import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.restassured.RestAssured.given;


public class Main {
    static String log = "", pas = "",cookie ="";

    @BeforeAll
    static void voidSetUp() {
        SushiConfig conf = SushiConfig.CONFIG;
        log = conf.getLog();
        pas = conf.getPas();
        cookie=conf.getCokie();
        RestAssured.baseURI = conf.getUrlApi();
        Configuration.baseUrl = conf.getUrlUI();

    }

    @Test
    void registerUserTest2() {
        UserSWReguest build = UserSWReguest.builder().code("231130").phone("+7(968)845-06-92").build();
        List<Addr> addrList = given(Specification.requestSpecification()).
                header("Cookie", cookie).
                body(build).
                when().post("user/register_or_auth").then().
                spec(Specification.responseSpecification(200))
                .extract().jsonPath()
                .getList("user.addresses", Addr.class);
        AssertionsForClassTypes.assertThat(addrList.getFirst().getId()).isEqualTo(2371194);
        System.out.println();
    }

    @Test
    void registerUserTest21() {
        UserSWReguest build = UserSWReguest.builder().code("231130").phone("+7(968)845-06-92").build();
        User object = given(Specification.requestSpecification()).
                header("Cookie", cookie).
                body(build).
                when().post("user/register_or_auth").then().
                spec(Specification.responseSpecification(200)).extract().jsonPath().getObject("user", User.class);
        String email = object.getEmail();
        System.out.println();
    }

    @Test
    void fsfsdf() {
        open("/img/1b64cbc40cfb8633bf476f3dc750916a/500x500");
        WebDriverRunner.getWebDriver().manage().addCookie(new Cookie("connect.sid","s%3AhWBay4JCw8MSE56ftWyd9RTTkAky5evA.vR0qmDZ3J2O%2FDP7sbgZLaLGfOLV8qFgPn88eZGXN7Pk"));
        open("msk/profile/");
        System.out.println();
     /*   $$(".profile__action-container button").first().click();
        $(".auth-page p").shouldHave(text("Вход/Регистрация"));
        System.out.println();*/
    }
}
