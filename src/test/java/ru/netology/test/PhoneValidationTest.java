package ru.netology.test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import ru.netology.page.ApplicationForADebitCardPage;

public class PhoneValidationTest {

    private static final String BASE_URL = "http://localhost:9999";

    private static final String FULL_NAME = "Иванов Иван";

    @ParameterizedTest
    @CsvFileSource(resources = "../../../phones.csv", numLinesToSkip = 1, emptyValue = "")
    void stetNegativePhoneInput(String phone, String errorMassage) {
        ApplicationForADebitCardPage page = new ApplicationForADebitCardPage(BASE_URL);


        page.setName(FULL_NAME);
        page.setPhoneNumber(phone);
        page.clickToCheckBox();
        page.clickToContinueButton();

        page.getErrorMassagePhoneElement(errorMassage);

    }
}
