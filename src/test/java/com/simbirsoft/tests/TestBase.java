package com.simbirsoft.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.simbirsoft.config.CredentialsConfig;
import com.simbirsoft.helper.AllureAttach;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;


public class TestBase {
    public static CredentialsConfig credentials =
            ConfigFactory.create(CredentialsConfig.class);

    @BeforeEach
    public void helperDriver() {
        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.startMaximized = true;

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        if (String.format(credentials.remote()).equals("yes")) {
            if (System.getProperty("testType").equals("remoteMy")) {
                Configuration.browserCapabilities = capabilities;
                Configuration.remote = String.format(credentials.remoteUrl());
            } else {
                Configuration.browserCapabilities = capabilities;
                Configuration.remote = String.format("https://%s:%s@selenoid.autotests.cloud/wd/hub/",
                        credentials.login1(),
                        credentials.password1());
            }
        }
    }

    @AfterEach
    public void tearDown() {
        AllureAttach.screenshotAs("Last screenshot");
        AllureAttach.pageSource();
        AllureAttach.browserConsoleLogs();
        AllureAttach.addVideo();
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
    }
}
