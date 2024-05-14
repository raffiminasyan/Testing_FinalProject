import POM.ProductList;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;


public class SearchTest extends BaseTest {
    /**
     * Test to verify searching for a product.
     * Verifies if the search functionality successfully returns the expected product.
     */
    @Test
    public void testFillSearch() {
        homePage = homePage.closePopup();
        homePage.clickSearchButton();
        homePage.fillSearch("Shampoo");
        wait.until(ExpectedConditions.titleContains("Shampoo"));
        String pageTitle = driver.getTitle();
        Assert.assertTrue(pageTitle.contains("Shampoo"), AssertionMessages.NO_PRODUCT_FOUND);
    }

    /**
     * Test to verify search with no results.
     * Verifies if the search functionality returns no results for an invalid search term.
     */
    @Test
    public void testFillSearchNoResult() {
        homePage = homePage.closePopup();
        homePage.clickSearchButton();
        ProductList productList = homePage.fillSearch("random");
        Assert.assertEquals(productList.getNoResultsMessage(), AssertionMessages.NO_RESULT);
    }


    /**
     * Test to verify product links after search.
     * Verifies if product links are displayed after a search is performed.
     */
    @Test
    public void testProductLinksAfterSearch() {
        homePage.closePopup();
        ProductList productList = homePage.fillSearch("Shampoo");

        List<WebElement> productLinks = productList.getAllProductLinks();

        Assert.assertNotNull(productLinks, AssertionMessages.NO_PRODUCT_FOUND);
    }
}