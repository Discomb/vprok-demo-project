package ru.vprok.pages.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class SelectLocationComponent {

    private final SelenideElement
            addressInput = $("input[name='address']"),
            addressDropdown = $("ul[class*='Options_list']"),
            flatInput = $("input[name='flat']"),
            submitButton = $(byText("Сохранить адрес"));

    public void setAddress(String address, String flat) {
        addressInput.setValue(address);
        addressDropdown.shouldBe(visible, Duration.ofSeconds(60));
        addressDropdown.$$("li").findBy(Condition.text(address)).click();
        flatInput.setValue(flat);
        submitButton.click();
    }
}
