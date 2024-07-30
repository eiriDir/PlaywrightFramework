package org.example.pages;

public class MainPage extends BasePage {
    private final String locLoginLink = "//a[text()='Log into your Account']";
    private final String locLanguageBtn = "//div[@class='language_select']//button";
    private final String locLanguageUK = "//a[@hreflang='uk']";
    private final String locCurrencyBtn = "//nav[@class='currency_select']";
    private final String locCurrencyUK = "//div[@class='selectize-dropdown-content']//div[@data-value='UAH']";
    private final String locMenuAppliancesLink = "//div[@class='block_categories']//a[text()='Appliances' or text()='Побутова техніка']";
    private final String locMenuLaptopLink = "//div[@class='block_categories']//a[text()='Laptops' or text()='Ноутбуки']";

    public MainPage() {
    }

    public void clickLoginLink() {
        page.locator(locLoginLink).click();
    }

    public void switchLanguageToUK() {
        page.locator(locLanguageBtn).click();
        page.locator(locLanguageUK).click();
    }

    public void switchCurrencyToUAH() {
        page.locator(locCurrencyBtn).click();
        page.locator(locCurrencyUK).click();
    }

    public void clickAppliancesLink() {
        page.locator(locMenuAppliancesLink).click();
    }

    public void clickLaptopMenuLink() {
        page.locator(locMenuLaptopLink).click();
    }
}
