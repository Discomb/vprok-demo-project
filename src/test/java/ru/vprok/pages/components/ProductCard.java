package ru.vprok.pages.components;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$;

public class ProductCard {

    SelenideElement
            productPurchaseButton = $("div[class^='Purchase_root'] button"),
            productTitle = $("a[class^='MainProductTile_title']"),
            productPrice = $("span[class^='Price_price']");

    WebElement baseSelector;

    public ProductCard setBaseSelector(WebElement selector) {
        this.baseSelector = selector;

        return this;
    }

    public ProductCard addToCart() {
        this.productPurchaseButton.click();

        return this;
    }

    public String getPrice() {
        return this.productPrice.getText();
    }
}
