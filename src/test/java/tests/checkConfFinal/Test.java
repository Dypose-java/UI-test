package tests.checkConfFinal;

import page.WikipediaPage;

public class Test extends BaseTest {
    @org.junit.jupiter.api.Test
    void successfulSearchTest() {

        WikipediaPage
                .wikipedia()
                .skipWelcomeScreen()
                .searchFor("Java")
                .selectSearchResult(0)
                .verifyTitleContains("java");

    }

}
