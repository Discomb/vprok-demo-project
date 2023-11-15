package ru.vprok.tests;

import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ru.vprok.pages.MainPage;
import ru.vprok.pages.SearchPage;

public class SearchTests extends TestBase {

    MainPage mainPage = new MainPage();
    SearchPage searchPage = new SearchPage();

    @ValueSource(
            strings = {"Хлеб", "Шоколад", "Молоко"}
    )
    @DisplayName("Проверка соответствия строки результата поиска запросу")
    @Description("Проверка соответствия строки результата поиска запросу")
    @ParameterizedTest(name = "Запрос \"{0}\"")
    public void searchResultMatchesTheQueryTest(String searchQuery) {
        mainPage.openPage()
                .search(searchQuery);

        searchPage.checkSearchResults(searchQuery);
    }

}
