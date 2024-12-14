import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;

import java.util.Locale;

import static com.codeborne.selenide.Selenide.$x;

public class PageTextBox {
   private static final Faker fakerRu= new Faker(new Locale("ru"));
    private final static String FULL_NAME=fakerRu.name().fullName();
   private final static String EMAIL =fakerRu.internet().emailAddress();
    private final SelenideElement inputFullName=$x("//input[@id='userName']");
    private final SelenideElement inputEmail=$x("//input[@id='userEmail']");
    private final SelenideElement textAreaCurAdd=$x("//textarea[@id='currentAddresss']");
    private final SelenideElement textAreaPerAdd=$x("//textarea[@id='currentAddress']");
    private final SelenideElement butSubmit=$x("//button[@id='submit']");

    public PageTextBox() {
        Selenide.open("https://demoqa.com/text-box");
    }

    void allTest(){
       inputFullName.setValue(FULL_NAME);
       inputEmail.setValue(EMAIL);
       textAreaCurAdd.setValue("sdfs");

   }
   void testFullName(String name){
       inputFullName.setValue(name);

   }
}

