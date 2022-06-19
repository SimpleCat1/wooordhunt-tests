package com.simbirsoft.Page;

import com.codeborne.selenide.SelenideElement;
import com.simbirsoft.data.TestData;
import io.qameta.allure.Step;

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

    @Step("Наводит на элемент {locator} и вводим текст {value}")
    private void insertTextInArea(SelenideElement locator, String value) {
        locator.setValue(value);
    }
    @Step("Нажимаем на элемент {locator}")
    private void clickOnElement(SelenideElement locator) {
        locator.click();
    }
    @Step("Наводит на элемент {locator} и проверяем наличие текста {text}")
    public void checkText(SelenideElement locator, String text){
        assertText(locator, text);
    }
    //нужно было добавить step, так как он тут вставлял секретный пароль и логин и указывал в отчете allure ,
    // а так не указывает.Ну и еще сделал его отедльно,чтобы другие элементы попадали в отчет allure
    @Step("Логин")
    public void insertTextInEmail(String value) {
        inputEmail.setValue(value);
    }

    @Step("Пароль")
    public void insertTextInPassword(String value) {
        inputPassword.setValue(value);
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
        clickOnElement(checkboxRememberMe);
    }

    public void clickOnPersonalAccount() {
        clickOnElement(personalAccount);
    }

    public void clickOnLogout() {
        clickOnElement(logout);
    }

    public void clickOnLogoutButton() {
        clickOnElement(logoutButton);
    }

    public void clickOnLogInToTheSite() {
        clickOnElement(logInToTheSite);
    }

    public void clickOnButtonEnter() {
        clickOnElement(buttonEnter);
    }

    public void clickOnTheSupport() {
        clickOnElement(theSupport);
    }

    public void clickOnSearchButton() {
        clickOnElement(searchButton);
    }

    public void clickOnHomeTab() {
        clickOnElement(homeTab);
    }

    private void assertText(SelenideElement locator, String text) {
        locator.shouldHave(text(text));
    }
    public void assertTextOneBlockAfterAuthorization() {
        checkText(textAreaOneAfterAuthorization, testData.textAreaOneAuthorization);
    }

    public void assertTextTwoBlockAfterAuthorization() {
        checkText(textAreaTwoAfterAuthorization, testData.textAreaTwoAuthorization);
    }

    public void assertTextOneBlockTheSupportPage() {
        checkText(theSupportHeader, testData.textAreaHeaderSupport);
    }

    public void assertTextInHistory() {
        checkText($(String.format(theSearchWord, testData.textTheSearchWord)), testData.textTheSearchWord);
    }

    public void assertTextsInHistory() {
        for (String text : testData.textTheSearchTwoWord) {
            checkText($(String.format(theSearchWord, text)), text);
        }
    }

    public void assertTextInFirstElementListArea() {
        checkText($x(String.format(listArea, testData.textTheSearchWord)), testData.textTheSearchWord);
    }
}
