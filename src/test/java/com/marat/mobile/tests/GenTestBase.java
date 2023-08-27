package com.marat.mobile.tests;

import com.codeborne.selenide.Configuration;
import com.marat.mobile.drivers.BrowserstackMobileDriver;
import com.marat.mobile.drivers.LocalMobileDriver;
import com.marat.mobile.drivers.RealMobileDriver;
import com.marat.mobile.drivers.SelenoidMobileDriver;
import com.marat.mobile.helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static com.marat.mobile.helpers.Attach.getSessionId;

public class GenTestBase {

    public static String deviceHost = System.getProperty("deviceHost");

    @BeforeAll
    static void beforeAll() {
        addListener("AllureSelenide", new AllureSelenide());
        if (deviceHost.equals("local")) {
            Configuration.browser = LocalMobileDriver.class.getName();
        } else if (deviceHost.equals("browserstack")) {
            Configuration.browser = BrowserstackMobileDriver.class.getName();
        } else if (deviceHost.equals("real")) {
            Configuration.browser = RealMobileDriver.class.getName();
        }else if (deviceHost.equals("selenoid")) {
            Configuration.browser = SelenoidMobileDriver.class.getName();
        }

        Configuration.pageLoadTimeout = 10000;
        Configuration.timeout = 10000;
        Configuration.browserSize = null;
    }

    @BeforeEach
    public void startDriver() {
        open();
    }

    @AfterEach
    public void afterEach() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        closeWebDriver();

        if (deviceHost.equals("browserstack")) {
            String sessionId = getSessionId();
            Attach.screenshotAs("Last screenshot");
            Attach.pageSource();
            closeWebDriver();
            Attach.attachVideo(sessionId);
        }
    }
}
