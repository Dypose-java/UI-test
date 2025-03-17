package api_and_ui.demo_web_shop;

import api_and_ui.config.App;
import api_and_ui.config.SetUpSelenide;
import api_and_ui.helper.AllureRestAssuredFilter;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;

public class Main extends SetUpSelenide {
    private static  String login="",pas="";
    @BeforeAll
    static void setUp(){
        App configApp = App.CONFIG;
        RestAssured.baseURI=configApp.apiUrl();
        Configuration.baseUrl=configApp.webUrl();
        login=configApp.userLogin();
        pas=configApp.userPassword();
    }


    @Test
    @DisplayName("registration  And Check Main Page")
    @Tag("API_UI")
    void registApiAndCheckMainPage(){
        step("regist api user",()->{
            String authorizationCookie =
                    given()
                            .filter(AllureRestAssuredFilter.withCustomTemplates())
                            .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                            .formParam("Email", login)
                            .formParam("Password",pas)
                            .when()
                            .post("/login")
                            .then()
                            .statusCode(302)
                            .extract()
                            .cookie("NOPCOMMERCE.AUTH");

            step("open minimal content because set cookie",()->{
                open("/Themes/DefaultClean/Content/images/logo.png");

                step("set cookie",()->{
                    WebDriverRunner.getWebDriver().manage().addCookie(new Cookie("NOPCOMMERCE.AUTH",authorizationCookie));
                });
            });
        });

        step("Open mane page",()->{
            open("");
        });

step("Verify successful authorization",()->{
    $(".account").shouldHave(Condition.text(login));
});


        System.out.println();
    }
}
