package propirties;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.HashMap;
@Tag("setUp")
public class MainSetUp {
    @BeforeAll
    static void setUp() {
        Configuration.browserSize=System.getProperty("browserSize","1980x1600");
        Configuration.remote ="https://user1:1234@selenoid.autotests.cloud/wd/hub";
        Configuration.browserVersion =System.getProperty("browserVersion","99.0");
        Configuration.browser=System.getProperty("browser","firefox");
        Configuration.baseUrl=System.getProperty("url","https://");

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
    @AfterEach
    void attach(){
        Attach.screenshotAs("last screen");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}
