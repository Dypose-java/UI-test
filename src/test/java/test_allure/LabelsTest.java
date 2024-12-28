package test_allure;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static com.codeborne.selenide.Selenide.open;

public class LabelsTest {
    final String URL ="https://github.com/";


    @Test
    @Feature("feature")
    @Story("story")
    @Owner("Dypose")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Testing",url = "https://testing.github.com/")
    @DisplayName("Открытие url:"+URL)
    public void testStaticLabels(){
        SelenideLogger.addListener("allure",new AllureSelenide());
        open(URL);

    }
    @Test
    @Feature("Issue в репозитории")
    @Story("Создание issue")
    //для создание более декларированных отчетов
    @Owner("Dypose")
    @Severity(SeverityLevel.MINOR)
    @DisplayName("Проверка аннотаций allure")
    public void testOnnatationOrSelenide(){

    }
    @Test
    @Feature("Issue в репозитории")
    @Story("Создание issue")
    @Owner("Dypose")
    @Severity(SeverityLevel.MINOR)
    @DisplayName("Проверка вложенности отчетов в allure")
    public void test(){

    }
}
