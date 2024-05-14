import POM.CollectionsPage;
import POM.ProductPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddToCartTest extends BaseTest {

    /**
     * Test the functionality of adding products to the cart.
     * Steps:
     * 1. Navigate to skin collections page.
     * 2. Open price filter tab and adjust slider.
     * 3. Navigate to product page and add products to cart.
     * 4. Verify the count of items in the cart.
     * 5. Open cart sidebar, increase count, and verify count.
     * 6. Close cart sidebar and verify count.
     * 7. Open cart sidebar again and remove items by decreasing count.
     * 8. Verify that the cart is empty.
     */
    @Test
    public void testAddToCartFunctionality() {
        // Steps 1-3: Navigate to skin collections page, adjust slider, and add products to cart
        CollectionsPage collections = homePage.goToSkinCollections();
        collections.openPriceFilterTab();
        collections.moveSliderToLeft(10);
        ProductPage productPage = collections.goToProductPage();
        productPage.addToCart();
        Assert.assertEquals(productPage.getCartCount(), "1");

        // Steps 4-8: Verify cart count, manipulate cart, and verify empty cart
        for (int i = 0; i < 2; i++) {
            productPage.addToCart();
        }
        Assert.assertEquals(productPage.getCartCount(), "3");
        productPage.openCartSidebar();
        productPage.increaseCount();
        Assert.assertEquals(productPage.getQuantityInCart(), "Qty: 4");
        productPage.closeCartSidebar();
        Assert.assertEquals(productPage.getCartCount(), "4");
        productPage.openCartSidebar();
        for (int i = 0; i < 4; i++) {
            productPage.decreaseCount();
        }
        Assert.assertNotNull(productPage.getEmptyCartMessage());
        Assert.assertEquals(productPage.getEmptyCartMessage(), AssertionMessages.EMPTY_CART_MESSAGE);
    }

    /**
     * Test the change of the cart icon after adding a product to the cart.
     * Steps:
     * 1. Navigate to skin collections page.
     * 2. Open price filter tab and adjust slider.
     * 3. Navigate to product page and add a product to the cart.
     * 4. Verify the count of items in the cart.
     */
    @Test
    public void testCartIconChange() {
        // Steps 1-3: Navigate to skin collections page, adjust slider, and add product to cart
        CollectionsPage collections = homePage.goToSkinCollections();
        collections.openPriceFilterTab();
        collections.moveSliderToLeft(10);
        ProductPage productPage = collections.goToProductPage();
        productPage.addToCart();

        // Step 4: Verify cart count after adding product
        Assert.assertEquals(productPage.getCartCount(), "1");
    }

    /**
     * Test if no product is added to the cart, should display empty cart message
     */
    @Test
    public void testEmptyCartMessage() {
        CollectionsPage collections = homePage.goToSkinCollections();
        ProductPage productPage = collections.goToProductPage();
        productPage.openCartSidebar();
        String emptyCartMessage = productPage.getEmptyCartMessage();
        Assert.assertEquals(emptyCartMessage, AssertionMessages.EMPTY_CART_MESSAGE);
    }
}
