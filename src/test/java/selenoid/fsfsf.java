package selenoid;

import org.junit.jupiter.api.Test;

public class fsfsf {
    private final String NAME ="dypose";
    @Test
    void treadForm(){

        new TreadUiForm("http://85.192.34.140:8081/")
                .selectCard("Forms")
                .selectElementCard("Practice Form")
                .setName(NAME)
                .clickSubmit();
    }
}
