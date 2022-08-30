package ru.netology.test;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.page.ApplicationForADebitCardPage;
import ru.netology.page.SuccessPage;


public class HappyPathTest {
    private static  final String BASE_URL = "http://localhost:9999";

    private static final String FULL_NAME = "Иванов Иван";
    private static final String PHONE_NUMBER = "+79012345678";

    @Test
    public void HappyPathTest(){
        ApplicationForADebitCardPage page = new ApplicationForADebitCardPage(BASE_URL);
        SuccessPage successPage = new SuccessPage();

        page.setName(FULL_NAME);
        page.setPhoneNumber(PHONE_NUMBER);
        page.clickToCheckBox();
        page.clickToContinueButton();

        boolean expected = true;
        boolean actual = successPage.getSuccessMsg()
                .shouldHave(Condition.text("Ваша заявка успешно отправлена"))
                .shouldBe(Condition.visible).exists();


        Assertions.assertEquals(expected,actual);

    }

}
