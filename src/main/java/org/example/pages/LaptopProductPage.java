package org.example.pages;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LaptopProductPage extends BasePage {
    private static final Logger log = LoggerFactory.getLogger(LaptopProductPage.class);

    private final String locProductLabelText = "//form[@name='cart_quantity']//h1"; //Apple MacBook Air
    private final String locProductIDTest = "//form[@name='cart_quantity']//span[@class='art_card_product']"; //78651
    private final String locProductPrice = "//form[@name='cart_quantity']//span[@class='new_price_card_product']"; //$1441.00
    private final String locDiagonalText = "//td[text()='Diagonal:']/../td[2]"; //13.3"
    private final String locProcessorText = "//td[text()='Processor:']/../td[2]"; //Intel Core i3 (1.1 - 3.2 GHz)
    private final String locScreenResolutionText = "//td[text()='Screen resolution:']/../td[2]"; //2560x1600

    public LaptopProductPage() {
    }

    public JSONObject createProductAttributesJsonFile() {
        JSONObject data = new JSONObject();
        data.put("id", page.locator(locProductIDTest).textContent());
        data.put("name", page.locator(locProductLabelText).textContent());
        data.put("price", page.locator(locProductPrice).textContent());
        data.put("diagonal", page.locator(locDiagonalText).textContent());
        data.put("processor", page.locator(locProcessorText).textContent());
        data.put("screen resolution", page.locator(locScreenResolutionText).textContent());
        log.info("Data added successfully: " + data);

        return data;
    }
}
