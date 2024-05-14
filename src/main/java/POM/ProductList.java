package POM;

import Locators.ProductListPageLocators;
import POM.base.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static Locators.ProductListPageLocators.PRODUCT_LINK;

public class ProductList extends BasePage {
    public ProductList(WebDriver driver) {
        super(driver);
    }

    public WebElement getSearchTitle() {
        return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(ProductListPageLocators.FIND_TITLE));
    }

    public ProductPage getProduct() {
        WebElement product = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(ProductListPageLocators.PRODUCT));
        product.click();
        return new ProductPage(driver);
    }

    public ProductList searchProduct(String search) {
        WebElement searchField = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(ProductListPageLocators.SEARCH_FIELD));
        searchField.click();
        searchField.clear();
        searchField.sendKeys(search + Keys.ENTER);
        return this;
    }

    public WebElement getProductTitle() {
        WebElement productTitle = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(ProductListPageLocators.PRODUCT_TITLE));
        return productTitle;
    }

    public String getNoResultsMessage() {
        WebElement container = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(ProductListPageLocators.NO_RESULT_CONTAINER));
        return container.getText();
    }

    public List<WebElement> getAllProductLinks() {
        return webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(PRODUCT_LINK));
    }

}