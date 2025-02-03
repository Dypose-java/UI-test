package helpers;

import io.qameta.allure.restassured.AllureRestAssured;

public class CustomApiListiner {
    private final static AllureRestAssured ALLURE_REST_ASSURED = new AllureRestAssured();
    public static AllureRestAssured withCustomTemplate(){
        ALLURE_REST_ASSURED.setRequestTemplate("request.ftl");
        ALLURE_REST_ASSURED.setResponseTemplate("response.ftl");
        return ALLURE_REST_ASSURED;
    }


}
