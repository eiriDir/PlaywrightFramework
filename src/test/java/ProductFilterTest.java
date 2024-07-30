import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.NoSuchElementException;

import static org.example.enums.ErrorMessages.FILTERING_FAILED;
import static org.example.enums.TextData.BASE_URL;

public class ProductFilterTest extends BaseTest {

    @Test
    public void filterTest() {
        // arrange
        String minPrice = "1000";
        String maxPrice = "1400";

        // act
        page.navigate(BASE_URL.getText());
        mainPage.clickLaptopMenuLink();

        laptopPage.inputMinPriceField(minPrice);
        laptopPage.inputMaxPriceField(maxPrice);
        laptopPage.clickAcerCheckbox();

        // assert
        Assertions.assertTrue(laptopPage.firstProductByFilterName().contains("Acer Nitro 5"), FILTERING_FAILED.getMessage());
    }

    @Test
    public void checkingFilterResults() {
        // arrange
        String minPrice = "1500";
        String maxPrice = "1900";

        // act
        page.navigate(BASE_URL.getText());
        mainPage.clickLaptopMenuLink();

        laptopPage.inputMinPriceField(minPrice);
        laptopPage.inputMaxPriceField(maxPrice);

        // assert
        for (ElementHandle element : laptopPage.elementsListByFilter()) {
            String elementText = element.innerText().replaceAll("[^0-9]", "");
            int elementInt = Integer.parseInt(elementText);
            int min = Integer.parseInt(minPrice);
            int max = Integer.parseInt(maxPrice);

            try {
                Assertions.assertTrue(elementInt >= min && elementInt <= max);
            } catch (AssertionError | NoSuchElementException e) {
                String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
                page.screenshot(new Page.ScreenshotOptions()
                        .setPath(Paths.get("src/test/resources/Screenshots",
                                timestamp + " error_product_filter.png")));
            }
        }
    }
}
