package ru.vprok.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class SearchPage {

    SelenideElement searchResultsInformer = $("div[class^='SearchResultsInformer']");

    public void checkSearchResults(String searchQuery) {
        step("Проверяем сообщение в результате поиска", () -> {
            searchResultsInformer.shouldHave(Condition.matchText(String.format("(?:По запросу \"%s\" (найдено|найден) )\\d{1,}(?: (товара|товаров|товар))", searchQuery)));
        });
    }
}
