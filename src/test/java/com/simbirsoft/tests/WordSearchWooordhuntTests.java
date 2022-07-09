package com.simbirsoft.tests;

import com.simbirsoft.page.WordSearchWooordhunt;
import com.simbirsoft.data.TestData;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceLock;

import static com.codeborne.selenide.Selenide.open;


public class WordSearchWooordhuntTests extends TestBase {
    WordSearchWooordhunt page = new WordSearchWooordhunt();
    TestData pageData = new TestData();

    @ResourceLock("SelenideConfig")
    @Epic("Авторизованный пользователь")
    @Feature("Поле поиска слов")
    @Story("Релевантность поиска слов")
    @Owner("SimplePerson")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Лист слов в строке поиска")
    @Description("Проверяем ,что в первую позицию попадают слова релевантного значения")
    @Tag("properties")
    @Test
    public void checkingTheRelevanceOfAWordSearch() {
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
    @Epic("Авторизованный пользователь")
    @Feature("История слов")
    @Story("Запоминаем слово , которые искали в строке поиска")
    @Owner("SimplePerson")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Появляется слово в истории")
    @Description("Появляется слово в истории")
    @Tag("properties")
    @Test
    public void checkingTheWordSearchHistory() {
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
    @Epic("Авторизованный пользователь")
    @Feature("История слов")
    @Story("Запоминаем слова , которые искали в строке поиска, последовательно")
    @Owner("SimplePerson")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Появляется слова в истории, последовательно")
    @Description("Появляется слова в истории, последовательно")
    @Tag("properties")
    @Test
    public void checkingTheSequenceOfTheWordSearchHistory() {
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
