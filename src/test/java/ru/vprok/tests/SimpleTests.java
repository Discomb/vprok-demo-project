package ru.vprok.tests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;
import ru.vprok.pages.CatalogEntries;
import ru.vprok.pages.MainPage;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class SimpleTests extends TestBase {

    MainPage mainPage = new MainPage();

    @Test
    @DisplayName("Проверка содержимого строки навигации")
    void headerLineContentsTest() {
        mainPage
                .openPage()
                .checkHeaderLineContents();
    }

    @ValueSource(
            strings = {"Хлеб", "Шоколад", "Молоко"}
    )
    @DisplayName("Проверка соответствия строки результата поиска запросу")
    @Description("Проверка соответствия строки результата поиска запросу")
    @ParameterizedTest(name = "Запрос \"{0}\"")
    public void searchResultMatchesTheQueryTest(String searchQuery) {
        step("Открываем главную страницу", () -> {
            open(baseUrl);
        });
        step("Выполняем поиск товара " + searchQuery, () -> {
            $("input[data-test-search-input='true']").setValue(searchQuery);
            $("input[data-test-search-input='true']").submit();
        });
        step("Проверяем сообщение в результате поиска", () -> {
            $("div[class^='SearchResultsInformer']").shouldHave(Condition.matchText(String.format("(?:По запросу \"%s\" (найдено|найден) )\\d{1,}(?: (товара|товаров|товар))", searchQuery)));
        });
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

    @Test
    @DisplayName("Проверка добавления товара в корзину")
    void cartTest() {
//        todo сделать тест
        mainPage
                .openPage()
                .goToCart();
    }
//
//    @Test
//    @DisplayName("удаление товара из корзины")
//    void firstTest() {
//    }



    @EnumSource(CatalogEntries.class)
    @DisplayName("Проверка отображения разделов каталога")
    @Description("Проверка отображения разделов каталога")
    @ParameterizedTest(name = "Раздел \"{0}\"")
    public void catalogShouldHaveEntryTest(CatalogEntries catalogEntry) {
        mainPage
                .openPage()
                .checkCatalogEntries(catalogEntry);
    }

    //    @Test
//    @DisplayName("Навигация вторая ллиния")
//    void firstTest() {
//    }
}
