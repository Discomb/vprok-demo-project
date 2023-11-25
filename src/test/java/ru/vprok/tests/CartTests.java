package ru.vprok.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CartTests extends TestBase {


    @Test
    @DisplayName("Проверка добавления товара в корзину")
    void addToCartTest() {
        mainPage
                .openPage()
                .closeCookiesIfVisible()
                .setAddress("Высокая улица, 5к2", "187")
                .addFirstProductToCart()
                .goToCart();

        cartPage.checkProductInCart(mainPage.getProduct());
    }


    @Test
    @DisplayName("удаление товара из корзины")
    void deleteFromCartTest() {
        mainPage
                .openPage()
                .closeCookiesIfVisible()
                .setAddress("Высокая улица, 5к2", "187")
                .addFirstProductToCart()
                .goToCart();

        cartPage
                .checkProductInCart(mainPage.getProduct())
                .deleteProductFromCart(mainPage.getProduct())
                .closePopUp()
                .checkEmptyBasket();
    }

}
