package page_obj;

import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class LastPage {
    static final String EXPECTED_RES ="This is a sample page";
public String getTextNewTub(){
    return  $("#sampleHeading").getOwnText();
}
public void AssertMenu(String text){
     $(".emotion-cfekil").shouldHave(text(text));
}
public void refresh(){
    Selenide.refresh();
}
}
