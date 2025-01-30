package owner;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import owner.WebDriver.WebDriverProvider;

public class Main  {
    private WebDriver driver;
    @BeforeEach
    public void startDriver() {
        driver = new WebDriverProvider().get();
    }
@Tag("testWebDriverProvider")
    @Test
    void testWebDriverProvider(){

    }
    @AfterEach
    public void stopDriver() {
        driver.quit();
    }
}
