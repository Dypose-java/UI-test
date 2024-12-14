package page_obj;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class RunTest {
    String url ="https://demoqa.com/browser-windows";
    @BeforeEach
    void setUp() {
        Configuration.browserSize="1920x1980";
        Configuration.timeout=5_000;
    }
    @Test
    void newTab(){
       /* String expectedRes="This is a sample page";
        String realRes =new FirstPage(url).newTab().getTextNewTub();
        Assertions.assertEquals(expectedRes,realRes);*/
        new FirstPage(url).newTab();
        sleep(5000);
    }
    @Test
    void mamyEbalDemoQa(){
        Selenide.open("https://demoqa.com/sample");
       String text = $("#sampleHeading").getOwnText();
    }
    @Test
    void fgdfgdf(){
        Selenide.open("https://demoqa.com/sample");
        $("#sampleHeading").shouldHave(text("This is a sample page"));
        $("body h1").shouldHave(text("This is a sample page"));
    }
    @Test
    void gdfgdfgd(){
        Selenide.open("https://eda.ru/recepty/rolli?ysclid=m4kcdqd7iq640536366");
        $$(".emotion-1mceoyq li a span").first().click();
        $(".emotion-cfekil").shouldHave(text("Рецепты\n" +
                "основных блюд"));
        sleep(5_000);

    }
    @Test
    void gdfgdfgdgd(){
        String text ="Рецепты\n"+"основных блюд";
        new FirstPage("https://eda.ru/recepty/rolli?ysclid=m4kcdqd7iq640536366").clickMenu().AssertMenu(text);
    }

}
