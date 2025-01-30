package owner.dataTypesAndCollection;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static org.aeonbits.owner.Config.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public interface Metods extends Config{
    @Key("int")
    @DefaultValue("10")
    int getInt();
    @Key("str")
    @DefaultValue("аче)")
    String getStr();
    @Key("bool")
    @DefaultValue("true")
    Boolean getBoolean();
    @Key("array")
    @DefaultValue("dy,po,se")
    String []getArray();
    @Key("list")
    @DefaultValue("1,2,3,4,5,6,7,8,9")
    List<Integer> listInt();
}
class Tests{
    @Test
    void test(){
        Metods config = ConfigFactory.create(Metods.class, System.getProperties());
        assertThat(config.getInt()).isEqualTo(10);
        assertThat(config.getStr()).isEqualTo("аче)");
        assertThat(config.getBoolean()).isTrue();
        assertThat(config.listInt()).isEqualTo(IntStream.rangeClosed(1,9).boxed().toList());
        assertThat(config.getArray()).isEqualTo(Arrays.stream("dy,po,se".split(",")).toArray());
    }
}
