package page_obj.dont_demo_qa;

import static com.codeborne.selenide.Selenide.$$;

public class secondPage {

    public LastPage selectJavaSe(){
        $$(".navmenu a").first().click();
        return new LastPage();
    }
}
