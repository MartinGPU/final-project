package com.marat.front.tests;

import io.qameta.allure.AllureId;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Step;
import org.junit.jupiter.api.*;

@Feature("Story search")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SearchStoriesTest extends TestBase {


    @Tag("front")
    @AllureId("")
    @Test
    @Owner("Marat")
    @Step("Search stories")
    public void searchStories() {
        searchStoriesPage.stories();
    }

    @Tag("front")
    @AllureId("")
    @Test
    @Owner("Marat")
    @Step("Check stories")
    public void checkStoriesResults() {
        searchStoriesPage.checkResults();
    }
}
