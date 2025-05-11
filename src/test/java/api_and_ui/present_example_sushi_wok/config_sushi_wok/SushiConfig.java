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
    @DefaultValue("https://sushiwok.ru/")
    String getUrlApi();

    @Key("sw.urlUI")
    @DefaultValue("https://sushiwok.ru/")
    String getUrlUI();

    @Key("sw.login")
    @DefaultValue("89688450693")
    String getLog();

    @Key("sw.password")
    @DefaultValue("1111")
    String getPas();

    @Key("sw.cookie")
    String getCokie();
    SushiConfig CONFIG = ConfigFactory.create(SushiConfig.class,System.getProperties());
}
