package api_test;

import api_test.in.regres.pojo.SingleUser;
import api_test.in.regres.pojo.create.Response;
import api_test.in.regres.pojo.create.User;
import api_test.in.regres.pojo.list_resource.Resource;
import io.qameta.allure.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static api_test.in.regres.help.QueryConstants.*;
import static io.qameta.allure.Allure.step;
import static io.qameta.allure.SeverityLevel.BLOCKER;
import static io.qameta.allure.SeverityLevel.NORMAL;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static specification.MainSpecification.mainRequestSpecification;
import static specification.MainSpecification.mainResponseSpecification;
import static org.hamcrest.Matchers.*;

@Epic("Api")
@Tag("jenkins")
@Feature("reqres.in")
public class Main {
    @BeforeAll
    public static void setUp() {
        baseURI = "https://reqres.in/";
    }


    @Story("create")
    @Owner("Dypose")
    @Tag("post")
    @Severity(BLOCKER)
    @DisplayName("Проверка создание пользователя")
    @Test
    void createUser() {
        User user = new User("dypose", "dypose");

        Response token = given(mainRequestSpecification())
                .body(user)
                .when()
                .post(POST_CREAT)
                .then()
                .spec(mainResponseSpecification(201))
                .extract().as(Response.class);

        assertThat(token).isNotNull();

        String dateUser = token.getCreatedAt().substring(0, 10);
        LocalDate loc = LocalDate.now();
        LocalDate localDate = loc.minusDays(1);

        assertThat(user.getName()).isEqualTo(token.getName());
        assertThat(user.getJob()).isEqualTo(token.getName());
        assertThat(localDate).isEqualTo(dateUser);
    }

    @Story("singleUser")
    @Tag("get")
    @Owner("Dypose")
    @Severity(BLOCKER)
    @DisplayName("Проверка ответа сервера на получение пользователя")
    @Test
    void getCheckSingleUser() {
        SingleUser.Data expectedData = new SingleUser.Data();
        expectedData.setAvatar("https://reqres.in/img/faces/2-image.jpg");

        step("check responce single user", () -> {
            SingleUser responseUser = given(mainRequestSpecification())
                    .when()
                    .get(GET_SINGLE_USER)
                    .then()
                    .spec(mainResponseSpecification(200))
                    .extract()
                    .as(SingleUser.class);
            assertThat(responseUser).isNotNull();

            assertThat(expectedData.getAvatar()).isEqualTo(responseUser.getData().getAvatar());

        });
    }

    @Story("singleUser")
    @Owner("Dypose")
    @Severity(NORMAL)
    @Tag("get")
    @DisplayName("Проверка неуспешного получение пользователя")
    @Test
    void checkSingleUserNotFound() {

        Object o = given(mainRequestSpecification())
                .get(GET_SINGLE_USER_NOT_FOUND)
                .then()
                .spec(mainResponseSpecification(404)).extract().jsonPath().get();

        assertThat(o.toString()).isEqualTo("{}");
    }

    @Story("listResource")
    @Owner("Dypose")
    @Severity(NORMAL)
    @Tag("get")
    @DisplayName("Проверка получение ресурсов")
    @Test
    void checkListResource() {
        List<Resource.Data> list = given(mainRequestSpecification())
                .when()
                .get(GET_LIST_RESOURCE)
                .then()
                .spec(mainResponseSpecification(200))
                .body("total", is(12))
                .extract().jsonPath().getList("data", Resource.Data.class);
        assertThat(list).isNotNull();

        assertThat(list.stream().map(Resource.Data::getColor).allMatch(el->el.startsWith("#"))).isTrue();
        assertThat(list.stream().map(Resource.Data::getId).map(Integer::parseInt).allMatch(el->el>0)).isTrue();
        assertThat(list.stream().map(Resource.Data::getYear).allMatch(el->el.length()==4)).isTrue();

    }
}
