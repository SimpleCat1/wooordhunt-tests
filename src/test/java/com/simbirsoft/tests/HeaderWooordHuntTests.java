package com.simbirsoft.tests;

import com.simbirsoft.page.HeaderWooordhunt;
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

import static com.codeborne.selenide.Selenide.open;

public class HeaderWooordHuntTests extends TestBase {
    HeaderWooordhunt page = new HeaderWooordhunt();
    TestData pageData = new TestData();

    @Epic("Неавторизованный пользователь")
    @Feature("Вкладки на странице (Header)")
    @Story("Вкладка Упражнение")
    @Owner("SimplePerson")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Вкладка упражнение")
    @Description("Нажимаем на вкладку упражнение и проверяем заголовок")
    @Tag("properties")
    @Test
    public void checkingOnTheExerciseTabPage() {
        open(pageData.urlSite);
        page.clickOnExercisesTab();

        page.assertTextInExercisesTab();
    }

    @Epic("Неавторизованный пользователь")
    @Feature("Вкладки на странице (Header)")
    @Story("Вкладка разное")
    @Owner("SimplePerson")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Вкладка разное")
    @Description("Переходим на вкладку разное и проверяем заголовок")
    @Tag("properties")
    @Test
    public void checkingOnTheDifferentTabPage() {
        open(pageData.urlSite);
        page.clickOnDifferentTab();

        page.assertTextInDifferentTab();
    }
}
