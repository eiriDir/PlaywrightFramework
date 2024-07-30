package org.example.steps;

public class LoginSteps extends BaseSteps {
    public LoginSteps() {
    }

    public void loginBySteps(String email, String password) {
        mainPage.clickLoginLink();

        loginPage.inputEmailField(email);
        loginPage.inputPassField(password);
        loginPage.clickSubmitBtn();
    }
}
