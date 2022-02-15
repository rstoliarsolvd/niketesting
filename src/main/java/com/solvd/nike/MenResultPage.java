package com.solvd.nike;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MenResultPage {
    public WebDriver driver;

    @FindBy(css = "a._1GPQ9HJJ[href*='men']")
    private List<WebElement> productMenResultList;

    public MenResultPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
        this.driver.get(driver.getCurrentUrl());
}

    public List<WebElement> getProductMenResultList() {
        return productMenResultList;
    }
}
