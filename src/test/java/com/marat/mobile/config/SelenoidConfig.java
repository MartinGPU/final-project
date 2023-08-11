package com.marat.mobile.config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:${deviceHost}.properties"})
public interface SelenoidConfig extends Config{

    @Key("selenoidPlatformName")
    String getSelenoidPlatformName();

    @Key("selenoidDeviceName")
    String getSelenoidDeviceName();

    @Key("selenoidVersion")
    String getSelenoidVersionName();

    @Key("selenoidLocale")
    String getSelenoidLocale();

    @Key("selenoidLanguage")
    String getSelenoidLanguage();

    @Key("selenoidAppPackage")
    String getSelenoidAppPackage();

    @Key("selenoidAppActivity")
    String getSelenoidAppActivity();

    @Key("selenoidAppiumUrl")
    String getSelenoidAppiumUrl();

}
