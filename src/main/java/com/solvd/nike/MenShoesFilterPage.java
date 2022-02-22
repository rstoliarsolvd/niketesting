package com.solvd.nike;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import static org.testng.Assert.assertTrue;

public class MenShoesFilterPage {
    WebDriver driver;

    @FindBy(css = "a[aria-label='Filter for $0 - $74'] .icon-checkmark.css-1iktvq5.is--toggled")
    private WebElement shopByPriceCheckBox;

    @FindBy(css = ".product-price.css-11s12ax.is--current-price")
    private List<WebElement> shoesChooseUnder75;

    @FindBy(css = "h1.wall-header__title.css-hrsjq4.css-7m6ucd.css-yj4gxb")
    private WebElement menAllShoesPageTitle;


    public MenShoesFilterPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.driver.get("https://www.nike.com/ca/w/mens-shoes-nik1zy7ok");
    }

    public boolean conformationAllShoesMenPage() {
//        return menAllShoesPageTitle.getText().toLowerCase(Locale.ROOT).contains("men shoes");
        return menAllShoesPageTitle.isDisplayed();
    }

    public void clickShopByPriceCheckBox() {
        new WebDriverWait(driver, 50).until(ExpectedConditions.elementToBeClickable(shopByPriceCheckBox)).click();
//        shopByPriceCheckBox.click();
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
