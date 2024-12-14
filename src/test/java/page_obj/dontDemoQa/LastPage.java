package page_obj.dontDemoQa;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class LastPage {
    public String assertTitle(){
        return $("#container div h1").getOwnText();
    }
}
