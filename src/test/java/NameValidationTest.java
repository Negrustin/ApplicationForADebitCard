import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;



public class NameValidationTest extends BaseTest{

    private static  final String BASE_URL = "http://localhost:9999";

    private static final String PHONE_NUMBER = "+79012345678";

    private static final String NAME_UNICODE_CYRILLIC_EXTENSION = "Алёна Сидорова";

    @ParameterizedTest
    @CsvFileSource(resources = "names.csv",numLinesToSkip = 1,emptyValue = "")

     void negativeNameValidation(String name){
        ApplicationForADebitCardPage page = new ApplicationForADebitCardPage();
        SuccessPage successPage = new SuccessPage();
        Selenide.open(BASE_URL);
        page.sendKeysOfString(page.getNameInput(), name);
        page.sendKeysOfString(page.getPhoneInput(), PHONE_NUMBER);
        page.getCheckBox().click();
        page.getButton().click();

        boolean expected = false;
        boolean actual = successPage.getSuccessMsg().exists();

        Assertions.assertEquals(expected,actual);

    }

    @Test
    void setNameUnicodeCyrillicExtension(){
        ApplicationForADebitCardPage page = new ApplicationForADebitCardPage();
        SuccessPage successPage = new SuccessPage();
        Selenide.open(BASE_URL);
        page.sendKeysOfString(page.getNameInput(),NAME_UNICODE_CYRILLIC_EXTENSION);
        page.sendKeysOfString(page.getPhoneInput(),PHONE_NUMBER);
        page.getCheckBox().click();
        page.getButton().click();

        boolean expected = true;
        boolean actual = successPage.getSuccessMsg().exists();

        Assertions.assertEquals(expected,actual);
    }

}
