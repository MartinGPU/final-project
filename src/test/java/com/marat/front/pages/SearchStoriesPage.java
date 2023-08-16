package com.marat.front.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.marat.front.tests.TestData.desiredStory;
import static io.qameta.allure.Allure.step;

public class SearchStoriesPage {

    private final SelenideElement
            plots = $("[data-ti-nav-item='story']"),
            searchItem = $("#infinite-top-search"),
            searchBox = $$("[type='text']").get(1),
            searchResults = $(".infinite-page-title");

    public void stories() {
        step("Clicking to stories", () -> {
            plots.click();
        });

        step("Clicking to search item", () -> {
            searchItem.click();
        });

        step("Set desired story", () -> {
            searchBox.setValue(desiredStory).pressEnter();
            sleep(20000);
        });
    }

    public void checkResults() {
        step("Checking results of story search", () -> {
            searchResults.shouldHave(text(desiredStory));
        });
    }
}
