package page_obj.radio_button;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class RadioButton {


    public RadioButton openUrl(String url){
        Configuration.baseUrl="https://demoqa.com";
        Selenide.open(url);
        return this;
    }

    public RadioButton butYes(){
        $("#yesRadio").parent().$("label").click();
        return this;
    }
    public RadioButton assertText(String text){
        $(".text-success").shouldHave(text(text));
        return this;
    }
    public RadioButton assertTitileBaseUrl(String text){
        $(".text-center").shouldHave(text(text));
        return this;
    }
    public RadioButton butImpressive(){
        $("#impressiveRadio").parent().$("label").click();
        return this;
    }

}
