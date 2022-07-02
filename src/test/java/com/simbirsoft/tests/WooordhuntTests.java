package com.simbirsoft.tests;

import com.codeborne.selenide.Selenide;
import com.simbirsoft.Page.PageWooordhunt;
import com.simbirsoft.data.TestData;
import io.qameta.allure.Description;
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


public class WooordhuntTests extends TestBase {
    PageWooordhunt page = new PageWooordhunt();
    TestData pageData = new TestData();

    @ResourceLock("SelenideConfig")
    @Feature("Авторизация")
    @Story("Авторизация")
    @Owner("SimplePerson")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Авторизация на сайте")
    @Description("авторизация на сайте")
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
        page.clickOnPersonalAccount();
        page.clickOnLogout();
        page.clickOnLogoutButton();
    }

    @ResourceLock("SelenideConfig")
    @Feature("Справка")
    @Story("Справка на сайте")
    @Owner("SimplePerson")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Справка на сайте")
    @Description("Справка на сайте, после авторизации")
    @Tag("properties")
    @Test
    public void theHelpOnTheMainPageIsWorking() {
        open(pageData.urlSite);
        page.clickOnPersonalAccount();
        page.clickOnLogInToTheSite();
        page.insertTextInEmail(pageData.login);
        page.insertTextInPassword(pageData.password);
        page.clickOnCheckboxRememberMe();
        page.clickOnButtonEnter();
        page.clickOnTheSupport();
        page.assertTextOneBlockTheSupportPage();

        page.clickOnPersonalAccount();
        page.clickOnLogout();
        page.clickOnLogoutButton();
    }

    @ResourceLock("SelenideConfig")
    @Feature("Поле поиска слов")
    @Story("Релевантность поиска слов")
    @Owner("SimplePerson")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Лист слов в строке поиска")
    @Description("проверяем ,что в первую позицию попадают слова релевантного значения")
    @Tag("properties")
    @Test
    public void theWordSearchListAreaAppears() {
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

//    @ResourceLock("SelenideConfig")
//    @Feature("История слов")
//    @Story("Запоминаем слово , которые искали в строке поиска")
//    @Owner("SimplePerson")
//    @Severity(SeverityLevel.CRITICAL)
//    @DisplayName("Появляется слово в истории")
//    @Description("Появляется слово в истории")
//    @Tag("properties")
//    @Test
//    public void theWordSearchHistoryAppears() {
//        open(pageData.urlSite);
//        page.clickOnPersonalAccount();
//        page.clickOnLogInToTheSite();
//        page.insertTextInEmail(pageData.login);
//        page.insertTextInPassword(pageData.password);
//        page.clickOnCheckboxRememberMe();
//        page.clickOnButtonEnter();
//        page.insertTextInSearch();
//        page.clickOnSearchButton();
//        page.clickOnHomeTab();
//        page.assertTextInHistory();
//        page.clickOnPersonalAccount();
//        page.clickOnLogout();
//        page.clickOnLogoutButton();
//    }
//
//    @ResourceLock("SelenideConfig")
//    @Feature("История слов")
//    @Story("Запоминаем слова , которые искали в строке поиска, последовательно")
//    @Owner("SimplePerson")
//    @Severity(SeverityLevel.CRITICAL)
//    @DisplayName("Появляется слова в истории, последовательно")
//    @Description("Появляется слова в истории, последовательно")
//    @Tag("properties")
//    @Test
//    public void theWordsSearchHistoryAppears() {
//        open(pageData.urlSite);
//        page.clickOnPersonalAccount();
//        page.clickOnLogInToTheSite();
//        page.insertTextInEmail(pageData.login);
//        page.insertTextInPassword(pageData.password);
//        page.clickOnCheckboxRememberMe();
//        page.clickOnButtonEnter();
//        page.insertTwoTextInSearch();
//        page.clickOnHomeTab();
//        page.assertTextsInHistory();
//
//        page.clickOnPersonalAccount();
//        page.clickOnLogout();
//        page.clickOnLogoutButton();
//    }

    @Feature("Вкладки на странице")
    @Story("Вкладка Упаржнение работает")
    @Owner("SimplePerson")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Вкладка упражнение")
    @Description("Нажимаем на вкладку упражнение и проверяем заголовок")
    @Tag("properties")
    @Test
    public void thereAreExercisesOnThePage() {
        open(pageData.urlSite);
        page.clickOnExercisesTab();
        page.assertTextInExercisesTab();
    }

    @Feature("Вкладки на странице")
    @Story("Вкладка разное работает")
    @Owner("SimplePerson")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Вкладка разное")
    @Description("Переходим на вкладку разное и проверяем заголовок")
    @Tag("properties")
    @Test
    public void thereAreDifferentOnThePage() {
        open(pageData.urlSite);
        page.clickOnDifferentTab();
        page.assertTextInDifferentTab();
    }

}
