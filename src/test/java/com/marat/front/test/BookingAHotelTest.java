package com.marat.front.test;

import io.qameta.allure.AllureId;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.*;

@Feature("Booking a hotel")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BookingAHotelTest extends TestBase {

    @Order(1)
    @Tag("front")
    @DisplayName("Hotels")
    @AllureId("15212")
    @Test
    @Owner("Marat")
    public void searchHotel() {
        bookingAHotelPage.hotels();
        bookingAHotelPage.checkResults();
    }

}
