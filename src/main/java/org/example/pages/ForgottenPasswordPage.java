package org.example.pages;

public class ForgottenPasswordPage extends BasePage {
    private final String locEmailInput = "//input[@type='email']";
    private final String locSubmitBtn = "//button[text()='Continue']";
    private final String locNewPasswordSuccessImg = "//img[@title='Success']";

    public ForgottenPasswordPage() {
    }

    public void clickSubmitBtn() {
        page.locator(locSubmitBtn).click();
    }

    public void inputEmailField(String email) {
        page.locator(locEmailInput).fill(email);
    }

    public boolean isNewPasswordIsSend() {
        return page.locator(locNewPasswordSuccessImg).isVisible();
    }
}
