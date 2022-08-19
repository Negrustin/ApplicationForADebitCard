import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

/**
 * Страницы заявки на дебетовую карту.
 */
public class ApplicationForADebitCardPage {

    private  final SelenideElement nameInput = $x("//*[@data-test-id ='name']//input");
    private  final SelenideElement phoneInput =$x("//*[@data-test-id ='phone']//input");
    private  final SelenideElement checkBox = $x("//span[@class = 'checkbox__text']");
    private final SelenideElement button = $x("//button");
    private final SelenideElement errorCheckbox = $x("//*[@data-test-id ='agreement' and contains(@class, 'input_invalid')]");
    public ApplicationForADebitCardPage(String url) {
        Selenide.open(url);

    }

    public SelenideElement getErrorCheckbox() {
        return errorCheckbox;
    }


    /**
     *
     *  Открытие веб сайта  @param url
     */
    public void openWebSite(String url) {
        Selenide.open(url);
    }

    /**
     *
     * Введение значения в поле имени  @param name
     */
    public void setName(String name){
        nameInput.setValue(name);
    }

    /**
     *
     * Введение значения в поле телефона   @param phone
     */
    public void setPhoneNumber(String phone){
        phoneInput.setValue(phone);
    }

    /**
     *  Выбор чекбокса.
     */
    public void clickToCheckBox(){
        checkBox.click();

    }
    /**
     * Нажатие кнопки подтверждения.
     */
    public void clickToContinueButton(){
        button.click();
    }



    /**
     * Возвращает элемент поля ввода имени в состоянии ошибки валидации с поиском по тексту ошибки.
     * @param errorMassage
     * @return
     */
    public SelenideElement getErrorMassageNameElement(String errorMassage){
        return Selenide.$x("//*[@data-test-id ='name' and contains(@class, 'input_invalid')]")
                .shouldHave(Condition.text(errorMassage));
    }

    /**
     * Возвращает элемент поля ввода телефона в состоянии ошибки валидации с поиском по тексту ошибки.
     * @param errorMassage
     * @return
     */
    public SelenideElement getErrorMassagePhoneElement(String errorMassage){
        return Selenide.$x("//*[@data-test-id ='phone']|span[contains(@class, 'invalid')]")
                .shouldHave(Condition.text(errorMassage));
    }




}
