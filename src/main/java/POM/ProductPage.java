package POM;

import POM.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static Locators.ProductPageLocator.*;

public class ProductPage extends BasePage {
    public ProductPage(WebDriver driver){
        super(driver);
    }

    public String name(){
        WebElement name = new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(ExpectedConditions.elementToBeClickable(PRODUCT_TITLE_ELEMENT));
        return name.getText();
    }


    public void addToCart(){
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(ADD_TO_CART_LOCATOR)).click();
    }

    public String info(){
        WebElement info = new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(ExpectedConditions.elementToBeClickable(DESCRIPTION_ELEMENT));
        return info.getText();
    }

    public void openCartSidebar() {
        WebElement icon = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(CART_ICON));
        icon.click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(CART_HEADER));
    }

    public String getCartCount() {
        return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(CART_COUNT)).getText();
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

    public void increaseCount() {
        WebElement increaseBtn = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(INCREASE_COUNT_BUTTON));
        increaseBtn.click();
    }

    public void decreaseCount() {
        WebElement decreaseCount = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(DECREASE_COUNT_BUTTON));
        decreaseCount.click();
    }

    public String getQuantityInCart() {
        return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(QUANTITY)).getText();
    }


}