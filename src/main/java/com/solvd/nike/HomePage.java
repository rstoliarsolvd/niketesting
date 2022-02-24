package com.solvd.nike;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;
import java.util.Properties;

public class HomePage {

    private static final Logger LOGGER = LogManager.getLogger(HomePage.class);
    WebDriver driver;

    private final String URL = "https://www.nike.com/";

    @FindBy(css = "a[href='https://www.nike.com/ca/']")
    private WebElement locationCanadaEnglBar;

    @FindBy(css = "span.country-pin-label")
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
    private WebElement passwordField;

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

    @FindBy(css = ".pre-search-contain")
    private WebElement searchFieldActiveBar;

    @FindBy(css = "#VisualSearchSuggestion-1 span.text-color-primary-dark")
    private WebElement searchSuggestion;

    @FindBy(css = ".pre-search-input-icon")
    private WebElement searchButton;

    @FindBy(xpath = "//*[@id=\"Wall\"]/div/div[3]/header/div/h1/span[2]")
    private WebElement searchPageResult;

    @FindBy(css = "a[aria-label='Nike Homepage']")
    private WebElement homeButton;

    @FindBy(css = "#hf_header_label_search_topSuggestions")
    private WebElement topSuggestionNoVarSearchField;

    @FindBy(css = "h1.wall-header__title.css-hrsjq4.css-7m6ucd.css-yj4gxb")
    private WebElement incorrectInputSearchPageResult;

    @FindBy(css = "div.no-results.css-i5a8ll.css-vae3zs.css-khhzia.css-1rni16j span[data-test='no-results-title']")
    private WebElement noResultMessage;

    @FindBy(css = ".pre-help-button.body-4.u-bold")
    private WebElement helpButton;

    //    @FindBy(css = "[href='/ca/help']")
    @FindBy(css = "[data-testid='HEADER_SEARCH_TITLE_LABEL']")
    private WebElement helpTitle;

    @FindBy(css = "[data-testid='/a/refund-info-gs']")
    private WebElement quickAssistRefundButton;

    @FindBy(css = ".headline-2.mb8-sm.css-1qj0wac")
    private WebElement refundPageTitle;

    @FindBy(css = "a[aria-label='Men']")
    private WebElement menuMenButton;

    @FindBy(css = "h1._1ZsY6zh2")
    private WebElement menPageTitle;

    @FindBy(css = "a[role='menuitem'].body-3[href='https://www.nike.com/ca/w/mens-shoes-nik1zy7ok']")
    private WebElement menuMenAllShoesBar;

    @FindBy(css = ".body-4.d-lg-flx.flx-ai-lg-c.u-bold.ml2-sm.mr2-sm")
    private WebElement joinUpTopBar;

    @FindBy(css = "[aria-label='Men'][aria-expanded='true']")
    private WebElement menuMenDropDown;


    //    @FindBy(css = "a[href='https://www.nike.com/gb/']")
    @FindBy(css = "[title='United Kingdom'][data-type='click_navCountrySelectionSuccess']")
    private WebElement locationUnitedKingdomBar;

    @FindBy(css = "a[aria-label='New Releases']")
    private WebElement menuNewReleasesButton;


    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;

        File myFile = new File("src/main/resources/config.properties");
        File dataFile = new File("src/main/resources/data.properties");
        Properties properties = new Properties();
        try {
            properties.load(new FileReader(myFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.driver.get(properties.getProperty("site"));
    }

    public void clickLocationCanadaEnglBar() {
        new WebDriverWait(driver, 50)
                .until(ExpectedConditions.elementToBeClickable(locationCanadaEnglBar)).click();
    }

    public String getTextLocalisationID() {
        return localisationID.getText().toLowerCase(Locale.ROOT);
    }

    public Boolean containCanadaLocalID() {
        String titleContains = "canada";
        return getTextLocalisationID().contains(titleContains);
    }

    public void clickSearchField() {
        searchField.click();
    }

    public boolean openSearchFieldActiveBar() {
        return searchFieldActiveBar.isDisplayed();
    }

    public void inputWordInSearch(String word) {
        word = "run";
        searchField.sendKeys(word);
    }

    public void inputSpecialCharInSearch(String word) {
        word = "#$%^&*(";
        searchField.sendKeys(word);
    }

    public String getTextSearchSuggestion() {
        return searchSuggestion.getText().toLowerCase(Locale.ROOT);
    }

    public boolean containRunInTextSearchSugg() {
        String titleContains = "run";
        return getTextSearchSuggestion().contains(titleContains);
    }

    public void clickSearchButton() {
        new WebDriverWait(driver, 50)
                .until(ExpectedConditions.elementToBeClickable(searchButton)).click();
    }

    public boolean searchContainTopSuggestionField() {
        String titleContains = "top suggestions";
        return topSuggestionNoVarSearchField.getText().toLowerCase(Locale.ROOT).contains(titleContains);
    }

    public boolean conformationSearchPageResult() {
        return searchPageResult.isDisplayed();
    }

    public boolean incorrectInputConformationSearchPageResult() {
        return incorrectInputSearchPageResult.isDisplayed();
    }

    public String getTextNoResultMessage() {
        return noResultMessage.getText().toLowerCase(Locale.ROOT);
    }

    public boolean noSuchResultMessageDisplayed() {
        return noResultMessage.isDisplayed();
    }

    public void clickHelpButton() {
        new WebDriverWait(driver, 50)
                .until(ExpectedConditions.elementToBeClickable(helpButton));
    }

    public boolean helpPageDisplayed() {
        return helpTitle.isDisplayed();
    }

    public boolean helpPageTitleContain() {
        String titleContains = "help";
        return helpTitle.getText().toLowerCase(Locale.ROOT).contains(titleContains);
    }

    public void clickQuickAssistButton() {
        new WebDriverWait(driver, 50)
                .until(ExpectedConditions.elementToBeClickable(quickAssistRefundButton));
    }

    public boolean refundPageTitleDisplayed() {
        String titleContains = "my refund";
        return refundPageTitle.getText().toLowerCase(Locale.ROOT).contains(titleContains);
    }

    public void clickHomeButton() {
        new WebDriverWait(driver, 50)
                .until(ExpectedConditions.elementToBeClickable(homeButton));
    }

    public void clickMenuMenButton() {
        new WebDriverWait(driver, 50)
                .until(ExpectedConditions.elementToBeClickable(menuMenButton));
    }

    public boolean menPageTitleDisplayed() {
        String titleContains = "men";

//        new WebDriverWait(driver,50)
//                .until(ExpectedConditions.elementSelectionStateToBe(menGenderSelect,true));
        return menPageTitle.getText().toLowerCase(Locale.ROOT).contains(titleContains);
    }

    public void moveCursorToMenMenuButton() {
        Actions builder = new Actions(driver);
        builder.moveToElement(menuMenButton).build().perform();
    }

    public void clickMenuMenAllShoesBar() {
        new WebDriverWait(driver, 50)
                .until(ExpectedConditions.elementToBeClickable(menuMenAllShoesBar));
    }

    public boolean menuMenDropDownIsDisplayed() {
        return menuMenDropDown.isDisplayed();
    }


    public void clickUnitedKingdomBar() {
        new WebDriverWait(driver, 50)
                .until(ExpectedConditions.elementToBeClickable(locationUnitedKingdomBar)).click();
    }

    public void clickMenuNewReleasesButton() {
        new WebDriverWait(driver, 50)
                .until(ExpectedConditions.elementToBeClickable(menuNewReleasesButton)).click();
    }

}
