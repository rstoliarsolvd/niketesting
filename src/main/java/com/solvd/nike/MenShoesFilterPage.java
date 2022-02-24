package com.solvd.nike;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.stream.Collectors;

public class MenShoesFilterPage {

    private static final String PAGEURL = "https://www.nike.com/ca/w/mens-shoes-nik1zy7ok";
    private static final Logger LOGGER = LogManager.getLogger(MenShoesFilterPage.class);
    WebDriver driver;

    @FindBy(xpath = "//button[@aria-label='Filter for $0 - $74']")
    private WebElement shopByPriceCheckBox;

    @FindBy(css = ".product-price.css-11s12ax.is--current-price")
    private List<WebElement> shoesChooseUnder75;

    @FindBy(css = "h1.wall-header__title.css-hrsjq4.css-7m6ucd.css-yj4gxb")
    private WebElement menAllShoesPageTitle;


    public MenShoesFilterPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.driver.get(PAGEURL);
    }

    public boolean conformationAllShoesMenPage() {
        return menAllShoesPageTitle.isDisplayed();
    }

    public void clickShopByPriceCheckBox() {

        Actions builder = new Actions(driver);
        builder.moveToElement(shopByPriceCheckBox).build().perform();

        new WebDriverWait(driver, 50)
                .until(ExpectedConditions.elementToBeClickable(shopByPriceCheckBox)).click();
    }

    public WebElement getShopByPriceCheckBox() {
        return shopByPriceCheckBox;
    }

    public List<WebElement> getShoesChooseUnder75() {
        return shoesChooseUnder75;
    }


    public List<Integer> getShoesPrices() {

        List<Integer> prices = shoesChooseUnder75.stream()
                .map(WebElement::getText)
                .map(price -> price.replaceAll("\\D", ""))
                .map(price -> Integer.parseInt(price))
                .collect(Collectors.toList());
        return prices;
    }

}
