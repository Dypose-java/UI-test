package page_obj;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class FirstPage {
    public FirstPage(String url) {
        Selenide.open(url);
    }

    public LastPage newTab(){
        $("#tabButton").click();
        return new LastPage();
    }
    public LastPage newWindow(){
        $("#windowButton").click();
        return new LastPage();
    }
    public LastPage newWindowMessage(){
        $("#messageWindowButton").click();
        return new LastPage();
    }

    public LastPage clickMenu(){
        $$(".emotion-1mceoyq li a span").first().click();
        return new LastPage();
    }


}
