package my_test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.*;

public class Run_test {

    @BeforeEach
    void openPage(){
        Configuration.holdBrowserOpen =false;
        Configuration.browser="chrome";
        Configuration.timeout=10_000;
    }
    @AfterEach
    void closeWindow(){
        WebDriverRunner.closeWindow();
    }


    @DisplayName("Word file")
    @Test
    void testWordFile(){
        CheckBox checkBox = new CheckBox();
        checkBox.WordFile();
        String expectedRes="wordFile";
        Assertions.assertEquals(expectedRes,checkBox.getRealRes());
    }
}
