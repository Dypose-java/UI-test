package page_obj.dont_demo_qa;

import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selenide.$$;

public class mainPage {
    public mainPage(String url) {
        Selenide.open(url);
    }
    public secondPage selectJava(){
        $$(".navmenu a").get(4).click();
        return new secondPage();
    }
}
