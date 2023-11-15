package ru.vprok.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.vprok.pages.MainPage;

public class CartTests {

    MainPage mainPage = new MainPage();

    @Test
    @DisplayName("Проверка добавления товара в корзину")
    void cartTest() {
//        todo сделать тест
        mainPage
                .openPage()
                .goToCart();
    }


//
//    @Test
//    @DisplayName("удаление товара из корзины")
//    void firstTest() {
//    }

}
