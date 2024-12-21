package testCaseJUit;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.CsvSources;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class Main {

    @BeforeEach
    void setUP() {
        System.out.println("Предусловие");
    }

    @Disabled("Номер багтрекинга(Jira)")
    @Test
    @DisplayName("Проверка что число 3 >2")
    @Tag("BLOCKED")
    @Tags({@Tag("BLOCKER"), @Tag("UI_TEST")})
    void tes1() {
        Assertions.assertTrue(3 > 2);
    }



    @CsvSource({
            "Dypose,dypose@mail.ru",
            "Integga,belarus@fortnite.usa"
    })
    @ParameterizedTest(name = "Ввод {0} и {1} на сайте https://demoqa.com/text-box#google_vignette")
    void test2(String fullName, String email) {
        Configuration.browserSize = "1920x1980";
        Selenide.open("https://demoqa.com/text-box#google_vignette");
        $("#userName").setValue(fullName);
        $("#userEmail").setValue(email);
        $("#submit").click();
        $("#output").shouldHave(text(fullName), text(email));
//        executeJavaScript("$(#app footer).remove()");

    }


    @CsvFileSource(resources = "/testCase/main.csv")//если много значений можно вынести в файл
    @ParameterizedTest(name = "Ввод {0} и {1} на сайте https://demoqa.com/text-box#google_vignette")
    void fsfsd(String fullName, String email){
        Configuration.browserSize = "1920x1980";
        Selenide.open("https://demoqa.com/text-box#google_vignette");
        $("#userName").setValue(fullName);
        $("#userEmail").setValue(email);
        $("#submit").click();
        $("#output").shouldHave(text(fullName), text(email));
    }


    @ValueSource(strings = {"dtpose","main","java","sfsfs"})
    @ParameterizedTest(name = "Ввод логин {0} на сайте https://demoqa.com/text-box#google_vignette")
    void inputLoginOnWeb(String login){
        Configuration.browserSize = "1920x1980";
        Selenide.open("https://demoqa.com/text-box#google_vignette");
        $("#userName").setValue(login);
        $("#submit").click();
        $("#output").shouldHave(text(login));
    }

}
