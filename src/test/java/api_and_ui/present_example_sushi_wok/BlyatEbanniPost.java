package api_and_ui.present_example_sushi_wok;

import io.restassured.http.ContentType;
import lombok.Builder;
import lombok.Data;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class BlyatEbanniPost {
    @Data
    @Builder
   static class RegresUser{
      private String name,job;
   }
    @Test
    void check(){
        given().body(RegresUser.builder().job("leader").name("morpheus").build())
                .contentType(ContentType.JSON).post("https://reqres.in/api/users").then().log().all();
    }
    @Data
    @Builder
    static class UserSushiWok{
        private String phone,code;

    }
    @Test
    void ckeck2(){
       given().header("X-Requested-With","XMLHttpRequest").body("{\n" +
               "    \"phone\":\"+7(968)845-06-92\",\n" +
               "    \"code\":\"812592\"\n" +
               "}").contentType(ContentType.JSON).post("https://sushiwok.ru/user/register_or_auth").then().log().all();
    }
    @Test
    void fdsfsdfs(){
given().contentType(ContentType.JSON).body("{\n" +
        "    \"name\": \"morpheus\",\n" +
        "    \"job\": \"leader\"\n" +
        "}").post("https://reqres.in/api/users").then().log().all();
    }
}
