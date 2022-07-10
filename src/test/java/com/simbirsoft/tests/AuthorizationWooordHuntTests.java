package com.simbirsoft.tests;

import com.simbirsoft.page.AuthorizationWooordhunt;
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

public class AuthorizationWooordHuntTests extends TestBase {
    AuthorizationWooordhunt page = new AuthorizationWooordhunt();
    TestData pageData = new TestData();

    @ResourceLock("SelenideConfig")
    @Epic("Авторизованный пользователь")
    @Feature("Авторизация")
    @Story("Авторизация")
    @Owner("SimplePerson")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Авторизация на сайте")
    @Description("Авторизация на сайте существующего пользователя")
    @Tag("properties")
    @Test
    public void authorizationOnTheWebsite() {
        open(pageData.urlSite);
        page.clickOnPersonalAccount();
        page.clickOnLogInToTheSite();
        page.insertTextInEmail(pageData.login);
        page.insertTextInPassword(pageData.password);
        page.clickOnCheckboxRememberMe();
        page.clickOnButtonEnter();

        page.assertTextOneBlockAfterAuthorization();
        page.assertTextTwoBlockAfterAuthorization();

        page.clickOnPersonalAccount();
        page.clickOnLogout();
        page.clickOnLogoutButton();
    }
}
