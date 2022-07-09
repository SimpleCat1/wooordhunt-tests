package com.simbirsoft.page;

import com.codeborne.selenide.SelenideElement;
import com.simbirsoft.data.TestHeaderWooordHunt;

import static com.codeborne.selenide.Selenide.$;

public class HeaderWooordhunt extends AuthorizationWooordhunt {
    TestHeaderWooordHunt TestHeaderWooordHunt = new TestHeaderWooordHunt();

    private SelenideElement exercisesTab = $("#menu_box a[href='/page/view/ex']");
    private SelenideElement differentTab = $("#menu_box a[href='/page/view/extensions']");
    private SelenideElement headingExercisesTab = $(".help_page h1");
    private SelenideElement headingDifferentTab = $(".help_page h1");

    public void clickOnExercisesTab() {
        clickOnElement(exercisesTab);
    }

    public void clickOnDifferentTab() {
        clickOnElement(differentTab);
    }

    public void assertTextInExercisesTab() {
        checkText(headingExercisesTab, TestHeaderWooordHunt.textInHeadingExercisesTab);
    }

    public void assertTextInDifferentTab() {
        checkText(headingDifferentTab, TestHeaderWooordHunt.textInHeadingDifferentTab);
    }
}
