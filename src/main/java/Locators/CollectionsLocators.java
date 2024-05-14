package Locators;

import org.openqa.selenium.By;

public class CollectionsLocators {
    public static final By PRICE_FILTER_TAB = By.xpath("//body/div[@id='__next']/main[1]/section[1]/div[1]/aside[1]/div[3]/div[1]/button[1]");
    public static final By PRICE_SLIDER = By.xpath("//body/div[@id='__next']/main[1]/section[1]/div[1]/aside[1]/div[3]/div[1]/div[1]/div[1]/div[3]");
    public static final By PRODUCT = By.cssSelector(".relative.shadow-bbx-xl");
    public static final By PRODUCT_PRICE = By.xpath("//body/div[@id='__next']/main[1]/section[1]/div[1]/section[1]/div[2]/div[1]/a[1]/span[2]");
    public static final By CART_ICON = By.xpath("//header/nav[2]/div[1]/div[3]/button[2]");
    public static final By CLOSE_CART_BUTTON = By.xpath("//header/button[1]");
    public static final By MINIMUM_PRICE = By.className("text-xs");
    public static final By EMPTY_CART_MESSAGE = By.cssSelector(".text-sm.font-medium.text-bbx-gray12");
    public static final By PRICE_SORT_BUTTON = By.xpath("//body/div[@id='__next']/main[1]/section[1]/div[1]/section[1]/div[1]/div[1]/div[1]/button[1]");
    public static final By HIGH_TO_LOW_ARROW = By.cssSelector(".ml-2.fa-fw.fa-regular.fa-arrow-up-wide-short.text-bbx-spark");
    public static final By LOW_TO_HIGH_ARROW = By.cssSelector(".ml-2.fa-fw.fa-regular.fa-arrow-down-short-wide.text-bbx-spark");

}
