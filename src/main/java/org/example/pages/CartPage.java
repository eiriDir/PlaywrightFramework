package org.example.pages;

import com.microsoft.playwright.Locator;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasePage {
    private final String locCheckoutBtn = "//a[@id='checkoutButton']";
    private final String locProductPrice = "//div[@class='col-xs-3 product_price']";
    private final String locProductTotalPrice = "//div[@class='col-xs-3 product_total']";
    private final String locDeleteProductBtn = "//button[@title='Видалити із кошика']";
    private final String locDismissBtn = "//div[@class='action_btn']//button[text()='Повернутись']";

    public CartPage() {
    }

    public void clickCheckoutBtn() {
        page.locator(locCheckoutBtn).click();
    }

    public List<Locator> elementsList() {
        List<Locator> listOfElements = new ArrayList<>(4);
        listOfElements.add(page.locator(locProductPrice));
        listOfElements.add(page.locator(locProductTotalPrice));
        listOfElements.add(page.locator(locDeleteProductBtn));
        listOfElements.add(page.locator(locDismissBtn));
        return listOfElements;
    }
}
