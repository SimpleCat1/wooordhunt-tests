package com.simbirsoft.Page;

import com.codeborne.selenide.SelenideElement;
import com.simbirsoft.data.TestData;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class PageWooordhunt {
    TestData testData = new TestData();

    private SelenideElement personalAccount = $("#profile a[href='/user/preentry']");
    private SelenideElement logInToTheSite = $("a[href='/user/login']");
    private SelenideElement inputEmail = $("#LoginForm_email");
    private SelenideElement inputPassword = $("#LoginForm_password");
    private SelenideElement checkboxRememberMe = $("#LoginForm_rememberMe");
    private SelenideElement textAreaOneAfterAuthorization = $(".notice2.n_yellow");
    private SelenideElement textAreaTwoAfterAuthorization = $(".left_border");
    private SelenideElement buttonEnter = $(".green_button");
    private SelenideElement theSupport = $("a[href='/page/view/help']");
    private SelenideElement theSupportHeader = $("h1");
    private SelenideElement searchWords = $("#hunted_word");
    private SelenideElement searchButton = $("#hunted_word_submit");
    private SelenideElement homeTab = $x("//div[@id='menu']//a[@href='/' and text()='Главная']");
    private String theSearchWord = "#word_history_box a[href='/word/%s']";
    private String listArea = "//div/span[text()='%s']";
    private SelenideElement logout = $("a[href='/user/prelogout']");
    private SelenideElement logoutButton = $(".base_button.green_button");

    private void insertTextInArea(SelenideElement locator, String value) {
        locator.setValue(value);
    }

    public void insertTextInEmail(String value) {
        insertTextInArea(inputEmail, value);
    }

    public void insertTextInPassword(String value) {
        insertTextInArea(inputPassword, value);
    }

    public void insertTextInSearch() {
        insertTextInArea(searchWords, testData.textTheSearchWord);
    }

    public void insertTwoTextInSearch() {
        for (String text : testData.textTheSearchTwoWord) {
            searchWords.click();
            insertTextInArea(searchWords, text);
            clickOnSearchButton();
        }

    }

    public void clickOnCheckboxRememberMe() {
        checkboxRememberMe.click();
    }

    public void clickOnPersonalAccount() {
        personalAccount.click();
    }

    public void clickOnLogout() {
        logout.click();
    }

    public void clickOnLogoutButton() {
        logoutButton.click();
    }

    public void clickOnLogInToTheSite() {
        logInToTheSite.click();
    }

    public void clickOnButtonEnter() {
        buttonEnter.click();
    }

    public void clickOnTheSupport() {
        theSupport.click();
    }

    public void clickOnSearchButton() {
        searchButton.click();
    }

    public void clickOnHomeTab() {
        homeTab.click();
    }

    private void assertText(SelenideElement locator, String text) {
        locator.shouldHave(text(text));
    }

    public void assertTextOneBlockAfterAuthorization() {
        assertText(textAreaOneAfterAuthorization, testData.textAreaOneAuthorization);
    }

    public void assertTextTwoBlockAfterAuthorization() {
        assertText(textAreaTwoAfterAuthorization, testData.textAreaTwoAuthorization);
    }

    public void assertTextOneBlockTheSupportPage() {
        assertText(theSupportHeader, testData.textAreaHeaderSupport);
    }

    public void assertTextInHistory() {
        assertText($(String.format(theSearchWord, testData.textTheSearchWord)), testData.textTheSearchWord);
    }

    public void assertTextsInHistory() {
        for (String text : testData.textTheSearchTwoWord) {
            assertText($(String.format(theSearchWord, text)), text);
        }
    }

    public void assertTextInFirstElementListArea() {
        assertText($x(String.format(listArea, testData.textTheSearchWord)), testData.textTheSearchWord);
    }
}
