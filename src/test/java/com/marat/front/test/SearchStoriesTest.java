package com.marat.front.test;

import io.qameta.allure.AllureId;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.*;

@Feature("Story search")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SearchStoriesTest extends TestBase {

    @Order(2)
    @Tag("front")
    @DisplayName("Stories")
    @AllureId("")
    @Test
    @Owner("Marat")
    public void searchStories() {
        searchStoriesPage.stories();
        searchStoriesPage.checkResults();
    }
}
