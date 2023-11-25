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
            emptyBasketLogo = $("img[src='https://cdn.vprok.ru/ssr/fbae2b110d610492fa8ec6d770fb2dc7c16766f6/_nextPublic/illustrations/empty-basket.svg']"),
            emptyBasketTitle = $("h1[class*='UiErrorUnknownBase_title']"),
            emptyBacketCatalogButton = $("div[class*='UiErrorUnknownBase_button']");

    private final ElementsCollection cartItems = $$("div[data-testid='product-item']");

    public void checkEmptyBasket() {
        emptyBasketLogo.shouldBe(visible);
        emptyBasketTitle.shouldHave(text("В корзине еще нет товаров"));
        emptyBacketCatalogButton.shouldHave(text("Перейти в каталог"));
    }

    public void checkProductInCart(ProductCard productCard) {
        cartProduct.setBaseSelector(cartItems.findBy(text(productCard.getTitle())));
        assertThat(cartProduct.getTitle()).isEqualTo(productCard.getTitle());
        assertThat(cartProduct.getPrice()).isEqualTo(productCard.getPrice());
    }
}
