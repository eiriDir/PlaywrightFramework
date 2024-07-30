package org.example.steps;

import org.example.pages.LoginPage;
import org.example.pages.MainPage;

public abstract class BaseSteps {
    protected MainPage mainPage;
    protected LoginPage loginPage;

    public BaseSteps() {
        mainPage = new MainPage();
        loginPage = new LoginPage();
    }
}
