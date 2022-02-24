package com.solvd.nike;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class ExtraSortPage {
    private static final Logger LOGGER = LogManager.getLogger(ExtraSortPage.class);
    private static final String SITEURL = "https://www.nike.com/gb/w/new-accessories-equipment-3n82yzawwpw";
    WebDriver driver;

    //    @FindBy(css = ".product-card.css-1v1uza4.css-z5nr6i.css-11ziap1.css-14d76vy.css-dpr2cn.product-grid__card")
    @FindBy(css = ".product-price.css-11s12ax.is--current-price")
    private List<WebElement> productPrice;

    @FindBy(css = ".dropdown__btn-text")
    private WebElement sortButton;

    @FindBy(css = "button[aria-controls='sort-options'][aria-expanded='true']")
    private WebElement sortMenuOpen;

    @FindBy(css = "[aria-label='Newest']")
    private WebElement sortMenuNewest;

    @FindBy(css = "[aria-label='Featured']")
    private WebElement sortMenuFeatured;

    @FindBy(css = "[aria-label='Price: High-Low']")
    private WebElement sortMenuPriceHLow;

    @FindBy(css = "[aria-label='Price: Low-High']")
    private WebElement sortMenuPriceLHigh;

    @FindBy(css = ".dropdown__btn-selected-text")
    private WebElement menuSelectorChosen;

    public ExtraSortPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.driver.get(SITEURL);
    }

    public List<String> getProductPrice() {
        return productPrice.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public List<Double> getPrice() {
        return getProductPrice().stream()
                .map(s -> s.replaceAll("//D^.", ""))
                .map(Double::parseDouble).collect(Collectors.toList());
    }

    public Double getFirstPrice() {
        return getPrice().get(0);
    }

    public Double getSecondPrice() {
        return getPrice().get(3);
    }

    public Double getThirdPrice() {
        return getPrice().get(6);
    }

    public Integer getProductsNumber() {
        return getPrice().size();
    }

    public void clickSortButton() {
        new WebDriverWait(driver, 50)
                .until(ExpectedConditions.elementToBeClickable(sortButton)).click();
    }

    public boolean isSortMenuOpened() {
        return sortMenuOpen.isDisplayed();
    }

    public void clickMenuFeaturedBar() {
        new WebDriverWait(driver, 50)
                .until(ExpectedConditions.elementToBeClickable(sortMenuFeatured)).click();
    }

    public void clickMenuNewestBar() {
        new WebDriverWait(driver, 50)
                .until(ExpectedConditions.elementToBeClickable(sortMenuNewest)).click();
    }

    public void clickMenuPriceHLowBar() {
        new WebDriverWait(driver, 50)
                .until(ExpectedConditions.elementToBeClickable(sortMenuPriceHLow)).click();
    }

    public void clickMenuPriceLHighBar() {
        new WebDriverWait(driver, 50)
                .until(ExpectedConditions.elementToBeClickable(sortMenuPriceLHigh)).click();
    }

    public boolean selectorNewestChosen() {
        return menuSelectorChosen.getText().toLowerCase(Locale.ROOT).contains("newest");
    }

    public boolean selectorFeatureChosen() {
        return menuSelectorChosen.getText().toLowerCase(Locale.ROOT).contains("feature");
    }

    public boolean selectorHighLowChosen() {
        return menuSelectorChosen.getText().toLowerCase(Locale.ROOT).contains("high-low");
    }

    public boolean selectorLowHighChosen() {
        return menuSelectorChosen.getText().toLowerCase(Locale.ROOT).contains("low-high");
    }

}
