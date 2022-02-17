package com.solvd.nike;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchResultPage {
    public WebDriver driver;

    @FindBy(css = "a[href*='run']")
    private List<WebElement> runSearchResultList;

    @FindBy(css = "a[aria-label='Nike Homepage']")
    private WebElement homeButton;

    @FindBy(css = "button[aria-label='Close Menu'] .g72-x-circle.fs32-nav-sm.nav-color-black")
    private WebElement closeLocatorMenuButton;


    public SearchResultPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
//        this.driver.get("https://nike.com/ca");
        this.driver.get("https://www.nike.com/ca/w?q=run&vst=run");

    }

    public List<WebElement> getRunSearchResultList() {
        return runSearchResultList;
    }

    public WebElement getHomeButton() {
        return homeButton;
    }

    public WebElement getCloseLocatorMenuButton() {
        return closeLocatorMenuButton;
    }
}
