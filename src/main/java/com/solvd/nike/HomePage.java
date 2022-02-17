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
    private WebElement searchButton;

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

    @FindBy(css = "option[value='M']")
    private WebElement menGenderSelect;

    @FindBy(css = "input[value='SIGN UP']")
    private WebElement signUpButton;

    @FindBy(css = "div.pre-modal-window.is-active")
    private WebElement outWindowArea;

    @FindBy(css = ".pre-help-button.body-4.u-bold")
    private WebElement helpButton;

    @FindBy(css = ".hf-language-menu.n815b.is-open")
    private WebElement locationWindowOpen;

    @FindBy(css = "button[aria-label='Close Menu'] .g72-x-circle.fs32-nav-sm.nav-color-black")
    private WebElement closeLocatorMenuButton;

    @FindBy(css = "nav.hf-language-menu")
    private WebElement locatorWindowClass;

    @FindBy(css = "a[href='https://www.nike.com/ca/']")
    private WebElement locationCanadaEnglBar;
//
//    @FindBy(css = "#nes-localization")
//    private WebElement localisationID;


    public HomePage(WebDriver driver) {
//        File myFile = new File("src/main/resources/config.properties");
//        Properties properties = new Properties();
//        try {
//            properties.load(new FileReader(myFile));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        PageFactory.initElements(driver, this);
        this.driver = driver;
//        this.driver.get(properties.getProperty("site"));
//        this.driver.get("https://www.nike.com/");
        this.driver.get("https://nike.com/ca");
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

    public WebElement getSearchButton() {
        return searchButton;
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

    public WebElement getMenGenderSelect() {
        return menGenderSelect;
    }

    public WebElement getSignUpButton() {
        return signUpButton;
    }

    public WebElement getOutWindowArea() {
        return outWindowArea;
    }

    public WebElement getHelpButton() {
        return helpButton;
    }

    public WebElement getLocationWindowOpen() {
        return locationWindowOpen;
    }

    public WebElement getCloseLocatorMenuButton() {
        return closeLocatorMenuButton;
    }

    public WebElement getLocatorWindowClass() {
        return locatorWindowClass;
    }

    public WebElement getLocationCanadaEnglBar() {
        return locationCanadaEnglBar;
    }
//
//    public WebElement getLocalisationID() {
//        return localisationID;
//    }
}
