package org.example.pages;

import com.microsoft.playwright.ElementHandle;

import java.util.List;

public class LaptopPage extends BasePage {
    private final String locMinPriceInput = "//div[@class='filter_box_in']//input[@id='range1']";
    private final String locMaxPriceInput = "//div[@class='filter_box_in']//input[@id='range2']";
    private final String locAcerCheckbox = "//div[@class='filter_box_in']//label[@for='brand_9']";
    private final String locInputIsDone = "//div[@class='filter_cont']";
    private final String locProductLink = "//*[text()='Apple MacBook Air']";
    private final String locFirstProductByFilterName = "//div[@id='r_spisok']//a[text()='Acer Nitro 5 Shale Black']";
    private final String locListOfElements = "//span[@class='new_price']";

    public LaptopPage() {
    }

    public void clickAcerCheckbox() {
        page.locator(locAcerCheckbox).click();
    }

    public void clickProductLink() {
        page.locator(locProductLink).click();
    }

    public void inputMinPriceField(String minPrice) {
        page.locator(locMinPriceInput).clear();
        page.locator(locMinPriceInput).fill(minPrice);
    }

    public void inputMaxPriceField(String maxPrice) {
        page.locator(locMaxPriceInput).clear();
        page.locator(locMaxPriceInput).fill(maxPrice);
        page.waitForSelector(locInputIsDone);
    }

    public List<ElementHandle> elementsListByFilter(){
       return page.querySelectorAll(locListOfElements);
    }

    public String firstProductByFilterName() {
        return page.locator(locFirstProductByFilterName).textContent();
    }
}
