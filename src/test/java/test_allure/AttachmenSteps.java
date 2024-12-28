package test_allure;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.attachment;
import static io.qameta.allure.Allure.step;

public class AttachmenSteps {
    final String URL ="https://github.com/";
    final String VALUE = "allure-exam";
    final String NAME_GIT ="eroshenkoam/";
    final String FIRST_ISSUE ="95";
    @Test
    public void testLamdaAttachmens(){
        SelenideLogger.addListener("allure",new AllureSelenide());
        step("Открываем главную страницу:"+ URL,()->{
            open(URL);
            attachment("Sourse",webdriver().driver().source());//sourse file in allure
        });

    }
    @Test
    public void annotationTestStep(){
        SelenideLogger.addListener("allure",new AllureSelenide());

        new WebSteps()
                .openMainPage(URL)
                .clickSearchBar()
                .searchForRepository(VALUE,NAME_GIT)
                .clickIssue().SearchFirstIssueEqual(FIRST_ISSUE);
    }
}
