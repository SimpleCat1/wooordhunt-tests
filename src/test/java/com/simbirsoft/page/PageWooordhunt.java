package com.simbirsoft.page;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;

public class PageWooordhunt {
    @Step("Ввести текст: {value}. Элемент: {locator}")
    public void insertTextInArea(SelenideElement locator, String value) {
        locator.setValue(value);
    }

    @Step("Нажать на элемент: {locator}")
    public void clickOnElement(SelenideElement locator) {
        locator.click();
    }

    @Step("Проверка наличия текста: {text}. Элемента: {locator}")
    public void checkText(SelenideElement locator, String text) {
        assertText(locator, text);
    }

    private void assertText(SelenideElement locator, String text) {
        locator.shouldHave(text(text));
    }
}
