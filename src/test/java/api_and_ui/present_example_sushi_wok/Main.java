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
    static String log = "", pas = "";
    String cookie = "_ym_uid=1727291633479176596; _ym_d=1727291633; default-city=false; cityTextId=msk; lang=ru; connect.s" +
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
    void registerUserTest() {
        UserSWReguest build = UserSWReguest.builder().code("231130").phone("+7(968)845-06-92").build();
      /*  List<UserSWResponse.User> list = given(Specification.requestSpecification()).
                header("Cookie", cookie).
                body(build).
                when().post("user/register_or_auth").then().
                spec(Specification.responseSpecification(200)).extract().jsonPath().getList("user", UserSWResponse.User.class);
        System.out.println();*/
    }

    @Test
    void getuserAddres() {
        String cookie = "_ym_uid=1727291633479176596; _ym_d=1727291633; default-city=false; cityTextId=msk; " +
                "lang=ru; connect.sid=s%3AhWBay4JCw8MSE56ftWyd9RTTkAky5evA.vR0qmDZ3J2O%2FDP7sbgZLaLGfOLV8qFgP" +
                "n88eZGXN7Pk; _gcl_au=1.1.144102499.1741887509; _sticky_param=6; _ym_isad=1; _gid=GA1.2.147081" +
                "7810.1742240313; from-route-without-city=true; _ym_visorc=b; _ga_565PTV2E7Y=GS1.1.1742245189.4." +
                "1.1742247090.60.0.0; _ga=GA1.1.948291890.1741887509; _ga_TE53H5X77H=GS1.1.1742245189.4.1.1742247" +
                "539.54.0.0";
   /*     List<UserSWResponse.Addresses> addresses = given(Specification.requestSpecification()).
                header("Cookie", cookie).
                when().post("user/addresses").then()
                .spec(Specification.responseSpecification(200))
                .extract().jsonPath().getList("", UserSWResponse.Addresses.class);
        System.out.println();
        boolean b = addresses.stream().map(UserSWResponse.Addresses::getUser_id).allMatch(el -> el.equals(2126854));
        assertThat(b).isTrue();
        assertThat(addresses.stream().count()).matches(el->el==2);*/
    }

    @Test
    void getBonusesUserTest() {
      /*  given(Specification.requestSpecification()).
                header("Cookie", cookie).
                when().post("user/addresses").then()
                .spec(Specification.responseSpecification(200))
                .extract().jsonPath().getList("", UserSWResponse.Addresses.class);*/
    }

    @Test
    void registerUserTest2() {
        UserSWReguest build = UserSWReguest.builder().code("231130").phone("+7(968)845-06-92").build();
        List<Addr> addrList = given(Specification.requestSpecification()).
                header("Cookie", cookie).
                body(build).
                when().post("user/register_or_auth").then().
                spec(Specification.responseSpecification(200)).extract().jsonPath().getList("user.addresses", Addr.class);
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
