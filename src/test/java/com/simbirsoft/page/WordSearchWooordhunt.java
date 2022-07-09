package com.simbirsoft.page;

import com.codeborne.selenide.SelenideElement;
import com.simbirsoft.data.TestWordSearchWooordHunt;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class WordSearchWooordhunt extends AuthorizationWooordhunt {
    TestWordSearchWooordHunt TestWordSearchWooordHunt = new TestWordSearchWooordHunt();

    private SelenideElement searchWords = $("#hunted_word");
    private SelenideElement searchButton = $("#hunted_word_submit");
    private SelenideElement homeTab = $x("//div[@id='menu']//a[@href='/' and text()='Главная']");
    private String theSearchWord = "#word_history_box a[href='/word/%s']";
    private String listArea = "//div/span[text()='%s']";

    public void insertTextInSearch() {
        insertTextInArea(searchWords, TestWordSearchWooordHunt.textTheSearchWord);
    }

    public void insertTwoTextInSearch() {
        for (String text : TestWordSearchWooordHunt.textTheSearchTwoWord) {
            searchWords.click();
            insertTextInArea(searchWords, text);
            clickOnSearchButton();
        }
    }

    public void clickOnSearchButton() {
        clickOnElement(searchButton);
    }

    public void clickOnHomeTab() {
        clickOnElement(homeTab);
    }

    public void assertTextInHistory() {
        checkText($(String.format(theSearchWord, TestWordSearchWooordHunt.textTheSearchWord)), TestWordSearchWooordHunt.textTheSearchWord);
    }

    public void assertTextsInHistory() {
        for (String text : TestWordSearchWooordHunt.textTheSearchTwoWord) {
            checkText($(String.format(theSearchWord, text)), text);
        }
    }

    public void assertTextInFirstElementListArea() {
        checkText($x(String.format(listArea, TestWordSearchWooordHunt.textTheSearchWord)), TestWordSearchWooordHunt.textTheSearchWord);
    }
}
