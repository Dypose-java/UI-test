import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;


public class TestTest {
    /**
     * Открыть форму авторизации
     * https://school.qa.guru/cms/system/login
     * ввести log and pas
     * нажать кнопку войти
     * нажать на кнопку личный каб
     * проверить успешную авторизацию
     */

    @Test
    void test1(){
        Configuration.holdBrowserOpen =true;//чтобы браузер не закрывался
        Configuration.browser="chrome";
        Configuration.timeout=10_000;//10cек
        open("https://school.qa.guru/cms/system/login");
        $x("//input[@placeholder='Введите ваш эл. адрес']").setValue("qagurubot@gmail.com");
        $x("//input[@name='password']").setValue("qagurupassword").pressEnter();
        $x("//h2[@id='xdget172046_1_1']").shouldHave(text("Войти"));//проверка текста
    }
    @Test
    void testJunit5(){
        Assertions.assertTrue(2>1);
    }
}
