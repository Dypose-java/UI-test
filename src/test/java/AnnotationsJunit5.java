import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Selenide.$x;

public class AnnotationsJunit5 {
    /**
     * Если какие-то методы необходимо выполнять в начале перед всеми действиями или после них,
     * то их следует отметить аннотациями @BeforeAll и @AfterAll соответственно.
     * Также важно отметить, что такие методы должны обязательно быть static
     */

    @BeforeEach//(перед каждым)
    void openPage(){
        Configuration.holdBrowserOpen =true;
        Configuration.browser="chrome";
        Configuration.timeout=10_000;
    }
    @AfterEach //(после каждого)
    void closeWindow(){
    }
    @Test
    void test1DemoQa(){
        String FirstAndLastName="Dypose dypose";
        String email="d.bolonkin22@mail.ru";
        String areaText="52";

        $x("//input[@id='userName']").setValue(FirstAndLastName);
        $x("//input[@id='userEmail']").setValue(email);
        $x("//textarea[@id='currentAddress']").setValue(areaText);
        $x("//textarea[@id='permanentAddress']").setValue(areaText);
        $x("//button[@id='submit']").pressEnter();

        $x("//p[@id='name']").shouldHave(Condition.text(FirstAndLastName));//проверка что данные введены корректно
        $x("//p[@id='email']").shouldHave(Condition.text(email));
        $x("//p[@id='currentAddress']").shouldHave(Condition.text(areaText));
        $x("//p[@id='permanentAddress']").shouldHave(Condition.text(areaText));//todo del
    }

    @Disabled("Чтобы не коммить тест можно просто указать аннотацию")
    @DisplayName("Тест главной страницы")
    @Test
    void test2FakeLibrary(){
PageTextBox pageTest = new PageTextBox();
pageTest.allTest();
    }

    /**
     Параметризованные тест
     */
    @ValueSource(strings = {
            "Google",
            "Yandex"
    })//в метод передается массив значений которые мы проверяем
    @ParameterizedTest//Чтобы выполнить тест несколько раз, но с разными аргументами
    void gfdgdgdf(String strings){
        PageTextBox pageTest = new PageTextBox();
        pageTest.testFullName(strings);
    }


    @CsvSource(value = {
            "alex, 30",
            "brian, 35",
            "charles, 40"
    })
    @ParameterizedTest
    void test(String name,int age){
        PageWebTables pageWebTables = new PageWebTables();
        pageWebTables.testRenameFirstNameAndAge(name,age);
    }










}


