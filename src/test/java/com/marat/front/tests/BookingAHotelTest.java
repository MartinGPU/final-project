package com.marat.front.tests;

import com.marat.allure.JiraIssue;
import com.marat.allure.JiraIssues;
import com.marat.allure.Layer;
import io.qameta.allure.AllureId;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Step;
import org.junit.jupiter.api.*;

@Layer("UI")
@Feature("Booking a hotel")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BookingAHotelTest extends TestBase {


    @Tag("front")
    @AllureId("")
    @JiraIssues({@JiraIssue("")})
    @Test
    @Owner("Marat")
    @Step("Search hotels")
    public void searchHotel() {
        bookingAHotelPage.hotels();
    }

    @Tag("front")
    @JiraIssues({@JiraIssue("")})
    @AllureId("")
    @Test
    @Owner("Marat")
    @Step("Check hotels")
    public void checkHotelsResult() {
        bookingAHotelPage.checkResults();
    }

}
