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
        given().header("X-Requested-With","XMLHttpRequest")
                .body("{\n" +
                "    \"phone\":\"+7(968)845-06-92\",\n" +
                "    \"code\":\"231130\"\n" +
                "}")
                .contentType(ContentType.JSON)
                .header("Cookie","_ym_uid=1727291633479176596; _ym_d=1727291633; default-city=false; cityTextId=msk; lang=ru; connect.sid=s%3AhWBay4JCw8MSE56ftWyd9RTTkAky5evA.vR0qmDZ3J2O%2FDP7sbgZLaLGfOLV8qFgPn88eZGXN7Pk; _sticky_param=b; _gcl_au=1.1.144102499.1741887509; _ga_TE53H5X77H=GS1.1.1741887508.1.0.1741887508.60.0.0; _ga=GA1.1.948291890.1741887509; _ym_isad=1; _ym_visorc=w")
                .post("https://sushiwok.ru/user/register_or_auth").then().log().all();

    }
}
