package org.example.pages;

public class CheckoutFormPage extends BasePage {
    private final String locPhoneNumberInput = "//input[@name='billing_telephone']";
    private final String locCityInput = "//input[@name='shipping_city']";
    private final String locNewsletterCheckbox = "//label[@for='billing_newsletter']";
    private final String locPurchaseBtn = "//span[@id='checkoutButton']";
    private final String locCheckoutIsSuccessText = "//h1[contains(text(),'успішно оформлено!')]";

    public CheckoutFormPage() {
    }

    public void inputPhoneNumberField(String phoneNumber) {
        page.locator(locPhoneNumberInput).clear();
        page.locator(locPhoneNumberInput).fill(phoneNumber);
    }

    public void inputCityField(String city) {
        page.locator(locCityInput).clear();
        page.locator(locCityInput).fill(city);
    }

    public void clickNewsletterCheckbox_enabledByDefault() {
        page.locator(locNewsletterCheckbox).click();
    }

    public void clickCheckoutBtn() {
        page.locator(locPurchaseBtn).click();
        page.waitForSelector(locCheckoutIsSuccessText);
    }
}
