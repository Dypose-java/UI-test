package page_obj.web_tables;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class WebTables {

    public WebTables openUrl(String url){
        Configuration.baseUrl="https://demoqa.com";
        Selenide.open(url);
        return this;
    }
    public WebTables butAdd(){
        $("#addNewRecordButton").click();
        return this;
    }
    public WebTables butTypeToSearch(String text){
        $("#searchBox").click();
        return this;
    }//todo проверка по всей таблице
    public WebTables editUser(String user){
        $(byText(user)).parent().parent().$(".action-buttons span").click();
        return this;
    }
    public WebTables deliteUser(String user){
        $(byText(user)).parent().parent().$$(".action-buttons span").last().click();
        return this;
    }
    public WebTables assertDelUser(String user){
        $(".rt-table").shouldNotHave(text(user));
        return this;
    }
    public WebTables assertAddUser(String user){
        $(".rt-table").shouldHave(text(user));
        return this;
    }
}
