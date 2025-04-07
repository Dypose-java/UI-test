package api_and_ui.present_example_sushi_wok.config_sushi_wok;


import api_and_ui.config.App;
import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigFactory;

import static org.aeonbits.owner.Config.*;

@LoadPolicy(LoadType.MERGE)
@Sources({
        "system:properties",
        "classpath:api_and_ui/sushiWok.properties"
})
public interface SushiConfig extends Config{
    @Key("sw.urlApi")
    String getUrlApi();

    @Key("sw.urlUI")
    String getUrlUI();

    @Key("sw.login")
    String getLog();

    @Key("sw.password")
    String getPas();

    @Key("sw.cookie")
String getCokie();

    SushiConfig CONFIG = ConfigFactory.create(SushiConfig.class,System.getProperties());
}
