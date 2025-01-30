package api_test.in.regres;
import api_test.in.regres.help.QueryConstants;
import api_test.in.regres.pojo.Auth.ResponseUser;
import api_test.in.regres.pojo.Auth.User;
import api_test.in.regres.pojo.list_users.Data;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.stream.IntStream;

import static io.restassured.RestAssured.*;
import static io.restassured.http.ContentType.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.hamcrest.Matchers.*;

public class MainTest implements QueryConstants {

    @BeforeAll
    static void setUp() {
        RestAssured.baseURI="https://reqres.in/";
    }
    @Test
    void checkListUser(){
        given()
                .when()
                .get("api/users?page=2")
                .then().log().all()
                .statusCode(200)
                .body("page",is(2))
                .body("per_page",is(6));
    }
    @Test
    void checkRegUser(){
        String authBody="{ \"email\": \"eve.holt@reqres.in\", \"password\": \"pistol\" }";

        given()
                .when().
                body(authBody)
                .contentType(JSON)
                .post("/api/register")
                .then()
                .log().all()
                .body("id",is(4))
                .body("token",is("QpwL5tke4Pnpja7X4"));

    }
    @Test
    public void checkAuthUser(){
        HashMap<String,String> authUser= new HashMap<>();
        authUser.put("email","eve.holt@reqres.in");
        authUser.put("password","cityslicka");
        System.out.println(authUser);
        given()
                .when()
                .contentType(JSON)
                .body(authUser)
                .post("/api/login")
                .then().log().all()
                .body("token",is("QpwL5tke4Pnpja7X4"));

    }

    /*@Test
    void jsonParseTest() throws Exception {
        Gson gson = new Gson();
        try (InputStream resource = cl.getResourceAsStream("json/glossary.json");
             InputStreamReader reader = new InputStreamReader(resource)
        ) {
            JsonObject jsonObject = gson.fromJson(reader, JsonObject.class);
            assertThat(jsonObject.get("glossary").getAsJsonObject().get("title").getAsString()).isEqualTo("example glossary");
            assertThat(jsonObject.get("glossary").getAsJsonObject().get("flag").getAsBoolean()).isTrue();
        }
    }*/
    @Test
    void checkListUserWithPojoClass(){
        List<Data> dataList = given()
                .when()
                .contentType(JSON)
                .get("api/users?page=2")
                .then().log().all()
                .statusCode(200)
                .extract()
                .body()
                .jsonPath()
                .getList("data", Data.class);
        List<String> actualDataId = dataList.stream().map(Data::getId).toList();
        List<String> expectedId = IntStream.rangeClosed(7,12).mapToObj(String::valueOf).toList();
        Assertions.assertEquals(expectedId,actualDataId);
    }

    @Test
    void checkRegUsingPojoClass() {
        User user = new User("eve.holt@reqres.in","cityslicka");
        ResponseUser expectedRes= new ResponseUser("4","QpwL5tke4Pnpja7X4");
        ResponseUser responseUser =given()
                .log().all()
                .contentType(JSON)
                .body(user)
                .when()
                .post(POST_REGISTER_SUCCESSFUL)
                .then()
                 .log().all()
                .statusCode(200)
                 .extract().as(ResponseUser.class);

        Assertions.assertEquals(expectedRes.getId(),responseUser.getId());
        Assertions.assertEquals(expectedRes.getToken(),responseUser.getToken());
    }
}

