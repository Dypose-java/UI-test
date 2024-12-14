package page_obj.dontDemoQa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class runTest {
    @Test
    void testMetanitSelectJavaSe(){
        String expectedRes="Руководство по языку программирования Java";
        String realRes=new mainPage("https://metanit.com/").selectJava().selectJavaSe().assertTitle();
        Assertions.assertEquals(expectedRes,realRes);
        System.out.println();
    }
}
