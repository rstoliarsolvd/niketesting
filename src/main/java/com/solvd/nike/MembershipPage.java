package com.solvd.nike;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MembershipPage {
    WebDriver driver;

    @FindBy(css = "a[data-analytics-action-id='48330161-cc1b-4cd5-a6b5-a2a3c0f6c6ef']")
    private WebElement joinUsButton;

    public MembershipPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
        this.driver.get("https://www.nike.com/ca/membership");
    }

    public WebElement getJoinUsButton() {
        return joinUsButton;
    }
}
