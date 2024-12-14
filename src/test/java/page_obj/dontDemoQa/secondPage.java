package page_obj.dontDemoQa;

import static com.codeborne.selenide.Selenide.$$;

public class secondPage {

    public LastPage selectJavaSe(){
        $$(".navmenu a").first().click();
        return new LastPage();
    }
}
