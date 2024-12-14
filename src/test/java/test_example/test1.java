package test_example;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class test1 {

    @BeforeEach
    void openUrl(){

    }
    @AfterEach
    void closeWindow(){
        WebDriverRunner.closeWindow();
    }
    /**
     * открыть стр git
     * ввести selenide/selenide
     * открыть первый url
     * сравнить ожидаемый рез(selenide/selenide) с фактическим
     */
    @Test
    void testGit(){
        Selenide.open("https://github.com/home");
        $x("//div[@data-action='click:qbsearch-input#searchInputContainerClicked']").click();
        $x("//input[@id='query-builder-test']").setValue("selenide/selenide").pressEnter();
       $x("//div[@data-testid='results-list']//div//a//span/em[text()='selenide']").click();
       $(".AppHeader-context-full").shouldHave(text("selenide / selenide"));

    }
    @Test
    void testGit2(){
        Selenide.open("https://github.com/selenide/selenide");
        //$(".BorderGrid").$(byText("Contributors")).ancestor(".BorderGrid-row").$$("ul li").first().hover();
        $x("//ul[@class='list-style-none d-flex flex-wrap mb-n2']/li").hover();

        /*String sds=$x("//a[@class='Link--secondary no-underline ml-1']").getOwnText();
        Assertions.assertEquals("Andrei Solntsev",sds);*/

       /* $x("//a[@class='Link--secondary no-underline ml-1']").shouldHave(text("Andrei Solntsev"));*/
       $(".Popover").shouldHave(text("Andrei Solntsev"));

    }
}
