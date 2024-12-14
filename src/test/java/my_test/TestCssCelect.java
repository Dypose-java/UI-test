package my_test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Locale;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TestCssCelect {
    private static final Faker fakerRU = new Faker(new Locale("ru"));
    private static final Faker fakerEN = new Faker(new Locale("en"));
    @BeforeEach
    void setUp(){
        Configuration.browserSize="1920x1980";
        Configuration.timeout =4000;
        Configuration.baseUrl ="https://demoqa.com";
    }

    @Test
    void testCss(){
        Selenide.open("/text-box");

        String name = fakerRU.name().fullName();
        String email = fakerEN.internet().emailAddress();
        String avatar =fakerRU.internet().avatar();
        String card = fakerRU.business().creditCardNumber();

        $("#userName").setValue(name);
        $("#userEmail").setValue(email);
        ElementsCollection area = $$(".text-field-container div textarea");
        area.first().setValue(avatar);
        area.last().setValue(card);
        $(".text-right button").click();

        $(".border").shouldHave(text(name),text(email),text(avatar),text(card));

        sleep(5000);
    }
    @Test
    void check_Box(){
        Selenide.open("/checkbox");
        $$(".rct-options button").first().click();
        ElementsCollection  rctText =$$(".rct-node-leaf");
        rctText.get(0).$("svg").click();
        rctText.get(1).$("svg").click();
        sleep(5000);
        $("#result").shouldHave(text("desktop notes commands"));
    }
    @Test
    void  testConfirm(){
        Selenide.open("/automation-practice-form");

       final String nameFirst =fakerRU.name().firstName();
        final String nameLast=fakerRU.name().lastName();
        final String email =fakerEN.internet().emailAddress();
       final String phone=fakerRU.phoneNumber().subscriberNumber(11);
       final String address =fakerRU.address().fullAddress();

        $("#firstName").setValue(nameFirst);
        $("#lastName").setValue(nameLast);
        $("#userEmail").setValue(email);
        $$("#genterWrapper input ").first().parent().$("label").click();
        // $(byText("Male")).click();
        /*$$("#genterWrapper input ").first().ancestor("div").$("label").click();*/
        $("#userNumber").setValue(phone);
        $("#dateOfBirthInput").click();
        $$(".react-datepicker__month-select option").first().click();//jan
        $$(".react-datepicker__year-select option").get(52).click();//1952 г
        $$(".react-datepicker__month div").get(9).click();//day 6
        $$("#hobbiesWrapper div div input").first().parent().click();
        $$(".form-control").get(5).setValue(address);
        $$(".css-2b097c-container").get(1).click();
        $(byText("NCR")).click();
        SelenideElement selectCity =$(byText("Select City"));
        selectCity.click();
        $(byText("Delhi")).click();
        $("#submit").click();
       // sleep(6_000);
        /*$(".modal-body").shouldHave(text(nameLast),text(nameFirst),
                text(email), text(phone),
                text(address),text("NCR"),text("Delhi"));*/
        SelenideElement assertReg =$(".modal-body");
        assertReg.shouldHave(text(nameFirst));
        assertReg.shouldHave(text(nameLast));
        assertReg.shouldHave(text(email));
        assertReg.shouldHave(text(address));
        assertReg.shouldHave(text("NCR"+" Delhi"));
        $$(".table tr td").get(7).shouldHave(text(phone));

    }
}
