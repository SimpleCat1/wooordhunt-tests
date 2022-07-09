package com.simbirsoft.page;

import com.codeborne.selenide.SelenideElement;
import com.simbirsoft.data.TestFooterWooordHunt;

import static com.codeborne.selenide.Selenide.$;

public class FooterWooordhunt extends AuthorizationWooordhunt {
    TestFooterWooordHunt TestFooterWooordHunt = new TestFooterWooordHunt();

    private SelenideElement theSupport = $("a[href='/page/view/help']");
    private SelenideElement theSupportHeader = $("h1");

    public void clickOnTheSupport() {
        clickOnElement(theSupport);
    }

    public void assertTextOneBlockTheSupportPage() {
        checkText(theSupportHeader, TestFooterWooordHunt.textAreaHeaderSupport);
    }
}
