package selenoid;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class TreadUiForm {
    public TreadUiForm(String url) {
        Selenide.open(url);
    }
    public TreadUiForm selectCard(String name){
        $$(".card-body h5").filter(text(name)).first().click();
        return this;
    }
    public TreadUiForm selectElementCard(String name){
        $$(".text").filter(Condition.text(name)).first().click();
        return this;
    }
    public TreadUiForm setName(String name){
        $("#firstName").setValue(name);
        return this;
    }
    public TreadUiForm assertName(String name){
        $("#firstName").shouldHave(Condition.text(name));
        return this;
    }
    public TreadUiForm clickSubmit(){
        $("#submit").click();
        return this;
    }
}
