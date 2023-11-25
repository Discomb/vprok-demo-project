package ru.vprok.tests;

import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class SearchTests extends TestBase {


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
