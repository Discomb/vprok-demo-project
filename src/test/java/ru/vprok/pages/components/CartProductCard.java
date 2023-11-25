package ru.vprok.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CartProductCard {

    SelenideElement
            title = $("div[class^='ProductItem_rightSide'] a[class^='ProductItem_title']"),
            price = $("div[class^='ProductItem_rightSide'] div[class^='ProductItemPrice_price'] span[class^='Price_price']"),
            deleteButton = $("div[class^='ProductItem_rightSide'] button[class^='ProductItem_delete']"),
            baseSelector;

    public CartProductCard setBaseSelector(SelenideElement selector) {
        this.baseSelector = selector;

        return this;
    }

    public String getTitle() {
        return this.title.getText();
    }

    public String getPrice() {
        return this.price.getText();
    }

    public void deleteFromCart() {
        this.baseSelector.hover();
        this.deleteButton.click();
    }

    public SelenideElement getElement() {
        return this.baseSelector;
    }
}
