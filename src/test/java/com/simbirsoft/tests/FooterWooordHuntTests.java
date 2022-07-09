package com.simbirsoft.tests;

import com.simbirsoft.page.FooterWooordhunt;
import com.simbirsoft.data.TestData;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceLock;

import static com.codeborne.selenide.Selenide.open;

public class FooterWooordHuntTests extends TestBase {
    FooterWooordhunt page = new FooterWooordhunt();
    TestData pageData = new TestData();

    @ResourceLock("SelenideConfig")
    @Epic("Авторизованный пользователь")
    @Feature("Справка")
    @Story("Справка на сайте")
    @Owner("SimplePerson")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Справка на сайте")
    @Description("Справка на сайте, после авторизации")
    @Tag("properties")
    @Test
    public void checkingTheHelpPageOnTheMainPage() {
        open(pageData.urlSite);
        page.clickOnPersonalAccount();
        page.clickOnLogInToTheSite();
        page.insertTextInEmail(pageData.login);
        page.insertTextInPassword(pageData.password);
        page.clickOnCheckboxRememberMe();
        page.clickOnButtonEnter();
        page.clickOnTheSupport();

        page.assertTextOneBlockTheSupportPage();

        page.clickOnPersonalAccount();
        page.clickOnLogout();
        page.clickOnLogoutButton();
    }
}
