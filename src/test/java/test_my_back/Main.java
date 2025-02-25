package test_my_back;

import api_test.in.regres.help.LocalDate;
import com.github.javafaker.Faker;
import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import test_my_back.pojo.response.CreateUser;
import test_my_back.pojo.response.ResponseSetValueUser;
import test_my_back.pojo.User;
import test_my_back.pojo.UserGet;

import java.time.LocalDateTime;
import java.util.*;

import static io.qameta.allure.SeverityLevel.BLOCKER;
import static io.qameta.allure.SeverityLevel.NORMAL;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static test_my_back.speck.Specification.mainRequest;
import static test_my_back.speck.Specification.responseSpecification;

public class Main {
    final Faker localRu = new Faker(new Locale("ru"));
    final Faker faker = new Faker();
    final String FIRST_NAME_RU = localRu.name().firstName();
    final String LOGIN = faker.name().firstName();
   final String PASSWORD = faker.internet().password().substring(0,6);
   final int ID =new Random().nextInt(100);

    @Epic("api")
    @Severity(NORMAL)
    @Tag("get")
    @Owner("Me")
    @DisplayName("проверка отображения запроса на получение 1 пользователя")
    @Test
    void getUser() {
        UserGet.Data pojoData = given(mainRequest(ContentType.JSON))
                .get("users/first").then()
                .spec(responseSpecification(200))
                .extract().as(UserGet.Data.class);
        assertThat(pojoData).isNotNull();
        assertThat("user").isEqualTo(pojoData.getLogin());
    }
    @Epic("api")
    @Severity(NORMAL)
    @Tag("get")
    @Owner("Me")
    @DisplayName("проверка отображения запроса на получение всех пользователей")
    @Test
    void getAllUsers() {
        List<UserGet.Data> data = given(mainRequest(ContentType.JSON))
                .get("users/all").then()
                .spec(responseSpecification(200))
                .extract().jsonPath().getList("data", UserGet.Data.class);
        assertThat(data).isNotNull();
        assertThat(data.stream().count()).matches(el->el>=5);
    }
    @Epic("api")
    @Severity(BLOCKER)
    @Tag("post")
    @Owner("Me")
    @DisplayName("проверка изменение данных пользователя")
    @Test
    void postNewValueUser() {
        User bodyUser = new User(7,LOGIN,PASSWORD);
        ResponseSetValueUser responseSetValueUser = given(mainRequest(ContentType.JSON))
                .body(bodyUser).post("users/update")
                .then().spec(responseSpecification(200))
                .extract().as(ResponseSetValueUser.class);
        assertThat(responseSetValueUser).isNotNull();
        assertThat(bodyUser.getId()).isEqualTo(responseSetValueUser.getId());
        assertThat(bodyUser.getLogin()).isEqualTo(responseSetValueUser.getLogin());
    }
    @Epic("api")
    @Severity(BLOCKER)
    @Tag("post")
    @Owner("Me")
    @DisplayName("проверка создание пользователя")
    @Test
    void putNewUser() {
        User newUser = new User(ID,LOGIN,PASSWORD);
        CreateUser createUser = given(mainRequest(ContentType.JSON))
                .body(newUser)
                .put("users/add")
                .then().spec(responseSpecification(200))
                .extract().as(CreateUser.class);
        assertThat(createUser).isNotNull();
        LocalDateTime date = LocalDateTime.now();
        date.getDayOfMonth();
        System.out.println(createUser.getDate());
    }
}
