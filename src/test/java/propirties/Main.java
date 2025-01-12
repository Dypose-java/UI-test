package propirties;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class Main  {
    @Test
    @Tag("property")
    void simplePropirties(){
        String browserName =System.getProperty("browser","firefox");
        System.out.println(browserName);

        //./gradlew  property
        // ./gradlew property -Dbrowser="chrome"
    }
    @Test
    @Tags({@Tag("property"),@Tag("property1")})
    void simplePropirties1(){
        System.out.println("your name:"+System.getProperty("name","null"));
        //./gradlew clean property -Dname="pidor"
        //./gradlew clean property -Dname="pidor pidoras"
    }
    @Test
    @Tag("excludeTags")
    void dontRunTestTask(){
        System.out.println(System.getProperty("name","dypose"));
    }
}
