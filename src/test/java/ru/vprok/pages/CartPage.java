package ru.vprok.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import ru.vprok.pages.components.CartProductCard;
import ru.vprok.pages.components.ProductCard;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.assertj.core.api.Assertions.assertThat;

public class CartPage {

    CartProductCard cartProduct = new CartProductCard();

    private final SelenideElement
            emptyBasketLogo = $("img[src*='empty-basket.svg']"),
            emptyBasketTitle = $("h1[class*='UiErrorUnknownBase_title']"),
            emptyBasketCatalogButton = $("div[class*='UiErrorUnknownBase_button']");

    private final ElementsCollection cartItems = $$("div[data-testid='product-item']");

    public void checkEmptyBasket() {
        emptyBasketLogo.shouldBe(visible);
        emptyBasketTitle.shouldHave(text("В корзине еще нет товаров"));
        emptyBasketCatalogButton.shouldHave(text("Перейти в каталог"));
    }

    public CartPage checkProductInCart(ProductCard productCard) {
        cartProduct.setBaseSelector(cartItems.findBy(text(productCard.getTitle())));
        assertThat(cartProduct.getTitle()).isEqualTo(productCard.getTitle());
        assertThat(cartProduct.getPrice()).isEqualTo(productCard.getPrice());

        return this;
    }

    public CartPage deleteProductFromCart(ProductCard productCard) {
        cartProduct.setBaseSelector(cartItems.findBy(text(productCard.getTitle())));
        cartProduct.getElement().hover();
        cartProduct.deleteFromCart();

        return this;
    }

    public CartPage closePopUp() {
        $("button[class*='CrossModal_cross']").click();

        return this;
    }
}
