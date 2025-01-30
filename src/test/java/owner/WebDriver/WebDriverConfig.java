package owner.WebDriver;

import org.aeonbits.owner.Config;

import static org.aeonbits.owner.Config.*;

public interface WebDriverConfig extends Config {
    @Key("baseUrl")
    @DefaultValue("https://github.com")
    String getBaseUrl();

    @Key("browser")
    @DefaultValue("CHROME")
    Browser getBrowser();
}
