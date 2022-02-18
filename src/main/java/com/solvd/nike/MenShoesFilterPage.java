package com.solvd.nike;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MenShoesFilterPage {
    WebDriver driver;

    @FindBy(css = "button[aria-label='Filter for $0 - $74'] .pseudo-checkbox.css-1n9lta1 ")
    private WebElement shopByPriceCheckBox;

    @FindBy(css = ".product-price.css-11s12ax.is--current-price")
    private List<WebElement> shoesChooseUnder75;


    public MenShoesFilterPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.driver.get("https://www.nike.com/ca/w/mens-shoes-nik1zy7ok");
    }

    public WebElement getShopByPriceCheckBox() {
        return shopByPriceCheckBox;
    }

    public List<WebElement> getShoesChooseUnder75() {
        return shoesChooseUnder75;
    }

}
