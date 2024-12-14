import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class PageWebTables {
    private final SelenideElement editUser=$x("//span[@id='edit-record-1']");
    private final SelenideElement inputFirstName=$x("//input[@id='firstName']");
    private final SelenideElement inputAge=$x("//input[@id='age']");

    public PageWebTables() {
        Selenide.open("https://demoqa.com/webtables");
    }

    void testRenameFirstNameAndAge(String name, int age){
        editUser.click();
        inputFirstName.setValue(name);
        inputAge.setValue(String.valueOf(age));

    }

}
