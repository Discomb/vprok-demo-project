package ru.vprok.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.vprok.pages.MainPage;
import ru.vprok.pages.components.SelectLocationComponent;

public class CartTests extends TestBase {

    MainPage mainPage = new MainPage();

    @Test
    @DisplayName("Проверка добавления товара в корзину")
    void cartTest() {


        mainPage
                .openPage()
                .closeCookies()
                .setAddress("Высокая улица, 5к2 ", "187")
                .addFirstProductToCart()
                .goToCart();
//        todo доделать тест
    }


//
//    @Test
//    @DisplayName("удаление товара из корзины")
//    void firstTest() {
//    }

}
