package test_allure;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.commands.TakeScreenshot;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class WebSteps {
    @Step("Открываем главную страницу{url}")
    public WebSteps openMainPage(String url) {
        open(url);
return this;
    }
    @Step("Нажимаем на поисковую строку")
    public WebSteps clickSearchBar() {
        SelenideElement seacrh = $(".HeaderMenu .search-input button");
        seacrh.click();
        return this;
    }
    @Step("Устанавливаем значение {value},ищем никнейм {nameGit},нажимает enter")
    public WebSteps searchForRepository(String value,String nameGit) {
        $("#query-builder-test").setValue(value).pressEnter();
        $(byText(nameGit)).click();
        return this;
    }
    @Step("нажимаем на Issues")
    public WebSteps clickIssue() {
        $("#issues-tab").click();

        return this;
    }
    @Step("проверка что первый Issues равен{issue}")
    public WebSteps SearchFirstIssueEqual(String issue){
        $$(".js-navigation-container .flex-auto").first().shouldHave(text(issue));
        takeScreenshot();//в отчете будет прикреплен скриншот
        return this;
    }

    @Attachment(value = "Screenshot",type = "image/png",fileExtension = "png")
    public byte[] takeScreenshot(){
        return ((TakesScreenshot)WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
}

