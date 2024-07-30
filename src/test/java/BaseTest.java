import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.example.core.BrowserFactory;
import org.example.pages.*;
import org.example.steps.LoginSteps;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static org.example.core.PageInstance.pageInstance;

public abstract class BaseTest {

    protected Playwright playwright;
    protected Browser browser;
    protected Page page;

    protected MainPage mainPage;
    protected LoginPage loginPage;
    protected LoginSteps loginSteps;
    protected ForgottenPasswordPage forgottenPasswordPage;
    protected AppliancesPage appliancesPage;
    protected AppliancesProductPage appliancesProductPage;
    protected LaptopPage laptopPage;
    protected LaptopProductPage laptopProductPage;
    protected CartPage cartPage;
    protected CheckoutFormPage checkoutFormPage;

    @BeforeEach
    public void init() {
        playwright = Playwright.create();
        browser = BrowserFactory.getBrowser("chrome");
        page = browser.newPage();
        pageInstance().setPage(page);

        mainPage = new MainPage();
        loginPage = new LoginPage();
        forgottenPasswordPage = new ForgottenPasswordPage();
        appliancesPage = new AppliancesPage();
        appliancesProductPage = new AppliancesProductPage();
        laptopPage = new LaptopPage();
        laptopProductPage = new LaptopProductPage();
        cartPage = new CartPage();
        checkoutFormPage = new CheckoutFormPage();

        loginSteps = new LoginSteps();
    }

    @AfterEach
    public void teardown() {
        if (page != null) {
            browser.close();
            playwright.close();
        }
    }
}
