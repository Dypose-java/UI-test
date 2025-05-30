package tests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Severity;
import org.junit.jupiter.api.Test;
import page.WikipediaPage;
import tests.testBase.TestBaseQa;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.className;
import static io.appium.java_client.AppiumBy.id;
import static io.qameta.allure.Allure.step;


public class SearchTest extends TestBaseQa {
Severity
    @Test
    void successfulSearchTest() {
       WikipediaPage
               .wikipedia()
               .skipWelcomeScreen()
               .searchFor("Java")
               .selectSearchResult(0)
               .verifyTitleContains("java");



    }

}

