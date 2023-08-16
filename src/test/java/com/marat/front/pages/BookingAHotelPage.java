package com.marat.front.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;
import static com.marat.front.tests.TestData.cityHotel;
import static io.qameta.allure.Allure.step;

public class BookingAHotelPage {

    private final SelenideElement
            hotelTab = $$("[data-type='hotels']").get(1),
            checkBox = $(".o33616"),
            cityInputArea = $("[data-ti='hotels-destination-input']"),
            approveSelect = $$("[data-ti='suggest-item']").get(0),
            dateInputArea = $("[data-ti='date-input']"),
            buttonRight = $("[data-ti='order-calendar-navigation-next']"),
            dayBegins = $("[aria-label='Sat Apr 01 2023']"), // $("[data-ti-date='2023-04-01T08:00:00.000Z']"),
            dayEnds = $("[aria-label='Sun Apr 30 2023']"), // $("[data-ti-date='2023-04-30T08:00:00.000Z']"),
            guestSelectArea = $("[data-ti='guest-input']"),
            adultsGuests = $$("[data-ti='order-button-slot-content']").get(2),
            childrenGuests = $$("[data-ti='order-button-slot-content']").get(4),
            approveSelectedGuests = $("[data-ti='hotels-guest-bottom-button']"),
            slideAgeChildOne = $$("._3JhjQiplIukA_-M_xkpNAt").get(0),
            slideAgeChildTwo = $$("._3JhjQiplIukA_-M_xkpNAt").get(1),
            searchButton = $("[data-ti='order-button-slot-content']"),
            cityCheck = $$("span").get(23),
            dateAndGuestsCheck = $$("span").get(24),
            scrollToBlock = $("._3CiITpDw1x-x7RK80YSACL"),
            hotelCheck = $$(".Cu8QgpxhPYAa62VjVVpH").get(0);

    public void hotels() {
        step("Click on hotels", () -> {
            hotelTab.click();
        });

        step("Click on checkbox", () -> {
            checkBox.click();
        });

        step("Set town", () -> {
            cityInputArea.setValue(cityHotel);
            sleep(2000);
            approveSelect.click();
        });

        step("Set date", () -> {
            scrollToBlock.scrollTo();
            dateInputArea.click();
            buttonRight.click();
        });

        step("Select day", () -> {
            dayBegins.click();
            dayEnds.click();
        });

        step("Select guests and age", () -> {
            guestSelectArea.click();
            adultsGuests.click();
            childrenGuests.doubleClick();
            actions().dragAndDropBy(slideAgeChildOne, -10, 0).perform();
            actions().dragAndDropBy(slideAgeChildTwo, -70, 0).perform();
            //sleep(3000);
        });

        step("Approve selected guests", () -> {
            approveSelectedGuests.click();
            //sleep(3000);
        });

        step("Search hotel - results", () -> {
            searchButton.click();
            //sleep(4000);
        });
    }

    public void checkResults() {
        step("Check availability", () -> {
            cityCheck.shouldHave(Condition.text("Сочи"));
            dateAndGuestsCheck.shouldHave(Condition.text("1 апр - 30 апр • 5 гостей"));
            hotelCheck.shouldBe(Condition.exist);
        });
    }
}
