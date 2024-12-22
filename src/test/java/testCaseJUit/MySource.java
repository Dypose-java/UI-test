package testCaseJUit;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class MySource {
    @BeforeAll
   static void setUp(){
        Configuration.browserSize="1920x1980";
        Configuration.timeout=5000;
    }

    @BeforeEach
    void openUrl(){
        Selenide.open("https://eda.yandex.ru");
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
    }
    @AfterEach
    void closeWeb(){
        Selenide.closeWebDriver();
    }
    @Disabled(value = "Мать яндекс доставки ебал нужно исправить")
    @ValueSource(strings = {"Вкусно – и точка","Бургер Кинг","Rostic's"})
    @ParameterizedTest(name="Ввод {0} в поиск eda.yandex ")
    void inputSearchValue(String nameOrg){
        $("#id_1").setValue(nameOrg);
        $(".DesktopHeader_leftBlock").$(byText("Найти")).click();
        $(byText("Рестораны")).click();
        sleep(5000);
        //$$(".DesktopSearchPage_root .DesktopSearchPlaceCarousel_root .UiKitPlaceInfo_upperInfo").filter(text(nameOrg)).first().click();

    }

}
