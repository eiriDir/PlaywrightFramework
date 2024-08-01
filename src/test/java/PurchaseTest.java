import com.microsoft.playwright.Locator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.example.enums.ErrorMessages.CHECKOUT_FAILED;
import static org.example.enums.ErrorMessages.ELEMENTS_IS_NOT_DISPLAYED;
import static org.example.enums.TextData.*;

public class PurchaseTest extends BaseTest {

    @Test
    public void purchaseTest() {
        // arrange
        String phoneNumber = "0936666666";
        String city = "Kharkiv";
        String checkoutIsSuccess = "Ваше замовлення успішно оформлено!";

        // act
        page.navigate(BASE_URL.getText());
        loginSteps.loginBySteps(EMAIL.getText(), PASSWORD.getText());

        mainPage.switchLanguageToUK();
        mainPage.switchCurrencyToUAH();
        mainPage.clickAppliancesLink();

        appliancesPage.clickProductLink();

        appliancesProductPage.inputProductQuantityField("2");
        appliancesProductPage.clickProductBuyBtn();

        cartPage.clickCheckoutBtn();

        checkoutFormPage.inputPhoneNumberField(phoneNumber);
        checkoutFormPage.inputCityField(city);
        checkoutFormPage.clickNewsletterCheckbox_enabledByDefault();
        checkoutFormPage.clickNewsletterCheckbox_enabledByDefault();
        checkoutFormPage.clickCheckoutBtn();

        // assert
        Assertions.assertEquals(checkoutIsSuccess, page.title(), CHECKOUT_FAILED.getMessage());
    }

    @Test
    public void checkPageElements() {
        // act
        page.navigate(BASE_URL.getText());
        loginSteps.loginBySteps(EMAIL.getText(), PASSWORD.getText());

        mainPage.switchLanguageToUK();
        mainPage.switchCurrencyToUAH();
        mainPage.clickAppliancesLink();

        appliancesPage.clickProductLink();

        appliancesProductPage.inputProductQuantityField("2");
        appliancesProductPage.clickProductBuyBtn();

        // assert
        for (Locator elements : cartPage.elementsList()) {
            Assertions.assertTrue(elements.isVisible(), ELEMENTS_IS_NOT_DISPLAYED.getMessage());
        }
    }
}
