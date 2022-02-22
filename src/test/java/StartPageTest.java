import com.solvd.nike.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Locale;
import java.util.concurrent.TimeUnit;


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
    @AfterMethod
    public  void driverQuit(){
        driver.quit();
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

//        driver.quit();
        softAssert.assertAll();
    }

    @Test
/**
 (description = "Check input 'run' in search field and having correct result")
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
        softAssert.assertTrue(driver.getCurrentUrl().toLowerCase(Locale.ROOT).equals("https://www.nike.com/ca/w?q=run&vst=run"));
        //        driver.quit();
        softAssert.assertAll();
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
        //        driver.quit();
        softAssert.assertAll();
    }

    @Test
/**
 (description = "Check input in search field special characters - 'incorrect input'.Double times ")
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
        //        driver.quit();
        softAssert.assertAll();
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
        //        driver.quit();
        softAssert.assertAll();
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

        HelpPage helpPage = new HelpPage(driver);
        helpPage.getQuickStartQuestion().click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        softAssert.assertTrue(driver.getCurrentUrl().toString()
                .toLowerCase(Locale.ROOT).equals("https://www.nike.com/ca/help/a/refund-info-gs"));
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);

//        driver.quit();
        softAssert.assertAll();    }

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

        softAssert.assertEquals(driver.getCurrentUrl().toString().toLowerCase(Locale.ROOT), "https://www.nike.com/ca/men");

        //        driver.quit();
        softAssert.assertAll();
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
        softAssert.assertEquals(driver.getCurrentUrl().toString().toLowerCase(Locale.ROOT), "https://www.nike.com/ca/w/mens-shoes-nik1zy7ok");
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);

        //        driver.quit();
        softAssert.assertAll();
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
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get(driver.getCurrentUrl());

        menShoesFilterPage.getShoesChooseUnder75()
                .forEach(we -> softAssert.assertTrue(Integer.parseInt(we.getText()
                        .replaceAll("\\D", "")) < 75));

        //        driver.quit();
        softAssert.assertAll();
    }

    @Test
/**
 (description = "Check the 'join us' top bar -  'Join us' page-form should open ")
 @TestRailCases(testCasesId = "15")
 @MethodOwner(owner = "rstoliar", platform = "web")
 */
    public void checkJoinUsTopBarTest() {

        StartPage startPage = new StartPage(driver);
        SoftAssert softAssert = new SoftAssert();

        startPage.getLocationCanadaEnglBar().click();
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);

        startPage.getJoinUpTopBar().click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        softAssert.assertEquals(driver.getCurrentUrl()
                .toLowerCase(Locale.ROOT), "https://www.nike.com/ca/membership");

        MembershipPage membershipPage = new MembershipPage(driver);
        driver.get(driver.getCurrentUrl());
        membershipPage.getJoinUsButton().click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        softAssert.assertEquals(driver.getCurrentUrl()
                .toLowerCase(Locale.ROOT), "https://www.nike.com/ca/register");
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

        //        driver.quit();
        softAssert.assertAll();
    }

    @Test
/**
 (description = "Check the 'join us' page-form success registration / need to change email each time")
 @TestRailCases(testCasesId = "16")
 @MethodOwner(owner = "rstoliar", platform = "web")
 */
    public void checkJoinUsFormRegistrationTest() {

        StartPage startPage = new StartPage(driver);
        SoftAssert softAssert = new SoftAssert();

        startPage.getLocationCanadaEnglBar().click();
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);

        startPage.getJoinUpTopBar().click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        MembershipPage membershipPage = new MembershipPage(driver);
        driver.get(driver.getCurrentUrl());
        membershipPage.getJoinUsButton().click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        RegisterPage registerPage = new RegisterPage(driver);
        driver.get(driver.getCurrentUrl());
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        if (registerPage.getLocationMessage().isDisplayed()) {
            registerPage.getCanadaLocationMessage().click();
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            WebElement engLocMes = registerPage.getEnglishCanadaLocMessage();
            boolean eng = engLocMes.getText().toLowerCase().contains("english");
            if (eng) {
                engLocMes.click();
                driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            }
        }

        registerPage.getEmailInputField().click();
        registerPage.getEmailInputField().sendKeys("2Go.Nike@by.com");

        registerPage.getPasswordInputField().sendKeys("1Go.Nike");
        registerPage.getFirstNameInputField().sendKeys("Go");
        registerPage.getLastNameInputField().sendKeys("Nike");

        if (registerPage.getLocationMessage().isDisplayed()) {
            registerPage.getCanadaLocationMessage().click();
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            WebElement engLocMes = registerPage.getEnglishCanadaLocMessage();
            Boolean eng = engLocMes.getText().toLowerCase().contains("english");
            if (eng) {
                engLocMes.click();
                driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            }
        }

        registerPage.getDobInputField().sendKeys("01012001");


        registerPage.getCountrySelect().click();
        registerPage.getCanadaCountrySelect().click();
        registerPage.getMaleButton().click();


        registerPage.getSignUpCheckBox().click();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        registerPage.getJoinUsButton().click();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);


        //        driver.quit();
        softAssert.assertAll();
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


}
