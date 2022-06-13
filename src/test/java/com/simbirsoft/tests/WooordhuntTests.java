package com.simbirsoft.tests;

import com.simbirsoft.Page.PageWooordhunt;
import com.simbirsoft.data.TestData;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.simbirsoft.Page.components.CalendarComponents.useCalendar;
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
    }

}
