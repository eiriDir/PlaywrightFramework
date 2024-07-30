import org.example.utils.FileReaderJSON;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.example.enums.ErrorMessages.PRODUCT_ATTRIBUTES_VALIDATION_FAILED;
import static org.example.enums.TextData.BASE_URL;

public class ProductDataTest extends BaseTest {

    @Test
    public void checkProductData() {
        // arrange
        JSONObject expected = FileReaderJSON.readFile("src/test/resources/TestData/LaptopProductDataTest_expected.json");
        JSONObject actual;

        // act
        page.navigate(BASE_URL.getText());
        mainPage.clickLaptopMenuLink();
        laptopPage.clickProductLink();

        actual = laptopProductPage.createProductAttributesJsonFile();

        // assert
        Assertions.assertTrue(expected.similar(actual), PRODUCT_ATTRIBUTES_VALIDATION_FAILED.getMessage());
    }
}
