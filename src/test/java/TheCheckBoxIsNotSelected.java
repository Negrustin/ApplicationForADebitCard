import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TheCheckBoxIsNotSelected {

    private static final String BASE_URL = "http://localhost:9999";

    private static final String FULL_NAME = "Иванов Иван";
    private static final String PHONE_NUMBER = "+79012345678";

    @Test
    public void TheCheckBoxIsNotSelected() {
        ApplicationForADebitCardPage page = new ApplicationForADebitCardPage();
        SuccessPage successPage = new SuccessPage();
        Selenide.open(BASE_URL);
        page.sendKeysOfString(page.getNameInput(), FULL_NAME);
        page.sendKeysOfString(page.getPhoneInput(), PHONE_NUMBER);

        page.getButton().click();


        boolean expected = false;
        boolean actual = successPage.getSuccessMsg().exists();

        Assertions.assertEquals(expected, actual);

    }
}
