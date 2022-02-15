package com.solvd.nike;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchResultPage {
public WebDriver driver;

@FindBy(css = "a[href*='run']")
//    @FindBy(css = "div.product-grid__items.css-yj4gxb.css-r6is66.css-zndamd.css-1tlbipz")
//@FindBy(css = "div.product-card__subtitle[role='link']")
private List<WebElement> runSearchResultList;

    @FindBy(css = "a[aria-label='Nike Homepage']")
    private WebElement homeButton;


    public SearchResultPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
        this.driver.get(driver.getCurrentUrl());
    }

    public List<WebElement> getRunSearchResultList() {
        return runSearchResultList;
    }

    public WebElement getHomeButton() {
        return homeButton;
    }
}
