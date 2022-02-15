//package com.solvd.nike;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//
//public class SignUpPage {
//    public WebDriver driver;
//
////@FindBy(css = "nike-unite-join-view")
//// the page itself
//
//    @FindBy(css = "input[placeholder='Email address']")
//    private WebElement emailAddressField;
//
//    @FindBy(css = "input[placeholder='Date of Birth']")
//    private WebElement dobField;
//
//    @FindBy(css = "select[name='shoppingGenderDropdown']")
//    private WebElement selectGenderSelect;
//
//    @FindBy(css = "input[value='SIGN UP']")
//    private WebElement signUpButton;
//
//    @FindBy(css = "div.pre-modal-window.is-active")
//    private WebElement outWindowArea;
//
//    public SignUpPage(WebDriver driver) {
//        PageFactory.initElements(driver, this);
//        this.driver = driver;
//        this.driver.get(driver.getCurrentUrl());
//    }
//
//    public WebElement getEmailAddressField() {
//        return emailAddressField;
//    }
//
//    public WebElement getDobField() {
//        return dobField;
//    }
//
//    public WebElement getSelectGenderSelect() {
//        return selectGenderSelect;
//    }
//
//    public WebElement getSignUpButton() {
//        return signUpButton;
//    }
//
//    public WebElement getOutWindowArea() {
//        return outWindowArea;
//    }
//}
