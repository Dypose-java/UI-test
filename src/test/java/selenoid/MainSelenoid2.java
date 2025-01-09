package selenoid;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.ArrayList;
import java.util.HashMap;

public class MainSelenoid2 {
  @BeforeAll
  static void setUp() {
      ChromeOptions options = new ChromeOptions();
      options.setCapability("browserVersion", "128.0");
      options.setCapability("selenoid:options", new HashMap<String, Object>() {{
          /* How to add test badge */
          put("name", "Test badge...");

          /* How to set session timeout */
          put("sessionTimeout", "15m");

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
      Configuration.browserSize="1980x1600";
      Configuration.remote ="http://127.0.0.1:8080/wd/hub";
  }
}
