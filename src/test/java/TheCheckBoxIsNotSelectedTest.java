import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TheCheckBoxIsNotSelectedTest {

    private static final String BASE_URL = "http://localhost:9999";

    private static final String FULL_NAME = "Иванов Иван";
    private static final String PHONE_NUMBER = "+79012345678";

    @Test
    public void TheCheckBoxIsNotSelected() {
        ApplicationForADebitCardPage page = new ApplicationForADebitCardPage(BASE_URL);
        page.setName(FULL_NAME);
        page.setPhoneNumber(PHONE_NUMBER);

        page.clickToContinueButton();


        boolean expected = true;
        boolean actual = page.getErrorCheckbox().exists();

        Assertions.assertEquals(expected, actual);

    }
}
