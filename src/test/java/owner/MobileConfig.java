package owner;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;

import static org.aeonbits.owner.Config.*;
import static org.assertj.core.api.AssertionsForClassTypes.*;

@Sources({
        "classpath:file_conf/${name_config_device}.properties",
                "classpath:file_conf/mobile.properties",
        })
public interface MobileConfig extends Config {

    @Key("device.name")
    String getDeviceName();
    @Key("platform.version")
    String getVersion();
    @Key("platform.name")
    String getPlatformName();
}
class Tests{
    @Test
    void readFilePropertyTest(){
        MobileConfig config = ConfigFactory.create(MobileConfig.class, System.getProperties());
        assertThat(config.getDeviceName()).isEqualTo("xiomi redmi pro max 1337 256 fps 1gb ddr52");
        assertThat(config.getVersion()).isEqualTo("1337");
    }
    @Test
    void setNameConfFileTest(){
        System.setProperty("name_config_device","iphone-15-pro");
        MobileConfig config = ConfigFactory.create(MobileConfig.class, System.getProperties());
        assertThat(config.getDeviceName()).isEqualTo("iphone 15 pro");
    }
}
