import POM.CollectionsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;


public class PriceFilterTest extends BaseTest {
    /**
     * Test to move the price slider to the left by 10 units.
     */
    @Test
    public void moveSlider() throws InterruptedException {
        homePage.closePopup();
        CollectionsPage collections = homePage.goToSkinCollections();
        collections.moveSliderToLeft(10);
    }

    /**
     * Test to verify product prices after applying filtering.
     * Verifies if product prices are displayed after applying a price filter.
     */
    @Test
    public void testProductPricesAfterFiltering() {
        CollectionsPage collections = homePage.goToSkinCollections();
        collections.openPriceFilterTab();
        collections.moveSliderToLeft(10);

        List<Float> pricesAfterFiltering = collections.getAllProductPricesIntegers();

        Assert.assertNotNull(pricesAfterFiltering, AssertionMessages.NO_PRODUCT_FOUND);
    }

    /**
     * Test to move the price slider to the right by 5 units.
     */
    @Test
    public void moveSliderRight() throws InterruptedException {
        homePage.closePopup();
        CollectionsPage collections = homePage.goToSkinCollections();
        collections.moveSliderToRight(5);
    }

    /**
     * Test to verify product prices after moving slider to the right.
     */
    @Test
    public void testProductPricesAfterMoveSliderRight() {
        homePage.closePopup();
        CollectionsPage collections = homePage.goToSkinCollections();

        collections.openPriceFilterTab();
        collections.moveSliderToRight(5);

        List<Float> pricesAfterMove = collections.getAllProductPricesIntegers();

        Assert.assertNotNull(pricesAfterMove, AssertionMessages.NO_PRODUCT_FOUND);
    }

    /**
     * Test to verify products are within the price range after filtering.
     */
    @Test
    public void testProductsInPriceRange() {
        CollectionsPage collections = homePage.goToSkinCollections();
        collections.openPriceFilterTab();

        collections.moveSliderToLeft(10);

        List<Float> pricesAfterFiltering = collections.getAllProductPricesIntegers();

        Assert.assertEquals(collections.getMinimumPrice(), "$10");

        for (Float price : pricesAfterFiltering) {
            Assert.assertTrue(price >= 10.00 && price <= 100.00, "Product price not within the expected range");
        }
    }


    /**
     * Test to verify products are sorted from high to low price.
     */
    @Test
    public void testHighToLow() {
        CollectionsPage collections = homePage.goToSkinCollections();
        collections.sortHighToLow();

        List<Float> sortedPrices = collections.getAllProductPricesIntegers();
        boolean isSortedCorrectly = !collections.isPriceIncreasing(sortedPrices);

        Assert.assertTrue(isSortedCorrectly, AssertionMessages.NOT_SORTED_CORRECTLY);

    }

    /**
     * Test to verify products are sorted from low to high price.
     */
    @Test
    public void testLowToHigh() {
        CollectionsPage collections = homePage.goToSkinCollections();
        collections.sortLowToHigh();

        List<Float> sortedPrices = collections.getAllProductPricesIntegers();
        boolean isSortedCorrectly = collections.isPriceIncreasing(sortedPrices);

        Assert.assertTrue(isSortedCorrectly, AssertionMessages.NOT_SORTED_CORRECTLY);
    }
}