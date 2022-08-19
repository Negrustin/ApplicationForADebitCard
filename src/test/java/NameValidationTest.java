import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;



public class NameValidationTest {

    private static final String BASE_URL = "http://localhost:9999";

    private static final String PHONE_NUMBER = "+79012345678";

    private static final String NAME_UNICODE_CYRILLIC_EXTENSION = "Алёна Сидорова";


    @ParameterizedTest
    @CsvFileSource(resources = "names.csv",numLinesToSkip = 1,emptyValue = "")

    void negativeNameValidation(String name, String errorMessage){
        ApplicationForADebitCardPage page = new ApplicationForADebitCardPage(BASE_URL);

        page.setName(name);
        page.setPhoneNumber(PHONE_NUMBER);
        page.clickToCheckBox();
        page.clickToContinueButton();

        boolean expected = true;
        boolean actual = page.getErrorMassageNameElement(errorMessage).exists();


        Assertions.assertEquals(expected,actual);

    }

    @Test
    void setNameUnicodeCyrillicExtension() {
        ApplicationForADebitCardPage page = new ApplicationForADebitCardPage(BASE_URL);
        SuccessPage successPage = new SuccessPage();

        page.setName(NAME_UNICODE_CYRILLIC_EXTENSION);
        page.setPhoneNumber(PHONE_NUMBER);
        page.clickToCheckBox();
        page.clickToContinueButton();

        boolean expected = true;
        boolean actual = successPage.getSuccessMsg()
                .shouldHave(Condition.text("Ваша заявка успешно отправлена"))
                .shouldBe(Condition.visible).exists();

        Assertions.assertEquals(expected, actual);
    }

}
