package com.solvd.nike;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage {
    WebDriver driver;

    @FindBy(css = "#VisualSearchInput")
    private WebElement searchField;

    @FindBy(css = ".pre-search-input-icon")
    private WebElement searchButtom;

    @FindBy(css = "a[aria-label='Nike Homepage']")
    private WebElement homeButton;

    @FindBy(css = "a[data-path='sign up for email']")
    private WebElement signUpForEmailBar;

    @FindBy(css = "a[aria-label='Men']")
    private WebElement menuMenButton;

    @FindBy(css = "input[placeholder='Email address']")
    private WebElement emailAddressField;

    @FindBy(css = "input[placeholder='Date of Birth']")
    private WebElement dobField;

    @FindBy(css = "select[name='shoppingGenderDropdown']")
    private WebElement selectGenderSelect;

    @FindBy(css = "input[value='SIGN UP']")
    private WebElement signUpButton;

    @FindBy(css = "div.pre-modal-window.is-active")
    private WebElement outWindowArea;


    public HomePage(WebDriver driver) {
//        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.driver.get("https://www.nike.com/");
    }

    public WebElement getSearchField() {
        return searchField;
    }

    public WebElement getHomeButton() {
        return homeButton;
    }

    public WebElement getSignUpForEmailBar() {
        return signUpForEmailBar;
    }

    public WebElement getSearchButtom() {
        return searchButtom;
    }

    public WebElement getMenuMenButton() {
        return menuMenButton;
    }
    public WebElement getEmailAddressField() {
        return emailAddressField;
    }

    public WebElement getDobField() {
        return dobField;
    }

    public WebElement getSelectGenderSelect() {
        return selectGenderSelect;
    }

    public WebElement getSignUpButton() {
        return signUpButton;
    }

    public WebElement getOutWindowArea() {
        return outWindowArea;
    }
}
