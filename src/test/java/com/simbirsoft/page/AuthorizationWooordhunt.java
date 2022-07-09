package com.simbirsoft.page;

import com.codeborne.selenide.SelenideElement;
import com.simbirsoft.data.TestAuthorizationWooordHunt;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class AuthorizationWooordhunt extends PageWooordhunt {
    TestAuthorizationWooordHunt TestAuthorizationWooordHunt = new TestAuthorizationWooordHunt();

    private SelenideElement personalAccount = $("#profile a[href='/user/preentry']");
    private SelenideElement logInToTheSite = $("a[href='/user/login']");
    private SelenideElement inputEmail = $("#LoginForm_email");
    private SelenideElement inputPassword = $("#LoginForm_password");
    private SelenideElement checkboxRememberMe = $("#LoginForm_rememberMe");
    private SelenideElement textAreaOneAfterAuthorization = $(".notice2.n_yellow");
    private SelenideElement textAreaTwoAfterAuthorization = $(".left_border");
    private SelenideElement buttonEnter = $(".green_button");
    private SelenideElement logout = $("a[href='/user/prelogout']");
    private SelenideElement logoutButton = $(".base_button.green_button");

    //нужно было добавить step, так как он тут вставлял секретный пароль и логин и указывал в отчете allure ,
    // а так не указывает.Ну и еще сделал его отедльно,чтобы другие элементы попадали в отчет allure
    @Step("Ввод логина в input login")
    public void insertTextInEmail(String value) {
        inputEmail.setValue(value);
    }

    @Step("Ввод пароль в input password")
    public void insertTextInPassword(String value) {
        inputPassword.setValue(value);
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

    public void assertTextOneBlockAfterAuthorization() {
        checkText(textAreaOneAfterAuthorization, TestAuthorizationWooordHunt.textAreaOneAuthorization);
    }

    public void assertTextTwoBlockAfterAuthorization() {
        checkText(textAreaTwoAfterAuthorization, TestAuthorizationWooordHunt.textAreaTwoAuthorization);
    }
}
