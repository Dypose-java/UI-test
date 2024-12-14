package my_test;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$x;

public class CheckBox {


    private final SelenideElement butPlus=$x("//div[@class='rct-options']/button[1]");
    private final  SelenideElement spanWordFile=$x("//span[text()='Word File.doc']");
    private final  SelenideElement spanRes=$x("//span[@class='text-success']");

    public CheckBox() {
        Selenide.open("https://demoqa.com/checkbox");
    }

    void WordFile(){
       butPlus.click();
       spanWordFile.click();

   }
   String getRealRes(){
        return spanRes.getText();
   }
}
