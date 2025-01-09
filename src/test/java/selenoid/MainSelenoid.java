package selenoid;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.HashMap;

public class MainSelenoid {
    @BeforeAll
    static void setUp() {
        Configuration.browser="chrome";
        Configuration.browserVersion ="128.0";
        Configuration.browserSize="1920x1980";
        Configuration.timeout=10_000;
        Configuration.remote ="http://127.0.0.1:8080/wd/hub";//connect selenoid
        //если есть пароль то пишем http://log:pas@127.0.0.1:8080/wd/hub"
        ChromeOptions options = new ChromeOptions();
        options.setCapability("selenoid:options", new HashMap<String, Object>() {{
            /* How to set timezone */
            put("env", new ArrayList<String>() {{
                add("TZ=UTC");
            }});
            /* How to add "trash" button */
            put("labels", new HashMap<String, Object>() {{
                put("manual", "true");
            }});
            /* How to enable video recording */
            put("enableVideo", true);
        }});
        Configuration.browserCapabilities =options;

    }

   /* @AfterAll
    static void afterAll() {
        WebDriverRunner.closeWindow();
    }*/
}
