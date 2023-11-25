package ru.vprok.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;

public class ProductCard {

    private String title, price,
            productTitle = "a[class*='Tile_title']",
            productPrice = "span[class*='currentPrice'] span[class^='Price_price']";

    SelenideElement baseSelector;

    public ProductCard setBaseSelector(SelenideElement selector) {
        this.baseSelector = selector;

        return this;
    }

    public ProductCard addToCart() {
        this.baseSelector.$(byText("Купить")).click();
        this.setTitle();
        this.setPrice();

        return this;
    }

    private void setTitle() {
        this.title = this.baseSelector.$(productTitle).getText();
    }

    private void setPrice() {
        this.price = this.baseSelector.$(productPrice).getText();
    }

    public String getPrice() {
        return this.price;
    }

    public String getTitle() {
        return this.title;
    }
}
