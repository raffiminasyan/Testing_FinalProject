package Locators;

import org.openqa.selenium.By;

public class ProductPageLocator {

    public static final By ADD_TO_CART_LOCATOR = By.xpath("//body/div[@id='__next']/main[1]/section[1]/div[1]/div[2]/div[3]/div[1]/button[1]");
    public static final By PRODUCT_TITLE_ELEMENT = By.cssSelector("h1.mb-4.product.title");

    public static final By DESCRIPTION_ELEMENT = By.cssSelector("div.description-wrapper.line-clamp-4");
    public static final By PRICE_ELEMENT = By.cssSelector("p.mb-8.text-3xl");

    public static final By CART_ICON = By.xpath("//header/nav[2]/div[1]/div[3]/button[2]");
    public static final By CART_HEADER = By.xpath("//h2[contains(text(),'Your Cart')]");

    public static final By CART_COUNT = By.xpath("//header/nav[2]/div[1]/div[3]/button[2]/span[1]");

    public static final By CLOSE_CART_BUTTON = By.xpath("//header/button[1]");
    public static final By EMPTY_CART_MESSAGE = By.cssSelector(".text-sm.font-medium.text-bbx-gray12");

    public static final By DECREASE_COUNT_BUTTON = By.xpath("//button[contains(text(),'–')]");
    public static final By INCREASE_COUNT_BUTTON = By.xpath("//button[contains(text(),'+')]");

    public static final By QUANTITY = By.cssSelector(".self-center.pr-3");


}
