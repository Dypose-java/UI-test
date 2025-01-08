package page_obj.practice_form;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public abstract class MainSelenide {
    @BeforeAll
   static void setUp() {
        //Configuration.holdBrowserOpen =true;
        Configuration.browser="chrome";
        Configuration.timeout=10_000;
        Configuration.browserSize="1920x1980";
        //Configuration.baseUrl="https://demoqa.com/";
    }

    @AfterAll
    static void afterAll() {
        WebDriverRunner.closeWindow();
    }
}


