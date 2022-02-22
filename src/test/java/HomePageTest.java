import com.solvd.nike.HomePage;
import com.solvd.nike.MenShoesFilterPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class HomePageTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(HomePageTest.class);
    private WebDriver driver;
    private final String URL = "https://www.nike.com/";

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/rstoliar/Downloads/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(URL);
    }

    @AfterMethod
    public void driverQuit() {
        driver.quit();
    }

//    public String getURLFromProperty(){
//        File myFile = new File("src/main/resources/config.properties");
//        Properties properties = new Properties();
//        try {
//            properties.load(new FileReader(myFile));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        String site = properties.getProperty("site");
//        return site;
//    }

    @Test
    /**
     (description = "Check possibility of choosing location - 'Canada, English'")
     @TestRailCases(testCasesId = "1")
     @MethodOwner(owner = "rstoliar", platform = "web")
     */
    public void checkChooseLocationTest() {

        HomePage homePage = new HomePage(driver);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(driver.getCurrentUrl().toLowerCase(Locale.ROOT), URL);
        homePage.clickLocationCanadaEnglBar();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        softAssert.assertEquals(driver.getCurrentUrl().toLowerCase(Locale.ROOT), URL + "ca/");
        softAssert.assertTrue(homePage.containCanadaLocalID());
        softAssert.assertAll();
    }

    @Test
/**
 (description = "Check input 'run' in search field and having correct result")
 @TestRailCases(testCasesId = "4")
 @MethodOwner(owner = "rstoliar", platform = "web")
 */
    public void checkSearchFieldTest() {

        HomePage homePage = new HomePage(driver);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(driver.getCurrentUrl().toLowerCase(Locale.ROOT), URL);
        homePage.clickLocationCanadaEnglBar();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        softAssert.assertEquals(driver.getCurrentUrl().toLowerCase(Locale.ROOT), URL + "ca/");
        softAssert.assertTrue(homePage.containCanadaLocalID());

        homePage.clickSearchField();
        softAssert.assertTrue(homePage.openSearchFieldActiveBar());
        homePage.inputWordInSearch("run");
        softAssert.assertTrue(homePage.containRunInTextSearchSugg());
        homePage.clickSearchButton();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        softAssert.assertTrue(homePage.conformationSearchPageResult());
        softAssert.assertEquals(driver.getCurrentUrl().toLowerCase(Locale.ROOT), "https://www.nike.com/ca/w?q=run&vst=run");

        softAssert.assertAll();
    }

    @Test
/**
 (description = "Check home button - back to start Page")
 @TestRailCases(testCasesId = "10")
 @MethodOwner(owner = "rstoliar", platform = "web")
 */
    public void checkHomeButtonTest() {

        HomePage homePage = new HomePage(driver);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(driver.getCurrentUrl().toLowerCase(Locale.ROOT), URL);
        homePage.clickLocationCanadaEnglBar();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        softAssert.assertEquals(driver.getCurrentUrl().toLowerCase(Locale.ROOT), URL + "ca/");
        softAssert.assertTrue(homePage.containCanadaLocalID());

        homePage.clickSearchField();
        softAssert.assertTrue(homePage.openSearchFieldActiveBar());
        homePage.inputWordInSearch("run");
        softAssert.assertTrue(homePage.containRunInTextSearchSugg());
        homePage.clickSearchButton();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        softAssert.assertTrue(homePage.conformationSearchPageResult());
        softAssert.assertEquals(driver.getCurrentUrl().toLowerCase(Locale.ROOT), "https://www.nike.com/ca/w?q=run&vst=run");

        homePage.clickHomeButton();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        softAssert.assertEquals(driver.getCurrentUrl().toLowerCase(Locale.ROOT), URL + "ca/");
        softAssert.assertTrue(homePage.containCanadaLocalID());

        softAssert.assertAll();
    }

    @Test(description = "Check input in search field special characters'#$%^&*(' - 'incorrect input'.Double times ")
    /**@TestRailCases(testCasesId = "11")
     @MethodOwner(owner = "rstoliar", platform = "web")
     */
    public void checkIncorrectInputSearchFieldTest() {

        HomePage homePage = new HomePage(driver);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(driver.getCurrentUrl().toLowerCase(Locale.ROOT), URL);
        homePage.clickLocationCanadaEnglBar();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        softAssert.assertEquals(driver.getCurrentUrl().toLowerCase(Locale.ROOT), URL + "ca/");
        softAssert.assertTrue(homePage.containCanadaLocalID());

        homePage.clickSearchField();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        softAssert.assertTrue(homePage.openSearchFieldActiveBar());
        homePage.inputSpecialCharInSearch("#$%^&*(");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        softAssert.assertTrue(homePage.searchContainTopSuggestionField());
        homePage.clickSearchButton();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        softAssert.assertTrue(homePage.incorrectInputConformationSearchPageResult());
        softAssert.assertEquals(driver.getCurrentUrl().toLowerCase(Locale.ROOT), "https://www.nike.com/ca/w?q=");
        homePage.clickSearchField();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        homePage.inputSpecialCharInSearch("#$%^&*(");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        softAssert.assertTrue(homePage.searchContainTopSuggestionField());
        homePage.clickSearchButton();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

//        softAssert.assertEquals(driver.getCurrentUrl().toLowerCase(Locale.ROOT), "https://www.nike.com/ca/w?q=%23%24%25%5e%26*(&vst=%23%24%25%5e%26*(");
        softAssert.assertTrue(homePage.noSuchResultMessageDisplayed());

        softAssert.assertAll();
    }

    @Test
/**
 (description = "Check 'help'- button to give a help page ")
 @TestRailCases(testCasesId = "13")
 @MethodOwner(owner = "rstoliar", platform = "web")
 */
    public void checkHelpButtonTest() {
        HomePage homePage = new HomePage(driver);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(driver.getCurrentUrl().toLowerCase(Locale.ROOT), URL);
        homePage.clickLocationCanadaEnglBar();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        softAssert.assertEquals(driver.getCurrentUrl().toLowerCase(Locale.ROOT), URL + "ca/");
        softAssert.assertTrue(homePage.containCanadaLocalID());

        homePage.clickHelpButton();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        homePage.clickHelpButton();

        softAssert.assertTrue(homePage.helpPageTitleContain());

        softAssert.assertAll();
    }

    @Test
/**
 (description = "Check 'Quick assist help' at help-page - for "Where is my refund?" question ")
 @TestRailCases(testCasesId = "14")
 @MethodOwner(owner = "rstoliar", platform = "web")
 */
    public void checkQuickAssistHelpTest() {
        HomePage homePage = new HomePage(driver);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(driver.getCurrentUrl().toLowerCase(Locale.ROOT), URL);
        homePage.clickLocationCanadaEnglBar();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        softAssert.assertEquals(driver.getCurrentUrl().toLowerCase(Locale.ROOT), URL + "ca/");
        softAssert.assertTrue(homePage.containCanadaLocalID());

        homePage.clickHelpButton();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        homePage.clickHelpButton();
        softAssert.assertTrue(homePage.helpPageTitleContain());
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        homePage.clickQuickAssistButton();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        softAssert.assertTrue(homePage.refundPageTitleDisplayed());

        softAssert.assertAll();
    }

    @Test
/**
 (description = "Check main menu buttons 'MEN' ")
 @TestRailCases(testCasesId = "5")
 @MethodOwner(owner = "rstoliar", platform = "web")
 */
    public void checkMenuMenButtonTest() {
        HomePage homePage = new HomePage(driver);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(driver.getCurrentUrl().toLowerCase(Locale.ROOT), URL);
        homePage.clickLocationCanadaEnglBar();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        softAssert.assertEquals(driver.getCurrentUrl().toLowerCase(Locale.ROOT), URL + "ca/");
        softAssert.assertTrue(homePage.containCanadaLocalID());

        homePage.clickMenuMenButton();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        softAssert.assertTrue(homePage.menPageTitleDisplayed());

        softAssert.assertAll();
    }

    @Test
/**
 (description = "Check main menu sort filter for 'MEN - All Shoes' ")
 @TestRailCases(testCasesId = "6")
 @MethodOwner(owner = "rstoliar", platform = "web")
 */
    public void checkMenuSortFilterTest() {
        HomePage homePage = new HomePage(driver);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(driver.getCurrentUrl().toLowerCase(Locale.ROOT), URL);
        homePage.clickLocationCanadaEnglBar();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        softAssert.assertEquals(driver.getCurrentUrl().toLowerCase(Locale.ROOT), URL + "ca/");
        softAssert.assertTrue(homePage.containCanadaLocalID());

        homePage.moveCursorToMenMenuButton();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        homePage.clickMenuMenAllShoesBar();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        MenShoesFilterPage menShoesFilterPage = new MenShoesFilterPage(driver);
        driver.getCurrentUrl();
        softAssert.assertTrue(menShoesFilterPage.conformationAllShoesMenPage(), "Men's All Shoes  - page is not displayed");
        softAssert.assertEquals(driver.getCurrentUrl(), "https://www.nike.com/ca/w/mens-shoes-nik1zy7ok", "The current URL is not equals to needed 'https://www.nike.com/ca/w/mens-shoes-nik1zy7ok'");

        softAssert.assertAll();
    }

    @Test
/**
 (description = "Check inner sort filter for 'MEN - All Shoes - Shop by price - 0-74$' ")
 @TestRailCases(testCasesId = "7")
 @MethodOwner(owner = "rstoliar", platform = "web")
 */
    public void checkInnerSortFilterTest() {
        HomePage homePage = new HomePage(driver);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(driver.getCurrentUrl().toLowerCase(Locale.ROOT), URL);
        homePage.clickLocationCanadaEnglBar();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        softAssert.assertEquals(driver.getCurrentUrl().toLowerCase(Locale.ROOT), URL + "ca/");
        softAssert.assertTrue(homePage.containCanadaLocalID());

        homePage.moveCursorToMenMenuButton();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        homePage.clickMenuMenAllShoesBar();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        softAssert.assertEquals(driver.getCurrentUrl(), "https://www.nike.com/ca/w/mens-shoes-nik1zy7ok");


        MenShoesFilterPage menShoesFilterPage = new MenShoesFilterPage(driver);
        driver.getCurrentUrl();
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

//        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.cssSelector("locator"))).click();
        menShoesFilterPage.clickShopByPriceCheckBox();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        softAssert.assertEquals(driver.getCurrentUrl(), "https://www.nike.com/ca/w/mens-shoes-nik1zy7ok");

        driver.get(driver.getCurrentUrl());
        List<Integer> prices = menShoesFilterPage.getShoesPrices();
        for (Integer price : prices) {
            softAssert.assertTrue(price < 75, "Shoes price is nor in  range 0-74");
        }

        softAssert.assertAll();
    }

}


