package org.example.pages;

public class LoginPage extends BasePage {
    private final String locEmailInput = "//form[@name='login']//input[@type='email']";
    private final String locPasswordInput = "//form[@name='login']//input[@type='password']";
    private final String locSubmitBtn = "//form[@name='login']//button[@type='submit']";
    private final String locLoginIsSuccess = "//a[text()='Log off']";
    private final String locForgottenPasswordLink = "//a[@href='password_forgotten.php']";

    public LoginPage() {
    }

    public boolean isLoginSuccessful() {
        return page.locator((locLoginIsSuccess)).isVisible();
    }

    public void inputEmailField(String email) {
        page.locator(locEmailInput).fill(email);
    }

    public void inputPassField(String password) {
        page.locator(locPasswordInput).fill(password);
    }

    public void clickSubmitBtn() {
        page.locator(locSubmitBtn).click();
    }

    public void clickForgottenPasswordLink() {
        page.locator(locForgottenPasswordLink).click();
    }
}
