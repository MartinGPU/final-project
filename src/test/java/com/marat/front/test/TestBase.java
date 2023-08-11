package com.marat.front.test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.marat.front.config.CredentialsConfig;
import com.marat.front.helpers.Attach;
import com.marat.front.pages.BookingAHotelPage;
import com.marat.front.pages.SearchStoriesPage;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Selenide.open;

public class TestBase {

    public static CredentialsConfig credentials = ConfigFactory.create(CredentialsConfig.class);
    BookingAHotelPage bookingAHotelPage = new BookingAHotelPage();
    SearchStoriesPage searchStoriesPage = new SearchStoriesPage();

    @BeforeAll
    public static void beforeAll() {
        Configuration.baseUrl = "https://www.tutu.ru/";
        Configuration.browserVersion = System.getProperty("version", "98");
        Configuration.browserSize = System.getProperty("size", "1366x900");
        Configuration.browser = System.getProperty("browser", "firefox");
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
        //Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub/";
        Configuration.remote = String.format("https://%s:%s@%s", credentials.remoteLogin(), credentials.remotePassword(), credentials.remoteUrl());
    }

    @BeforeEach
    public void beforeEach() {
        open("");
    }
    @AfterEach
    public void tearDown() {
        Attach.screenshotAs("Last screen");
        Attach.pageSource();
//        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}
