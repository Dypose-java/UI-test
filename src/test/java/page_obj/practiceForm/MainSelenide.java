package page_obj.practiceForm;

import com.codeborne.selenide.Configuration;

public class MainSelenide {
    public MainSelenide() {
        Configuration.holdBrowserOpen =false;
        Configuration.browser="chrome";
        Configuration.timeout=10_000;
        Configuration.browserSize="1920X1980";
    }
}
