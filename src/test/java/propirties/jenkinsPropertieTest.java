package propirties;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class jenkinsPropertieTest extends MainSetUp {
    @Test
    @Tag("exampleProrirtiesTest")
    void exampleProrirtiesTest(){
        String name ="dypose";
        SelenideLogger.addListener("allure",new AllureSelenide());
        step("open url",()->{
            Selenide.open(System.getProperty("urlTest","vk.ru"))
            ;});
        step("serch value {name} and pressEnter",()->{
            SelenideElement search=$(".vkuiSearch__input input");
            search.setValue(name).pressEnter();
        });

    }
}
