package ru.vprok.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.vprok.pages.CartPage;
import ru.vprok.pages.MainPage;

public class CartTests extends TestBase {

    MainPage mainPage = new MainPage();
    CartPage cartPage = new CartPage();


    @Test
    @DisplayName("Проверка добавления товара в корзину")
    void addToCartTest() {

        mainPage
                .openPage()
                .closeCookies()
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
                .closeCookies()
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
