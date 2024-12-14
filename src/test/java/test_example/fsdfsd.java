package test_example;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class fsdfsd {
    @Test
    void dfsfs(){
        Selenide.open("https://github.com/qa-guru/knowledge-base/wiki/9.-Selenide-%231");

        $("#js-repo-pjax-container").shouldHave(text("9. Selenide #1"));
        $(".repository-content ").shouldHave(text("9. Selenide #1"));
        $(".wiki-rightbar p a").click();


    }
}
