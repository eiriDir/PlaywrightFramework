import org.example.models.Credentials;
import org.example.utils.FileReaderCSV;
import org.example.utils.FileReaderJSON;
import org.example.utils.ICredentialsReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.example.enums.ErrorMessages.LOGIN_FAILED;
import static org.example.enums.TextData.*;

public class LoginTest extends BaseTest {
    private static final Logger log = LoggerFactory.getLogger(LoginTest.class);

    @Test
    public void loginTest() {
        // arrange
        log.info("User email: " + EMAIL.getText());
        log.info("User password: " + PASSWORD.getText());

        // act
        page.navigate(BASE_URL.getText());
        loginSteps.loginBySteps(EMAIL.getText(), PASSWORD.getText());

        // assert
        Assertions.assertTrue(loginPage.isLoginSuccessful(), LOGIN_FAILED.getMessage());
    }

    @Test
    public void loginTest_Json() {
        // arrange
        ICredentialsReader fileReader = new FileReaderJSON();
        Credentials credentials = fileReader.readCredentials("src/test/resources/TestData/LoginTestCredentials.json");
        log.info("User email: " + credentials.getEmail());
        log.info("User password: " + credentials.getPassword());

        // act
        page.navigate(BASE_URL.getText());
        loginSteps.loginBySteps(credentials.getEmail(), credentials.getPassword());

        // assert
        Assertions.assertTrue(loginPage.isLoginSuccessful(), LOGIN_FAILED.getMessage());
    }

    @Test
    public void loginTest_Csv() {
        // arrange
        ICredentialsReader fileReader = new FileReaderCSV();
        Credentials credentials = fileReader.readCredentials("src/test/resources/TestData/LoginTestCredentials.csv");
        log.info("User email: " + credentials.getEmail());
        log.info("User password: " + credentials.getPassword());

        // act
        page.navigate(BASE_URL.getText());
        loginSteps.loginBySteps(credentials.getEmail(), credentials.getPassword());

        // assert
        Assertions.assertTrue(loginPage.isLoginSuccessful(), LOGIN_FAILED.getMessage());
    }
}
