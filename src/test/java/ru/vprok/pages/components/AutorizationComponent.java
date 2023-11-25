package ru.vprok.pages.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class AutorizationComponent {

    SelenideElement
            phoneInput = $("div[class^='LoginForm'] input[class^='Input_input']"),
            getCodeButton = $(byText("Получить код")),
            codeInput = $("input[type='tel']"),
            pincodeErrorMessage = $("div[class^='PincodeInput_error']");


    public void enterPhone(String phone) {
        phoneInput.setValue(phone);
    }

    public void submit() {
        getCodeButton.click();
    }

    public void enterCode(String code) {
        codeInput.sendKeys(code);
    }

    public void checkErrorMessage() {
        pincodeErrorMessage.shouldHave(Condition.text("Неправильный код"));

    }

}
