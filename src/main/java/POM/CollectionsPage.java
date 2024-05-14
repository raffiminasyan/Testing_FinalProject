package POM;

import POM.base.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

import static Locators.CollectionsLocators.*;


public class CollectionsPage extends BasePage {
    public CollectionsPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getFirstProduct() {
        return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(PRODUCT));
    }

    public ProductPage goToProductPage() {
        getFirstProduct().click();
        return new ProductPage(driver);
    }

    public WebElement getFirstProductPrice() {
        return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(PRODUCT_PRICE));
    }

    public List<WebElement> getAllProducts() {
        return webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(PRODUCT));
    }

    public List<WebElement> getAllProductPrices() {
        return webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(PRODUCT_PRICE));
    }

    public List<Float> getAllProductPricesIntegers() {
        List<WebElement> prices = getAllProductPrices();
        List<Float> pricesFloat = new ArrayList<Float>();
        for (int i = 0; i < prices.size(); i++) {
            String cleanPrice = prices.get(i).getText().replace("$", "");
            pricesFloat.add(Float.parseFloat(cleanPrice));
        }
        return pricesFloat;
    }

    public void openPriceFilterTab() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(PRICE_FILTER_TAB)).click();
    }

    public WebElement getPriceSlider() {
        openPriceFilterTab();
        return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(PRICE_SLIDER));
    }

    public void moveSliderToRight(int units) {
        WebElement slider = getPriceSlider();
        for (int i = 1; i <= units; i++) {
            slider.sendKeys(Keys.ARROW_RIGHT);
        }
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(MINIMUM_PRICE));
    }

    public void moveSliderToLeft(int units) {
        WebElement slider = getPriceSlider();
        for (int i = 1; i <= units; i++) {
            slider.sendKeys(Keys.ARROW_RIGHT);
        }
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(MINIMUM_PRICE));
    }

    public String getMinimumPrice() {
        return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(MINIMUM_PRICE)).getText();
    }

    public WebElement getCartIcon() {
        return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(CART_ICON));
    }

    public void openCartSidebar() {
        getCartIcon().click();
    }

    public String getEmptyCartMessage() {
        return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(EMPTY_CART_MESSAGE)).getText();
    }

    public WebElement closeSidebarIcon() {
        return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(CLOSE_CART_BUTTON));
    }

    public void closeCartSidebar() {
        closeSidebarIcon().click();
        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(CLOSE_CART_BUTTON));
    }

    public WebElement getPriceSortButton() {
        return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(PRICE_SORT_BUTTON));
    }

    public void sortHighToLow() {
        getPriceSortButton().click();
        webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(HIGH_TO_LOW_ARROW));
    }


    public void sortLowToHigh() {
        getPriceSortButton().click();
        webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(LOW_TO_HIGH_ARROW));
    }

    public boolean isPriceIncreasing(List<Float> list) {
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) <= list.get(i - 1)) {
                return false;
            }
        }
        return true;
    }





}
