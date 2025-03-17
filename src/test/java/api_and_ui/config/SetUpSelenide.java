package api_and_ui.config;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class SetUpSelenide {
    @BeforeAll
    static void setUp(){
        Configuration.browserSize=System.getProperty("browserSize","1920x1980");;
        Configuration.timeout=5000;
        Configuration.browser=System.getProperty("browserName","chrome");
    }
    @BeforeEach
    void allure(){
        SelenideLogger.addListener("allure",new AllureSelenide());

    }
}
