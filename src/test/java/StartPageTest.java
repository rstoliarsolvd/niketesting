import com.solvd.nike.HelpPage;
import com.solvd.nike.MenShoesFilterPage;
import com.solvd.nike.StartPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.awt.*;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StartPageTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(StartPageTest.class);
    private WebDriver driver;
    String url = "https://www.nike.com/";

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/rstoliar/Downloads/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(url);
    }

    @Test
    /**
     (description = "Check possibility of choosing location - 'Canada, English'")
     @TestRailCases(testCasesId = "1")
     @MethodOwner(owner = "rstoliar", platform = "web")
     */
    public void checkChooseLocationTest() {

        StartPage startPage = new StartPage(driver);
        SoftAssert softAssert = new SoftAssert();
        startPage.getLocationCanadaEnglBar().click();
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
        softAssert.assertTrue(startPage.getLocalisationID().getText().contains("Canada"));
        driver.quit();
    }

    //    @Test
//    /**
//     (description = "Check 'sign up for email' form  for correct input work'", "password has to meet :
//     Minimum of 8 characters 1 uppercase letter 1 lowercase letter 1 number")
//     @TestRailCases(testCasesId = "3")
//     @MethodOwner(owner = "rstoliar", platform = "web")
//     */
//    public void checkSignUpFormTest() {
//
//        StartPage startPage = new StartPage(driver);
//        startPage.getLocationCanadaEnglBar().click();
//        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
//
//        startPage.getSignUpForEmailBar().click();
//        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
//        driver.get("https://www.nike.com/ca/email-signup");
//
//        startPage.getEmailAddressField().click();
//        startPage.getEmailAddressField().sendKeys("2gogo.tut@go.com");
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//        startPage.getDobField().click();
//        startPage.getDobField().sendKeys("02.04.1990");
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//        startPage.getSelectGenderSelect().click();
//        startPage.getMenGenderSelect().click();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        startPage.getSignUpFistWindowButton().click();
//
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//
////        startPage.getCloseFistWindowButton().click();
//        System.out.println(driver.getCurrentUrl().compareTo("https://www.nike.com/ca/"));
//        System.out.println(driver.getCurrentUrl());
//        System.out.println("driver.getCurrentUrl().toString().equals(\"https://www.nike.com/ca/\") = " + driver.getCurrentUrl().toString().equals("https://www.nike.com/ca/"));
////if ()
//
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        startPage.getSignUpSecondWindowButton().click();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        startPage.getPasswordField().click();
//        startPage.getPasswordField().sendKeys("Go1Go.tut@121");
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//
//        startPage.getFirstNameField().click();
//        startPage.getFirstNameField().sendKeys("John2");
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//
//        startPage.getLastNameField().click();
//        startPage.getLastNameField().sendKeys("Dale2");
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//
//        startPage.getSignUpCheckBox().click();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//
//        startPage.getJoinUsThirdWindowButton().click();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//
//        driver.quit();
//    }
    @Test
/**
 (description = "Check input in search field and having correct result")
 @TestRailCases(testCasesId = "4")
 @MethodOwner(owner = "rstoliar", platform = "web")
 */
    public void checkSearchFieldTest() {

        StartPage startPage = new StartPage(driver);
        SoftAssert softAssert = new SoftAssert();

        startPage.getLocationCanadaEnglBar().click();
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);

        startPage.getSearchField().click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        startPage.getSearchField().sendKeys("run");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        startPage.getSearchButton().click();
        softAssert.assertTrue(driver.getCurrentUrl().toString().equals("https://www.nike.com/ca/w?q=run&vst=run"));
        driver.quit();
    }

    @Test
/**
 (description = "Check home button - back to start Page")
 @TestRailCases(testCasesId = "10")
 @MethodOwner(owner = "rstoliar", platform = "web")
 */
    public void checkHomeButtonTest() {

        StartPage startPage = new StartPage(driver);
        SoftAssert softAssert = new SoftAssert();

        startPage.getLocationCanadaEnglBar().click();
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);

        startPage.getSearchField().click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        startPage.getSearchField().sendKeys("run");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        startPage.getSearchButton().click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        startPage.getHomeButton().click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        softAssert.assertTrue(driver.getCurrentUrl().toString().equals("https://www.nike.com/ca/"));
        driver.quit();
    }

    @Test
/**
 (description = "Check input in search field special characters - 'incorrect input' ")
 @TestRailCases(testCasesId = "11")
 @MethodOwner(owner = "rstoliar", platform = "web")
 */
    public void checkIncorrectInputSearchFieldTest() {

        StartPage startPage = new StartPage(driver);
        SoftAssert softAssert = new SoftAssert();

        startPage.getLocationCanadaEnglBar().click();
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);

        startPage.getSearchField().click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        startPage.getSearchField().sendKeys("#$%^&*(");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        startPage.getSearchButton().click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        softAssert.assertTrue(driver.getCurrentUrl().toString().equals("https://www.nike.com/ca/w?q="));

        startPage.getSearchField().click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        startPage.getSearchField().sendKeys("#$%^&*(");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        startPage.getSearchButton().click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        softAssert.assertTrue(startPage.getNoResultMessage().getText().toLowerCase(Locale.ROOT)
                .contains("could not find anything"));
        driver.quit();
    }

    @Test
/**
 (description = "Check 'help'- button to give a help page ")
 @TestRailCases(testCasesId = "13")
 @MethodOwner(owner = "rstoliar", platform = "web")
 */
    public void checkHelpButtonTest() {

        StartPage startPage = new StartPage(driver);
        SoftAssert softAssert = new SoftAssert();

        startPage.getLocationCanadaEnglBar().click();
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);

        startPage.getHelpButton().click();
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);

        softAssert.assertTrue(driver.getCurrentUrl().toLowerCase(Locale.ROOT).equals("https://www.nike.com/ca/help"));
        LOGGER.debug("Test13 pass. Success");
        driver.quit();
    }

    @Test
/**
 (description = "Check 'Quick assist help' at help-page - for "Where is my refund?" question ")
 @TestRailCases(testCasesId = "14")
 @MethodOwner(owner = "rstoliar", platform = "web")
 */
    public void checkQuickAssistHelpTest() {

        StartPage startPage = new StartPage(driver);
        SoftAssert softAssert = new SoftAssert();

        startPage.getLocationCanadaEnglBar().click();
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);

        startPage.getHelpButton().click();
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);

        driver.getCurrentUrl();
//        startPage.getQuickStartQuestion().click();
        HelpPage helpPage = new HelpPage(driver);
        helpPage.getQuickStartQuestion().click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        softAssert.assertTrue(driver.getCurrentUrl().toString()
                .toLowerCase(Locale.ROOT).equals("https://www.nike.com/ca/help/a/refund-info-gs"));
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);

        driver.quit();
    }

    @Test
/**
 (description = "Check main menu buttons 'MEN' ")
 @TestRailCases(testCasesId = "5")
 @MethodOwner(owner = "rstoliar", platform = "web")
 */
    public void checkMenuMenButtonTest() {

        StartPage startPage = new StartPage(driver);
        SoftAssert softAssert = new SoftAssert();

        startPage.getLocationCanadaEnglBar().click();
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);

        startPage.getMenuMenButton().click();
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);

        softAssert.assertEquals(driver.getCurrentUrl().toString().toLowerCase(Locale.ROOT),"https://www.nike.com/ca/men");

        driver.quit();
    }


    @Test
/**
 (description = "Check main menu sort filter for 'MEN - All Shoes' ")
 @TestRailCases(testCasesId = "6")
 @MethodOwner(owner = "rstoliar", platform = "web")
 */
    public void checkMenuSortFilterTest() {

        StartPage startPage = new StartPage(driver);
        SoftAssert softAssert = new SoftAssert();

        startPage.getLocationCanadaEnglBar().click();
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);


        Actions builder = new Actions(driver);
        builder.moveToElement(startPage.getMenuMenButton()).build().perform();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        startPage.getMenuMenAllShoesBar().click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
softAssert.assertEquals(driver.getCurrentUrl().toString().toLowerCase(Locale.ROOT),"https://www.nike.com/ca/w/mens-shoes-nik1zy7ok");
       driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);

        driver.quit();
    }

    @Test
/**
 (description = "Check inner sort filter for 'MEN - All Shoes - Shop by price - 0-74$' ")
 @TestRailCases(testCasesId = "7")
 @MethodOwner(owner = "rstoliar", platform = "web")
 */
    public void checkInnerSortFilterTest() {

        StartPage startPage = new StartPage(driver);
        SoftAssert softAssert = new SoftAssert();

        startPage.getLocationCanadaEnglBar().click();
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);


        Actions builder = new Actions(driver);
        builder.moveToElement(startPage.getMenuMenButton()).build().perform();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        startPage.getMenuMenAllShoesBar().click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.getCurrentUrl();

        MenShoesFilterPage menShoesFilterPage = new MenShoesFilterPage(driver);
        menShoesFilterPage.getShopByPriceCheckBox().click();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);

        driver.get(driver.getCurrentUrl());

        Pattern p = Pattern.compile("\\d+");
//        menShoesFilterPage.getShoesShoosUnder75().
//                forEach(webElement -> softAssert.assertTrue(Integer.parseInt(p.matcher(webElement.getText()).group())<75));
menShoesFilterPage.getShoesShoosUnder75()
        .forEach(we->softAssert.assertTrue(Integer.parseInt(we.getText().replaceAll("\\D",""))<75));

        driver.quit();
    }

    }
