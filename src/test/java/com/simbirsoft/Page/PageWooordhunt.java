package com.simbirsoft.Page;

import com.codeborne.selenide.SelenideElement;
import com.simbirsoft.data.TestData;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

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
    private SelenideElement subjectSelection = $("#react-select-2-option-0");
    private SelenideElement hobbiesCheckbox = $("label.custom-control-label[for='hobbies-checkbox-1']");
    private SelenideElement downloadScreen = $("#uploadPicture");
    private SelenideElement currentAddress = $("#currentAddress");
    private SelenideElement selectState = $("#state");
    private SelenideElement selectStateAfterClick = $("#react-select-3-option-1");
    private SelenideElement selectCity = $("#city");
    private SelenideElement selectCityAfterClick = $("#react-select-4-option-1");
    private SelenideElement buttonSubmit = $("#submit");
    private SelenideElement firstNameTitle = $("tr:nth-child(1) td:nth-child(2)");
    private SelenideElement emailTitle = $("tr:nth-child(2) td:nth-child(2)");
    private SelenideElement genderRadioTitle = $("tr:nth-child(3) td:nth-child(2)");
    private SelenideElement mobileNumberTitle = $("tr:nth-child(4) td:nth-child(2)");
    private SelenideElement dateOfBirthTitle = $("tr:nth-child(5) td:nth-child(2)");
    private SelenideElement subjectTitle = $("tr:nth-child(6) td:nth-child(2)");
    private SelenideElement HobbiesTitle = $("tr:nth-child(7) td:nth-child(2)");
    private SelenideElement downloadScreenTitle = $("tr:nth-child(8) td:nth-child(2)");
    private SelenideElement currentAddressTitle = $("tr:nth-child(9) td:nth-child(2)");
    private SelenideElement selectStateAndCityTitle = $("tr:nth-child(10) td:nth-child(2)");

    private void insertTextInArea(SelenideElement locator, String value) {
        locator.setValue(value);
    }

    private void scrollToElement(SelenideElement locator) {
        locator.scrollTo();
    }
    private void scrollToLocatorAndClick(SelenideElement locator) {
        locator.scrollTo().click();
    }

    public void insertTextInEmail(String value) {
        insertTextInArea(inputEmail, value);
    }

    public void insertTextInPassword(String value) {
        insertTextInArea(inputPassword, value);
    }

    public void clickOnCheckboxRememberMe() {
        checkboxRememberMe.click();
    }
    public void clickOnPersonalAccount() {
        personalAccount.click();
    }
    public void clickOnLogInToTheSite() {
        logInToTheSite.click();
    }
    public void clickOnButtonEnter() {
        buttonEnter.click();
    }

    private void assertText(SelenideElement locator, String text) {
        locator.shouldHave(text(text));
    }
    public void assertTextOneBlockAfterAuthorization(){
        assertText(textAreaOneAfterAuthorization, testData.textAreaOneAuthorization);
    }
    public void assertTextTwoBlockAfterAuthorization(){
        assertText(textAreaTwoAfterAuthorization, testData.textAreaTwoAuthorization);
    }



//    public void insertTextInLastNameArea(String value) {
//        lastName.setValue(value);
//    }
//
//    public void insertTextInEmailArea(String value) {
//        email.setValue(value);
//    }
//
//    public void clickGenderRadio() {
//        genderRadio.click();
//    }
//
//    public void clickSubjectSelection() {
//        subjectSelection.click();
//    }
//
//    public void clickHobbiesCheckbox() {
//        hobbiesCheckbox.click();
//    }
//
//    public void clickCity() {
//        selectState.scrollTo().click();
//        $(selectStateAfterClick).click();
//        $(selectCity).click();
//        $(selectCityAfterClick).click();
//    }
//
//    public void clickButton() {
//        buttonSubmit.scrollTo().click();
//    }
//
//    public void checkInfo(String firstNameText, String lastNameText, String emailText,
//                          String gender, String mobileNumberText, String birthday, String subjectSelectionText,
//                          String hobie, String fileNameGif, String currentAddressText, String state, String city) {
//        firstNameTitle.shouldHave(text(firstNameText + " " + lastNameText));
//        emailTitle.shouldHave(text(emailText));
//        genderRadioTitle.shouldHave(text(gender));
//        mobileNumberTitle.shouldHave(text(mobileNumberText));
//        dateOfBirthTitle.shouldHave(text(birthday));
//        subjectTitle.shouldHave(text(subjectSelectionText));
//        HobbiesTitle.shouldHave(text(hobie));
//        downloadScreenTitle.shouldHave(text(fileNameGif));
//        currentAddressTitle.shouldHave(text(currentAddressText));
//        selectStateAndCityTitle.shouldHave(text(state + " " + city));
//
//    }
//
//    public void insertTextInMobileNumberArea(String value) {
//        mobileNumber.setValue(value);
//    }
//
//    public void insertTextInSubjectArea(String value) {
//        subject.setValue(value);
//    }
//
//
//    public void insertTextInCurrentAddressArea(String value) {
//        currentAddress.setValue(value);
//    }
//
//    public void uploadPicture(String filePathGif) {
//        downloadScreen.
//                uploadFile(new File(getClass()
//                        .getClassLoader()
//                        .getResource(filePathGif)
//                        .getFile()));
//    }
}
