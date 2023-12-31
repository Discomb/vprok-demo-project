package ru.vprok.tests;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import ru.vprok.config.WebDriverProvider;
import ru.vprok.helpers.Attach;
import ru.vprok.pages.CartPage;
import ru.vprok.pages.MainPage;
import ru.vprok.pages.SearchPage;

public class TestBase {

    MainPage mainPage = new MainPage();
    SearchPage searchPage = new SearchPage();
    CartPage cartPage = new CartPage();


    @BeforeAll
    static void beforeAll() {
        new WebDriverProvider().setupDriver();
    }

    @BeforeEach
    void beforeEach() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();

        Selenide.closeWebDriver();
    }

}
