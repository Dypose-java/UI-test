package gs_producing_web_service;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.internal.util.IOUtils;
import io.restassured.response.Response;
import io.spring.guides.gs_producing_web_service.GetCountryRequest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.io.InputStream;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class MainTest {
    private final InputStream RESOURSE = MainTest.class.getClassLoader().getResourceAsStream("getCountryRequest.xml");

    @BeforeAll
    static void setUp(){
        RestAssured.baseURI="http://localhost:8080/ws/";
    }

    @Test
    void getCountryTestFromXmlFileBody() throws IOException {
      String string = new String(IOUtils.toByteArray(RESOURSE));
        Response getCountry = given()
                .header("Content-Type", "text/xml")
                .body(string)
                .post("getCountry")
                .then()
                .statusCode(200)
                .log().body()
                .extract().response();
        assertThat(getCountry.asString().contains("Madrid")).isTrue();
    }


}
