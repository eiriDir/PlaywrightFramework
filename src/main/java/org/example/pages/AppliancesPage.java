package org.example.pages;

public class AppliancesPage extends BasePage {
    private final String locProductLink = "//a[text()='Kenwood ZJM 810']";

    public AppliancesPage() {
    }

    public void clickProductLink() {
        page.locator(locProductLink).click();
    }
}
