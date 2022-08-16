import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class PhoneValidationTest extends BaseTest {

    private static final String BASE_URL = "http://localhost:9999";

    private static final String FULL_NAME = "Иванов Иван";

    @ParameterizedTest
    @CsvFileSource(resources = "phones.csv", numLinesToSkip = 1, emptyValue = "")
    void stetNegativePhoneInput(String phone) {
        ApplicationForADebitCardPage page = new ApplicationForADebitCardPage();
        SuccessPage successPage = new SuccessPage();
        Selenide.open(BASE_URL);
        page.sendKeysOfString(page.getNameInput(), FULL_NAME);
        page.sendKeysOfString(page.getPhoneInput(), phone);
        page.getCheckBox().click();
        page.getButton().click();

        boolean expected = false;
        boolean actual = successPage.getSuccessMsg().exists();

        Assertions.assertEquals(expected, actual);

    }
}
