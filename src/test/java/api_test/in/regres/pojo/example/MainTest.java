package api_test.in.regres.pojo.example;

import org.junit.jupiter.api.Test;

public class MainTest {
    @Test
    void example(){
        User user = User.builder().id(5).build();
        System.out.println(user);
    }
}
