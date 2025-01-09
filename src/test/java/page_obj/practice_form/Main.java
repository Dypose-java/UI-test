package page_obj.practice_form;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.github.javafaker.Faker;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class Main extends MainSelenide {
    @BeforeEach
    void baseUrl(){
        Configuration.baseUrl="https://demoqa.com";
    }
    private static final Faker fakerRu= new Faker(new Locale("ru"));
    private static final Faker fakerEng= new Faker(new Locale("en"));
    private static final String NAME_FIRST =fakerRu.name().firstName();
    private static final String NAME_LAST =fakerRu.name().firstName();
    private static final String EMAIL =fakerEng.internet().emailAddress();
    private static final String MOUNTH ="December";
    private static final String YEAR ="2002";
    private static final String DATE ="6";
    private static final String PHONE =fakerRu.phoneNumber().subscriberNumber(10);
    private static final String GENDER =Gender.MALE.getValue();
    private static final String SPORTS = Hobbies.SPORTS.getValue();
    private static final String ADD =fakerEng.address().fullAddress();


    @Test
    void test(){
        Selenide.open("/automation-practice-form");
        new PracticeForm().assertTitleUrl().
                setFirstName("dypose").
                setLastName("dypose").
                setEmail("d.bol@mail.ru").
                setPhone("89688450693").
                dateBirth("December", "2002", "6").
                setPhone("89688450693").
                selectGender("Male").
                selectHobbies("Sports").
                addPicture().
                setCurrentAddress("улица пизда д манда").
                setStateAndSity("NCR", "Noida").butSubmit();
        //todo вынести переменные,сделать метод для проверки и проверить ожидаемый и реальный результат
    }
    @Owner("Dypose")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Заполнение формы demoQa")
    @Test
    void completionForm(){
        SelenideLogger.addListener("allure",new AllureSelenide());
        Selenide.open("/automation-practice-form");
        new PracticeForm().assertTitleUrl().
                setFirstName(NAME_FIRST).
                setLastName(NAME_LAST).
                setEmail(EMAIL).
                setPhone(PHONE).
                dateBirth(MOUNTH, YEAR, DATE).
                selectGender(GENDER).
                selectHobbies(SPORTS).
                addPicture().
                setCurrentAddress(ADD).
                setStateAndSity("NCR", "Noida")
                .butSubmit()
                .assertName(NAME_FIRST,NAME_LAST)
                .assertAddress(ADD)
                .assertEmail(EMAIL);
    }

}
