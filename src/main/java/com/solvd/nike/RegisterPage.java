package com.solvd.nike;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
    WebDriver driver;

    @FindBy(css = "input[data-componentname='emailAddress']")
    private WebElement emailInputField;

    @FindBy(css = "input[data-componentname='passwordCreate']")
    private WebElement passwordInputField;

    @FindBy(css = "input[data-componentname='firstName']")
    private WebElement firstNameInputField;

    @FindBy(css = "input[data-componentname='lastName']")
    private WebElement lastNameInputField;

    @FindBy(css = "input[data-componentname='dateOfBirth']")
    private WebElement dobInputField;

    @FindBy(css = "select[name='country']")
    private WebElement countrySelect;

    @FindBy(css = "option[value='CA']")
    private WebElement canadaCountrySelect;

    @FindBy(css = "#afdcbe67-4213-4015-847f-8ff6742b1529")
    private WebElement maleButton;

    @FindBy(css = "label[for='29ab9a7d-4e9a-40a9-9ca6-86ff8da87edf']")
    private WebElement signUpCheckBox;

    @FindBy(css = "input[type='button'][value='JOIN US']")
    private WebElement joinUsButton;

    @FindBy(css = ".hf-geomismatch-prompt.fs16-sm")
    private WebElement locationMessage;

    @FindBy(css = ".d-sm-b.hf-geomismatch-btn-primary.hf-geomismatch-btn.mt2-sm")
    private WebElement canadaLocationMessage;

    @FindBy(css = ".hf-geomismatch-lang-item.bg-transparent.text-color-primary-light")
    private WebElement englishCanadaLocMessage;

    public RegisterPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
        this.driver.get("https://www.nike.com/ca/register");
    }

    public WebElement getEmailInputField() {
        return emailInputField;
    }

    public WebElement getPasswordInputField() {
        return passwordInputField;
    }

    public WebElement getFirstNameInputField() {
        return firstNameInputField;
    }

    public WebElement getLastNameInputField() {
        return lastNameInputField;
    }

    public WebElement getDobInputField() {
        return dobInputField;
    }

    public WebElement getCountrySelect() {
        return countrySelect;
    }

    public WebElement getCanadaCountrySelect() {
        return canadaCountrySelect;
    }

    public WebElement getMaleButton() {
        return maleButton;
    }

    public WebElement getSignUpCheckBox() {
        return signUpCheckBox;
    }

    public WebElement getJoinUsButton() {
        return joinUsButton;
    }

    public WebElement getLocationMessage() {
        return locationMessage;
    }

    public WebElement getCanadaLocationMessage() {
        return canadaLocationMessage;
    }

    public WebElement getEnglishCanadaLocMessage() {
        return englishCanadaLocMessage;
    }
}
