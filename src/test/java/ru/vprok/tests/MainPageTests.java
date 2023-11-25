package ru.vprok.tests;

import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import ru.vprok.pages.CatalogEntries;

public class MainPageTests extends TestBase {


    @Test
    @DisplayName("Проверка содержимого строки навигации")
    void headerLineContentsTest() {
        mainPage
                .openPage()
                .checkHeaderLineContents();
    }

    @CsvSource(delimiter = '|', value = {
            "улица Новаторов, 6          | 54",
            "Ломоносовский проспект, 23  | 135",
            "Высокая улица, 5к2          | 85"}
    )
    @DisplayName("Проверка отображения введенного адреса на кнопке")
    @Description("Проверка отображения введенного адреса на кнопке")
    @ParameterizedTest(name = "Адрес: {0}, кв. {1}")
    public void addressButtonShouldShowBeginningOfAddressTest(String address, String flat) {
        mainPage
                .openPage()
                .setAddress(address, flat)
                .checkAddressOnMainPage(address);
    }

    @EnumSource(CatalogEntries.class)
    @DisplayName("Проверка отображения разделов каталога")
    @Description("Проверка отображения разделов каталога")
    @ParameterizedTest(name = "Раздел \"{0}\"")
    public void catalogShouldHaveEntryTest(CatalogEntries catalogEntry) {
        mainPage
                .openPage()
                .checkCatalogEntries(catalogEntry);
    }


    @Test
    public void autorizationWithWrongCode() {
        mainPage
                .openPage()
                .authorizeWithWrongCode();
    }
}
