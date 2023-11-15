package ru.vprok.pages;

import com.codeborne.selenide.SelenideElement;
import ru.vprok.pages.components.SelectLocationComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class MainPage {

    SelenideElement
            headerLogo = $("a[class^='FirstHeader_logo']"),
            headerRegion = $("div[class^='FirstHeader_region']"),
            catalogBurgerButton = $("button[class^='Burger_burger']"),
            catalogElements = $("div[class^='FeatureCatalogNavigationDesktop_parents']"),
            searchInput = $("input[data-test-search-input='true']"),
            locationTile = $("div[class*='LocationTile_location']"),
            cartButton = $("div[class^='Cart_cart']"),
            headerNavigationList = $("ul[class^=Navigation_list]");

//    todo обвязка степов

    public MainPage openPage() {
        step("Открываем главную страницу", () -> {
            open("");
        });
        return this;
    }

//    todo вынести тестдату, пройтись циклом
    public void checkHeaderLineContents() {
        headerLogo.shouldBe(visible);
        headerRegion.shouldBe(visible);
        headerNavigationList.$("a[href='/promos']").shouldHave(text("Акции"));
        headerNavigationList.$("a[href='https://www.vprok.ru/promo/zootovary']").shouldHave(text("Зоотовары"));
        headerNavigationList.$("a[href='/catalog/1305/tovary-dlya-mam-i-detey']").shouldHave(text("Детские товары"));
        headerNavigationList.$("a[href='/promo/krasota-i-zdorovie']").shouldHave(text("Красота и здоровье"));
        headerNavigationList.$("a[href='https://opt.vprok.ru/']").shouldHave(text("Юрлицам и ИП"));
        headerNavigationList.$("a[href='/info/delivery']").shouldHave(text("О доставке"));
        headerNavigationList.$("a[href='/recipe']").shouldHave(text("Рецепты"));
        headerNavigationList.$("a[href='https://vprok-vacancy.ru/moscow']").shouldHave(text("Вакансии"));
        headerNavigationList.$("a[href='/info/loyalty']").shouldHave(text("Х5 Клуб"));
    }

    public void goToCart() {
        cartButton.click();
    }

    public MainPage setAddress(String address, String flat) {
        SelectLocationComponent locationComponent = new SelectLocationComponent();

        locationTile.click();
        locationComponent.setAddress(address, flat);
        return this;
    }

    public void checkAddressOnMainPage(String address) {
        locationTile.shouldHave(text(address.substring(0, 10)));
    }

    public void checkCatalogEntries(CatalogEntries catalogEntry) {
        step("Открываем каталог", () -> {
            catalogBurgerButton.click();
        });
        step("Ищем описание раздела: " + catalogEntry.description, () -> {
            catalogElements.shouldHave(text(catalogEntry.description));
        });
    }
}