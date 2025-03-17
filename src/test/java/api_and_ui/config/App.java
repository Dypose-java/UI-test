package api_and_ui.config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;

import static org.aeonbits.owner.Config.*;

@LoadPolicy(LoadType.MERGE)
@Sources({
        "system:properties",
        "classpath:api_and_ui/app.properties"
})
public interface App extends Config {
    @Key("app.webUrl")
    String webUrl();
    @Key("app.apiUrl")
    String apiUrl();
    @Key("app.userLogin")
    String userLogin();
    @Key("app.userPassword")
    String userPassword();

    App CONFIG = ConfigFactory.create(App.class, System.getProperties());
}

