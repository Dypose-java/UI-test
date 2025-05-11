import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.sleep;

public class dfsdfsdf {
    @Test
    void adadas(){
        Configuration.browser= "chrome";
        Configuration.baseUrl= "https://translate.yandex.ru";
        Configuration.browserSize= "1920x1980";
        Selenide.open();
        sleep(3000);
    }
}
