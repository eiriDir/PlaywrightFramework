import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.example.enums.ErrorMessages.NEW_PASSWORD_IS_NOT_SEND;
import static org.example.enums.TextData.BASE_URL;
import static org.example.enums.TextData.EMAIL;

public class ForgottenPasswordTest extends BaseTest {

    @Test
    public void newPasswordTest() {
        // act
        page.navigate(BASE_URL.getText());
        mainPage.clickLoginLink();
        loginPage.clickForgottenPasswordLink();

        forgottenPasswordPage.inputEmailField(EMAIL.getText());
        forgottenPasswordPage.clickSubmitBtn();

        // assert
        Assertions.assertTrue(forgottenPasswordPage.isNewPasswordIsSend(), NEW_PASSWORD_IS_NOT_SEND.getMessage());
    }
}
