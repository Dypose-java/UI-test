package randCheckApi;

import io.qameta.allure.AllureId;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static randCheckApi.Specification.mainRequestSpec;
import static randCheckApi.Specification.mainResponseSpec;

@Tag("docs.spacexdata.com")
public class Main {
    static final String capsule_serial = "C112";

    @Severity(SeverityLevel.NORMAL)
    @Epic("docs.spacexdata.com")
    @DisplayName("Проверка запроса get " + capsule_serial)
    @Tag("Api")
    @Test
    void checkPostmanApiTest() {
        given(mainRequestSpec())
                .when()
                .get("/capsules/" + capsule_serial)
                .then().spec(mainResponseSpec(200)).body("capsule_serial", Matchers.is(capsule_serial));

    }

    @Test
    @AllureId("36828")
    void checkStep() {
        step("Измения ручного на автоматизированный");
    }
}
