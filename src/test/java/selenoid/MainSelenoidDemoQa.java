package selenoid;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.HashMap;

public class MainSelenoidDemoQa {
    @BeforeAll
    static void setUp() {
        Configuration.browserSize="1980x1600";
        Configuration.remote ="https://user1:1234@selenoid.autotests.cloud/wd/hub";
        Configuration.browserVersion ="99.0";
        Configuration.browser="chrome";
        ChromeOptions options = new ChromeOptions();
        options.setCapability("selenoid:options", new HashMap<String, Object>() {{
            put("env", new ArrayList<String>() {{
                add("TZ=UTC");
            }});
            put("labels", new HashMap<String, Object>() {{
                put("manual", "true");
            }});
            put("enableVideo", true);
        }});

        Configuration.browserCapabilities =options;
    }
    @BeforeEach
    void allure(){
        SelenideLogger.addListener("allure",new AllureSelenide());
    }
}
