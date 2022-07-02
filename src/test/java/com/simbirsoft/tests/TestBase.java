package com.simbirsoft.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.simbirsoft.config.CredentialsConfig;
import com.simbirsoft.helper.Attach;
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
//        Configuration.browser = "firefox";
        Configuration.browser = System.getProperty("browser", "chrome");

        Configuration.startMaximized = true;

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());


        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);

        if (String.format(credentials.remote()).equals("yes")) {
            Configuration.browserCapabilities = capabilities;
            Configuration.remote = String.format("https://%s:%s@selenoid.autotests.cloud/wd/hub/",
                    credentials.login1(),
                    credentials.password1());
        }
    }

    @AfterEach
    public void tearDown() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
    }
}
