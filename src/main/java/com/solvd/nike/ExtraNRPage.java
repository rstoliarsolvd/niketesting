package com.solvd.nike;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExtraNRPage {

    private static final Logger LOGGER = LogManager.getLogger(ExtraNRPage.class);
    WebDriver driver;
    String URL = "https://www.nike.com/gb/w/new-3n82y";

    @FindBy(css = "a[aria-label='Category for Accessories & Equipment']")
    private WebElement accessoriesEquipmentBar;

    public ExtraNRPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.driver.get(URL);
    }

    public void clickAccessoriesEquipmentBar(){
        new WebDriverWait(driver,50)
                .until(ExpectedConditions.elementToBeClickable(accessoriesEquipmentBar)).click();
    }
}
