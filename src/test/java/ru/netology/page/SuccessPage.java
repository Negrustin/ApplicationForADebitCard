package ru.netology.page;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class SuccessPage {

    private final SelenideElement SuccessMsg = $x("//p[@data-test-id = 'order-success']");

    public SelenideElement getSuccessMsg() {
        return SuccessMsg;
    }
}
