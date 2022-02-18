package com.solvd.nike;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StartPage {
    WebDriver driver;

    @FindBy(css = "a[href='https://www.nike.com/ca/']")
    private WebElement locationCanadaEnglBar;

    @FindBy(css = "#nes-localization")
    private WebElement localisationID;

    @FindBy(css = "a[data-path='sign up for email']")
    private WebElement signUpForEmailBar;

    @FindBy(css = "input[placeholder='Email address']")
    private WebElement emailAddressField;

    @FindBy(css = "input[placeholder='Date of Birth']")
    private WebElement dobField;

    @FindBy(css = "select[name='shoppingGenderDropdown']")
    private WebElement selectGenderSelect;

    @FindBy(css = "select[name='shoppingGenderDropdown'] option[value='M']")
    private WebElement menGenderSelect;

    @FindBy(css = "input[value='SIGN UP']")
    private WebElement signUpButton;

    @FindBy(css = ".nike-unite-submit-button.emailOnlyJoinSubmit.nike-unite-component input[value='SIGN UP']")
    private WebElement signUpFistWindowButton;

    @FindBy(css = ".pre-modal-btn-close.bg-transparent")
    private WebElement closeFistWindowButton;

    @FindBy(css = ".nike-unite-action-button.emailOnlyJoinInterstialButton.nike-unite-component input[value='JOIN US']")
    private WebElement signUpSecondWindowButton;

    @FindBy(css = ".nike-unite-submit-button.joinSubmit.nike-unite-component input[value='JOIN US']")
    private WebElement joinUsThirdWindowButton;

    @FindBy(css = "input[type='password']")
    private  WebElement passwordField;

    @FindBy(css = "input[placeholder='First Name']")
    private WebElement firstNameField;

    @FindBy(css = "input[placeholder='Last Name']")
    private WebElement lastNameField;

    @FindBy(css = "label.checkbox")
    private WebElement signUpCheckBox;

    @FindBy(css = ".u-full-width.u-full-height")
    private WebElement homePageMainClass;

    @FindBy(css = "div[data-view='emailOnlyJoinInterstitial'] [value='JOIN US']")
    private WebElement secondWindowJoinUsMainClass;

    @FindBy(css = "#VisualSearchInput")
    private WebElement searchField;

    @FindBy(css = ".pre-search-input-icon")
    private WebElement searchButton;

    @FindBy(css = "a[aria-label='Nike Homepage']")
    private WebElement homeButton;

    @FindBy(css = "div.no-results.css-i5a8ll.css-vae3zs.css-khhzia.css-1rni16j span[data-test='no-results-title']")
    private WebElement noResultMessage;

    @FindBy(css = ".pre-help-button.body-4.u-bold")
    private WebElement helpButton;

    @FindBy(css = "a[aria-label='Men']")
    private WebElement menuMenButton;

    @FindBy(css = "a[role='menuitem'].body-3[href='https://www.nike.com/ca/w/mens-shoes-nik1zy7ok']")
    private WebElement menuMenAllShoesBar;

    @FindBy(css = ".body-4.d-lg-flx.flx-ai-lg-c.u-bold.ml2-sm.mr2-sm")
    private  WebElement joinUpTopBar;




    public StartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.driver.get("https://www.nike.com/");
    }

    public WebElement getLocationCanadaEnglBar() {
        return locationCanadaEnglBar;
    }

    public WebElement getLocalisationID() {
        return localisationID;
    }

    public WebElement getSignUpForEmailBar() {
        return signUpForEmailBar;
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

    public WebElement getMenGenderSelect() {
        return menGenderSelect;
    }

    public WebElement getSignUpButton() {
        return signUpButton;
    }

    public WebElement getSignUpFistWindowButton() {
        return signUpFistWindowButton;
    }

    public WebElement getCloseFistWindowButton() {
        return closeFistWindowButton;
    }

    public WebElement getSignUpSecondWindowButton() {
        return signUpSecondWindowButton;
    }

    public WebElement getJoinUsThirdWindowButton() {
        return joinUsThirdWindowButton;
    }

    public WebElement getPasswordField() {
        return passwordField;
    }

    public WebElement getFirstNameField() {
        return firstNameField;
    }

    public WebElement getLastNameField() {
        return lastNameField;
    }

    public WebElement getSignUpCheckBox() {
        return signUpCheckBox;
    }

    public WebElement getSearchField() {
        return searchField;
    }

    public WebElement getSearchButton() {
        return searchButton;
    }

    public WebElement getHomeButton() {
        return homeButton;
    }

    public WebElement getNoResultMessage() {
        return noResultMessage;
    }

    public WebElement getHelpButton() {
        return helpButton;
    }

    public WebElement getMenuMenButton() {
        return menuMenButton;
    }

    public WebElement getMenuMenAllShoesBar() {
        return menuMenAllShoesBar;
    }

    public WebElement getJoinUpTopBar() {
        return joinUpTopBar;
    }
}
