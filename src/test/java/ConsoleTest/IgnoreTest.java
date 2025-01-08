package ConsoleTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
@Tag("console")
public class IgnoreTest {
    @Test
    @Disabled("edit")
    void test1(){
        Assertions.assertTrue(false);
    }
    @Test
    @Disabled("edit")
    void test2() {
        Assertions.assertTrue(false);
    }
}
