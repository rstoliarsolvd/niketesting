package com.solvd.nike;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoesFilterBlock {
    WebDriver driver;

    @FindBy(css = ".product-card.css-1v1uza4.css-z5nr6i.css-11ziap1.css-14d76vy.css-dpr2cn.product-grid__card ")
    private WebElement shoesShoosUnder75Element;

    @FindBy(css = ".product-price.css-11s12ax.is--current-price")
    private WebElement shoesPriceField;

    public ShoesFilterBlock(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getShoesShoosUnder75Element() {
        return shoesShoosUnder75Element;
    }

    public WebElement getShoesPriceField() {
        return shoesPriceField;
    }
}
