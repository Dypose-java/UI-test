package api.com.tricentis.demowebshop;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class Main {
    @BeforeAll
    public static void setUp(){
        RestAssured.baseURI="https://demowebshop.tricentis.com/";
    }
    @Test
    void addToCardInBacketUserTest(){
        String cookie="7D4B84BC7F18906FCD075D227370AC2B48976350397DCDAAF8EF0E9AFC96376B3A41005E85B123F327AB6E5" +
                "852FCEA416B4E32503C01D3C2DE3135E2BF95B2996A15419F734491F5FE1AEBC46351B583EF465CEB20A970C81D0B" +
                "1FA6225C0C7BFFBABCB0E9557F1E85D8D788AEE20BEE630495F0AA305B4D1C9077F7B98339087EE833D3BCAF0130B" +
                "9471E0966C716782F5100174BD9C247FF4F07EE6A05F4A1;"
               ,body="addtocart_31.EnteredQuantity=1",
                post="addproducttocart/details/31/1";
        given()
                .cookie("NOPCOMMERCE.AUTH",cookie)
                .body(body)
                .when()
                .post(post)
                .then()
                .log().all().
                statusCode(200)
                .body("success",is(true));//assert
    }
    @Test
    void addToCardInBacketAnonymTest(){
        String body="addtocart_31.EnteredQuantity=1",
                post="addproducttocart/details/31/1";
        given()
                .body(body)
                .when()
                .post(post)
                .then()
                .log().all().
                statusCode(200)
                .body("success",is(true))//assert
                .body("updatetopcartsectionhtml",is("(1)"));
    }
    @Test
    void RefreshEmailUserTest(){
        String cookieValue="NOPCOMMERCE.AUTH=7D4B84BC7F18906FCD075D227370AC2B48976350397DCD" +
                "AAF8EF0E9AFC96376B3A41005E85B123F327AB6E5852FCEA416B4E32503C01D3C2DE3135E2BF9" +
                "5B2996A15419F734491F5FE1AEBC46351B583EF465CEB20A970C81D0B1FA6225C0C7BFFBABCB0E9557F" +
                "E85D8D788AEE20BEE630495F0AA305B4D1C9077F7B98339087EE833D3BCAF0130B9471E0966C716782F510" +
                "0174BD9C247FF4F07EE6A05F4A1; ";
        given()
                .cookie(cookieValue)
                .formParam("Email","55@mail.ru")
                .formParam("__RequestVerificationToken","7l9I9qcDtjlM4hjxnJSApDtBsQYTveSjPfUPG7BFT8gZFi8t_RPrCkRV0mkFBDdHjeoorJVykHsG2j7p_-zd9QFdYi_NuuWe_pcDXFkdj2YPUkrJvJTXrnwB6hE8dRAU0")
                .when()
                .post("https://demowebshop.tricentis.com/customer/info")
                .then()
                .log().all();
    }
}
