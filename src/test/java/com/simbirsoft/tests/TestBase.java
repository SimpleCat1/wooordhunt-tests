package com.simbirsoft.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.simbirsoft.config.CredentialsConfig;
import com.simbirsoft.helper.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestBase {
    public static CredentialsConfig credentials =
            ConfigFactory.create(CredentialsConfig.class);
    @BeforeAll
    public static void helperDriver() {
        Configuration.browser = "Firefox";

        Configuration.startMaximized = true;

//        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
//
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("enableVNC", true);
//        capabilities.setCapability("enableVideo", true);

//        Configuration.browserCapabilities = capabilities;
//        Configuration.remote = format("https://%s:%s@selenoid.autotests.cloud/wd/hub/",
//                credentials.login(),
//                credentials.password());
    }

//    @AfterEach
//    public void tearDown() {
//        Attach.screenshotAs("Last screenshot");
//        Attach.pageSource();
//        Attach.browserConsoleLogs();
//        Attach.addVideo();
//    }
}
