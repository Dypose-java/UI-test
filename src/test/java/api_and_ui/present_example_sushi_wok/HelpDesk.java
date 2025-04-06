package api_and_ui.present_example_sushi_wok;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;


import java.util.Date;

import static api_and_ui.present_example_sushi_wok.HelpDesk.SandboxLogin.reqHeaderLogin;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.with;

public class HelpDesk {

    static class SandboxLogin{
        public static RequestSpecification reqHeaderLogin(String username,String password,String csrfToken){
            return with().given().when().contentType(ContentType.URLENC).
                    cookie("csrftoken",csrfToken).
                    formParam("username", username).
                    formParam("password", password).
                    formParam("next", "/").
                    formParam("csrfmiddlewaretoken", csrfToken).baseUri("https://at-sandbox.workbench.lanit.ru/");
        }
    }

    @Test
    void checkHelpdesk(){
        Selenide.open("https://at-sandbox.workbench.lanit.ru/tickets/");
        String csrftoken = WebDriverRunner.getWebDriver().manage().getCookieNamed("csrftoken").getValue();

        String bodySessionid = given(reqHeaderLogin("admin", "adminat", csrftoken)).post("login/").then().extract().cookie("sessionid");
        Selenide.open("https://at-sandbox.workbench.lanit.ru/tickets/");
        Date date = new Date();
        date.setTime(date.getTime()+(10000*1000));
        Cookie sessionid = new Cookie("sessionid", bodySessionid, "at-sandbox.workbench.lanit.ru", "/", date);

        WebDriverRunner.getWebDriver().manage().addCookie(sessionid);
        Selenide.refresh();
        
        System.out.println();
    }

}
