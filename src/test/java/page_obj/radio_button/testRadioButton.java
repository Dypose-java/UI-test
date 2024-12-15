package page_obj.radio_button;

import org.junit.jupiter.api.Test;
import page_obj.practice_form.MainSelenide;

public class testRadioButton extends MainSelenide {
    private final String url="/radio-button";
    private final String titleBaseUrl="Radio Button";
    @Test
    void butYes(){
        String text ="Yes";
        new RadioButton().
                openUrl(url).
                assertTitileBaseUrl(titleBaseUrl).
                butYes().assertText(text);
    }
    @Test
    void butImpressive(){
        String text ="Impressive";
        new RadioButton().
                openUrl(url).
                  assertTitileBaseUrl(titleBaseUrl).
                    butImpressive().
                     assertText(text);
    }


}
