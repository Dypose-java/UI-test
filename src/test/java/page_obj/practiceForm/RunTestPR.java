package page_obj.practiceForm;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RunTestPR extends MainSelenide {
    @BeforeEach
    void baseUrl(){
        Configuration.baseUrl="https://demoqa.com";
    }
    @Test
    void test(){
        Selenide.open("/automation-practice-form");

        new PracticeForm().assertTitleUrl().
                setFirstName("dypose").
                setLastName("dypose").
                setEmail("d.bol@mail.ru").
                setPhone("89688450693").
                dateBirth("December", "2002", "6").
                setPhone("89688450693").
                selectGender("Male").
                selectHobbies("Sports").
                addPicture().
                setCurrentAddress("улица пизда д манда").
                setStateAndSity("NCR", "Noida").butSubmit();
        //todo вынести переменные,сделать метод для проверки и проверить ожидаемый и реальный результат
    }
}
