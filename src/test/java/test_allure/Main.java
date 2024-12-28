package test_allure;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class Main {


    @Test
    public void testSearch(){
        SelenideLogger.addListener("allure",new AllureSelenide());
        open("https://github.com/");
        SelenideElement seacrh = $(".HeaderMenu .search-input button");
        seacrh.click();
        $("#query-builder-test").setValue("allure-exam").pressEnter();
//        $("[data-testid='results-list']").$(byText("eroshenkoam")).click();
        $(byText("eroshenkoam/")).click();
        $("#issues-tab").click();
        $$(".js-navigation-container .flex-auto").first().shouldHave(text("#95"));

    }
    final String URL ="https://github.com/";
    final String VALUE = "allure-exam";
    final String NAME_GIT ="eroshenkoam/";
   final String FIRST_ISSUE ="95";
    @Test
    public void testSelenideLamdaSearch(){
        SelenideLogger.addListener("allure",new AllureSelenide());

        step("Открываем главную страницу:"+ URL,()->{
            open(URL);
        });
        step("Нажимаем на поисковую строку",()->{
            SelenideElement seacrh = $(".HeaderMenu .search-input button");
            seacrh.click();
        });
        step("Устанавливаем значение:"+ VALUE +",ищем никнейм:"+ NAME_GIT +"нажимает enter",()->{
            $("#query-builder-test").setValue(VALUE).pressEnter();
            $(byText(NAME_GIT)).click();
        });
        step("нажимаем на Issues,проверяем что первый Issues равен "+ FIRST_ISSUE,()->{
            $("#issues-tab").click();
            $$(".js-navigation-container .flex-auto").first().shouldHave(text(FIRST_ISSUE));
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
