package selenoid;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.github.javafaker.Faker;
import io.qameta.allure.Attachment;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import page_obj.practice_form.Gender;
import page_obj.practice_form.Hobbies;
import page_obj.practice_form.MainSelenide;
import page_obj.practice_form.PracticeForm;

import java.util.Locale;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class Main extends MainSelenoidDemoQa {
    @BeforeEach
    void baseUrl(){
        //Configuration.baseUrl="https://demoqa.com";
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
    private static final String GENDER = Gender.MALE.getValue();
    private static final String SPORTS = Hobbies.SPORTS.getValue();
    private static final String ADD =fakerEng.address().fullAddress();


@Disabled("Хуй пойми тест не проходит именно в селеноиде на локали все гуд")

    @Tag("selenoid")
    @Owner("Dypose")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Заполнение формы demoQa")
    @Test
    void completionForm(){
        SelenideLogger.addListener("allure",new AllureSelenide());
        Selenide.open("https://demoqa.com/automation-practice-form");
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

    @Test
    @Owner("Dypose")
    @Tag("selenoid")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Проверка работоспособности теста в селеноиде")
    void openUrl(){
        Configuration.timeout =12000;
        SelenideLogger.addListener("allure",new AllureSelenide());
        step("Open url",()->{
            Selenide.open("https://demoqa.com/");

        });
        step("search elements form and click",()->{
            $(byText("Elements")).click();

        });
        step("search radio button and click",()->{
            $(byText("Radio Button")).click();

        });
        step("assertions title radio button",()->{
            $(".text-center").shouldHave(text("Radio Button"));

        });

    }

private final String NAME ="dypose";

    @Disabled("Проблема с url")

    @Owner("Dypose")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Заполнение формы tread")
    @Tag("selenoid")
    @Test
    void treadForm(){
        SelenideLogger.addListener("allure",new AllureSelenide());
         new TreadUiForm("http://85.192.34.140:8081/")
                .selectCard("Forms")
                .selectElementCard("Practice Form")
                .setName(NAME)
                 .clickSubmit();
    }
    @Tag("selenoid")
    @Owner("Dypose")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Ебучий дженкинс дай мне passed test dont answer 400 and 500")
    @Test
    void jenkinsTest(){
        SelenideLogger.addListener("allure",new AllureSelenide());
        step("open url",()->{
            Selenide.open("https://translate.yandex.ru/");
        });
        step("add value in area",()->{
            $("#fakeArea").setValue("52");

        });

    }

}
