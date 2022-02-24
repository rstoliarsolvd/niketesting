package com.solvd.nike;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HelpPage {
    private  static  final String HELPURL = "https://www.nike.com/ca/help";
    WebDriver driver;

    @FindBy(css = "a[href='/ca/help/a/refund-info-gs']")
    private WebElement quickStartQuestion;


    public HelpPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.driver.get(HELPURL);
    }

    public WebElement getQuickStartQuestion() {
        return quickStartQuestion;
    }
}
