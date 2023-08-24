package com.marat.front.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.marat.front.tests.TestData.desiredStory;
import static io.qameta.allure.Allure.step;

public class SearchStoriesPage {

    private final SelenideElement
            searchItem = $$("input").get(0),
            searchBox = $("[name='search']"),
            searchResults = $$("span").get(19);

    public void stories() {
        step("Clicking to stories", () -> {
            open("https://go.tutu.ru");
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
