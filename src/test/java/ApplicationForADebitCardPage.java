import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class ApplicationForADebitCardPage extends BaseTest{

    private  final SelenideElement nameInput = $x("//*[@data-test-id ='name']//input");
    private  final SelenideElement phoneInput =$x("//*[@data-test-id ='phone']//input");
    private  final SelenideElement checkBox = $x("//span[@class = 'checkbox__text']");
    private final SelenideElement button = $x("//button");

    public SelenideElement getButton() {
        return button;
    }

    public SelenideElement getNameInput() {
        return nameInput;
    }

    public SelenideElement getPhoneInput() {
        return phoneInput;
    }

    public SelenideElement getCheckBox() {
        return checkBox;
    }

    public void sendKeysOfString(SelenideElement element, String str){
        element.sendKeys(str);
    }
}
