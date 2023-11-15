package ru.vprok.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class CartPage {

    private final SelenideElement
            emptyBasketLogo = $("img[src='https://cdn.vprok.ru/ssr/fbae2b110d610492fa8ec6d770fb2dc7c16766f6/_nextPublic/illustrations/empty-basket.svg']"),
            emptyBasketTitle = $("h1[class*='UiErrorUnknownBase_title']"),
            emptyBacketCatalogButton = $("div[class*='UiErrorUnknownBase_button']");

    public void checkEmptyBasket() {
        emptyBasketLogo.shouldBe(visible);
        emptyBasketTitle.shouldHave(text("В корзине еще нет товаров"));
        emptyBacketCatalogButton.shouldHave(text("Перейти в каталог"));
    }
}
