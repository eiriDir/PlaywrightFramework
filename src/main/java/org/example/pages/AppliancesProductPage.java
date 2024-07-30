package org.example.pages;

public class AppliancesProductPage extends BasePage {
    private final String locProductQuantityInput = "//form[@name='cart_quantity']//input[@type='number']";
    private final String locProductBuyBtn = "//div[@class='prod_buy_btns']//button[@type='submit']";
    private final String locCheckoutBtn = "//a[@id='checkoutButton']";

    public AppliancesProductPage() {
    }

    public void inputProductQuantityField(String quantity) {
        page.locator(locProductQuantityInput).clear();
        page.locator(locProductQuantityInput).fill(quantity);
    }

    public void clickProductBuyBtn() {
        page.locator(locProductBuyBtn).click();
        page.waitForSelector(locCheckoutBtn);
    }
}
