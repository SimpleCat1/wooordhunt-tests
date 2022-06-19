package com.simbirsoft.tests;

import com.simbirsoft.Page.PageWooordhunt;
import com.simbirsoft.data.TestData;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.ResourceLock;

import static com.codeborne.selenide.Selenide.open;
//import static com.simbirsoft.Page.components.CalendarComponents.useCalendar;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class WooordhuntTests extends TestBase {
    PageWooordhunt page = new PageWooordhunt();
    TestData pageData = new TestData();

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
    @Tag("properties")
    @Test
    public void theHelpOnTheMainPageIsWorking() {
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
    @Tag("properties")
    @Test
    public void theWordSearchListAreaAppears() {
        open(pageData.urlSite);
        page.clickOnPersonalAccount();
        page.clickOnLogInToTheSite();
        page.insertTextInEmail(pageData.login);
        page.insertTextInPassword(pageData.password);
        page.clickOnCheckboxRememberMe();
        page.clickOnButtonEnter();
        page.insertTextInSearch();
        page.assertTextInFirstElementListArea();

        page.clickOnPersonalAccount();
        page.clickOnLogout();
        page.clickOnLogoutButton();
    }
    @ResourceLock("SelenideConfig")
    @Tag("properties")
    @Test
    public void theWordSearchHistoryAppears() {
        open(pageData.urlSite);
        page.clickOnPersonalAccount();
        page.clickOnLogInToTheSite();
        page.insertTextInEmail(pageData.login);
        page.insertTextInPassword(pageData.password);
        page.clickOnCheckboxRememberMe();
        page.clickOnButtonEnter();
        page.insertTextInSearch();
        page.clickOnSearchButton();
        page.clickOnHomeTab();
        page.assertTextInHistory();

        page.clickOnPersonalAccount();
        page.clickOnLogout();
        page.clickOnLogoutButton();
    }
    @ResourceLock("SelenideConfig")
    @Tag("properties")
    @Test
    public void theWordsSearchHistoryAppears() {
        open(pageData.urlSite);
        page.clickOnPersonalAccount();
        page.clickOnLogInToTheSite();
        page.insertTextInEmail(pageData.login);
        page.insertTextInPassword(pageData.password);
        page.clickOnCheckboxRememberMe();
        page.clickOnButtonEnter();
        page.insertTwoTextInSearch();
        page.clickOnHomeTab();
        page.assertTextsInHistory();

        page.clickOnPersonalAccount();
        page.clickOnLogout();
        page.clickOnLogoutButton();
    }

}
