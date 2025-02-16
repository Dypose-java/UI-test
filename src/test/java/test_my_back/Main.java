package test_my_back;

import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import test_my_back.pojo.Data;

import static io.qameta.allure.SeverityLevel.NORMAL;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static test_my_back.speck.Specification.mainResponse;
import static test_my_back.speck.Specification.responseSpecification;

public class Main {

    @Epic("api")
    @Severity(NORMAL)
    @Tag("get")
    @Owner("Me")
    @DisplayName("проверка отображения запроса на получение всех пользователей")
    @Test
    void check() {
        Data pojoData = given(mainResponse(ContentType.JSON))
                .get("users/first").then()
                .spec(responseSpecification(200))
                .extract().as(Data.class);
        assertThat(pojoData).isNotNull();
        assertThat("user").isEqualTo(pojoData.getLogin());
    }
}
