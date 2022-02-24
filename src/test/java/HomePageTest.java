import com.solvd.nike.HomePage;
import com.solvd.nike.MenShoesFilterPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class HomePageTest {
    private static final Logger LOGGER = LogManager.getLogger(HomePageTest.class);
    private WebDriver driver;
    private static final String URL = "https://www.nike.com/";

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

    @Test(description = "Check possibility of choosing location - 'Canada, English'")
    /**
     * @TestRailCases(testCasesId = "1")
     * @MethodOwner(owner = "rstoliar", platform = "web")
     */
    public void checkChooseLocationTest() {

        HomePage homePage = new HomePage(driver);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(driver.getCurrentUrl().toLowerCase(Locale.ROOT), URL, "Can't open the HomeNikePage");
        homePage.clickLocationCanadaEnglBar();
        softAssert.assertEquals(driver.getCurrentUrl()
                .toLowerCase(Locale.ROOT), URL + "ca/", "The location selected is not 'Canada English'");
        softAssert.assertTrue(homePage.containCanadaLocalID(), "The 'Canada' location is not selected");
        softAssert.assertAll();
    }

    @Test(description = "Check input 'run' in search field and having correct result")
    /**
     * @TestRailCases(testCasesId = "4")
     * @MethodOwner(owner = "rstoliar", platform = "web")
     */
    public void checkSearchFieldTest() {

        final String searchResultPageURL = "https://www.nike.com/ca/w?q=run&vst=run";
        String inputWord = "run";

        HomePage homePage = new HomePage(driver);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(driver.getCurrentUrl().toLowerCase(Locale.ROOT), URL, "Can't open the HomeNikePage");
        homePage.clickLocationCanadaEnglBar();
        softAssert.assertEquals(driver.getCurrentUrl()
                .toLowerCase(Locale.ROOT), URL + "ca/", "The location selected is not 'Canada English'");
        softAssert.assertTrue(homePage.containCanadaLocalID(), "The 'Canada' location is not selected");

        homePage.clickSearchField();
        softAssert.assertTrue(homePage.openSearchFieldActiveBar(), "The 'search field' is not selected (clicked)");
        homePage.inputWordInSearch(inputWord);
        softAssert.assertTrue(homePage.containRunInTextSearchSugg(), "The needed word 'run' isn't inputed correctly ");
        homePage.clickSearchButton();
        softAssert.assertTrue(homePage.conformationSearchPageResult(), "The SearchResult page is not open");
        softAssert.assertEquals(driver.getCurrentUrl().toLowerCase(Locale.ROOT), searchResultPageURL, "Current page URL differ from expected ");

        softAssert.assertAll();
    }

    @Test(description = "Check home button - back to start Page")
    /**
     * @TestRailCases(testCasesId = "10")
     * @MethodOwner(owner = "rstoliar", platform = "web")
     */
    public void checkHomeButtonTest() {

        final String searchResultPageURL = "https://www.nike.com/ca/w?q=run&vst=run";
        String inputWord = "run";


        HomePage homePage = new HomePage(driver);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(driver.getCurrentUrl().toLowerCase(Locale.ROOT), URL, "Can't open the HomeNikePage");
        homePage.clickLocationCanadaEnglBar();
        softAssert.assertEquals(driver.getCurrentUrl()
                .toLowerCase(Locale.ROOT), URL + "ca/", "The location selected is not 'Canada English'");
        softAssert.assertTrue(homePage.containCanadaLocalID(), "The 'Canada' location is not selected");

        homePage.clickSearchField();
        softAssert.assertTrue(homePage.openSearchFieldActiveBar(), "The 'search field' is not selected (clicked)");
        homePage.inputWordInSearch(inputWord);
        softAssert.assertTrue(homePage.containRunInTextSearchSugg(), "The needed word 'run' isn't inputed correctly ");
        homePage.clickSearchButton();
        softAssert.assertTrue(homePage.conformationSearchPageResult(), "The SearchResult page is not open");
        softAssert.assertEquals(driver.getCurrentUrl().toLowerCase(Locale.ROOT), searchResultPageURL, "Current page URL differ from expected ");

        homePage.clickHomeButton();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        softAssert.assertEquals(driver.getCurrentUrl().toLowerCase(Locale.ROOT), URL + "ca/", "Current page URL differ from expected");
        softAssert.assertTrue(homePage.containCanadaLocalID(), "The Home Page is not opened");

        softAssert.assertAll();
    }

    @Test(description = "Check input in search field special characters'#$%^&*(' - 'incorrect input'.Double times ")
    /**
     * @TestRailCases(testCasesId = "11")
     * @MethodOwner(owner = "rstoliar", platform = "web")
     */
    public void checkIncorrectInputSearchFieldTest() {
        final String incorrectInputURL = "https://www.nike.com/ca/w?q=";
        final String incorrectInput = "#$%^&*(";

        HomePage homePage = new HomePage(driver);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(driver.getCurrentUrl().toLowerCase(Locale.ROOT), URL, "Can't open the HomeNikePage");
        homePage.clickLocationCanadaEnglBar();
        softAssert.assertEquals(driver.getCurrentUrl()
                .toLowerCase(Locale.ROOT), URL + "ca/", "The location selected is not 'Canada English'");
        softAssert.assertTrue(homePage.containCanadaLocalID(), "The 'Canada' location is not selected");

        homePage.clickSearchField();
        softAssert.assertTrue(homePage.openSearchFieldActiveBar(), "The 'search field' is not selected (clicked)");
        homePage.inputSpecialCharInSearch(incorrectInput);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        softAssert.assertTrue(homePage.searchContainTopSuggestionField(), "No suggestion were shown");
        homePage.clickSearchButton();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        softAssert.assertTrue(homePage.incorrectInputConformationSearchPageResult(), "The incorrect input page 'all products' is not shown ");
        softAssert.assertEquals(driver.getCurrentUrl().toLowerCase(Locale.ROOT), incorrectInputURL, "Current page URL differ from expected");
        homePage.clickSearchField();
        homePage.inputSpecialCharInSearch(incorrectInput);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        softAssert.assertTrue(homePage.searchContainTopSuggestionField(), "No suggestion were shown");
        homePage.clickSearchButton();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

//        softAssert.assertEquals(driver.getCurrentUrl().toLowerCase(Locale.ROOT), "https://www.nike.com/ca/w?q=%23%24%25%5e%26*(&vst=%23%24%25%5e%26*(", "Current page URL differ from expected");
        softAssert.assertTrue(homePage.noSuchResultMessageDisplayed(), "No 'no result' message is displayed");

        softAssert.assertAll();
    }

    @Test(description = "Check 'help'- button to give a help page ")
    /**
     * @TestRailCases(testCasesId = "13")
     * @MethodOwner(owner = "rstoliar", platform = "web")
     */
    public void checkHelpButtonTest() {

        HomePage homePage = new HomePage(driver);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(driver.getCurrentUrl().toLowerCase(Locale.ROOT), URL, "Can't open the HomeNikePage");
        homePage.clickLocationCanadaEnglBar();
        softAssert.assertEquals(driver.getCurrentUrl()
                .toLowerCase(Locale.ROOT), URL + "ca/", "The location selected is not 'Canada English'");
        softAssert.assertTrue(homePage.containCanadaLocalID(), "The 'Canada' location is not selected");

        homePage.clickHelpButton();
        homePage.clickHelpButton();
        softAssert.assertTrue(homePage.helpPageTitleContain(), "The 'help' button is not opened");

        softAssert.assertAll();
    }

    @Test(description = "Check 'Quick assist help' at help-page - for  'Where is my refund?' question ")
    /**
     * @TestRailCases(testCasesId = "14")
     * @MethodOwner(owner = "rstoliar", platform = "web")
     */
    public void checkQuickAssistHelpTest() {

        HomePage homePage = new HomePage(driver);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(driver.getCurrentUrl().toLowerCase(Locale.ROOT), URL, "Can't open the HomeNikePage");
        homePage.clickLocationCanadaEnglBar();
        softAssert.assertEquals(driver.getCurrentUrl()
                .toLowerCase(Locale.ROOT), URL + "ca/", "The location selected is not 'Canada English'");
        softAssert.assertTrue(homePage.containCanadaLocalID(), "The 'Canada' location is not selected");

        homePage.clickHelpButton();
        homePage.clickHelpButton();
        softAssert.assertTrue(homePage.helpPageTitleContain(), "The 'help' page is not opened");

        homePage.clickQuickAssistButton();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        softAssert.assertTrue(homePage.refundPageTitleDisplayed(), "The needed 'Where is my refund?' page is not displayed");

        softAssert.assertAll();
    }

    @Test(description = "Check main menu buttons 'MEN' ")
    /**
     * @TestRailCases(testCasesId = "5")
     * @MethodOwner(owner = "rstoliar", platform = "web")
     */
    public void checkMenuMenButtonTest() {

        HomePage homePage = new HomePage(driver);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(driver.getCurrentUrl().toLowerCase(Locale.ROOT), URL, "Can't open the HomeNikePage");
        homePage.clickLocationCanadaEnglBar();
        softAssert.assertEquals(driver.getCurrentUrl()
                .toLowerCase(Locale.ROOT), URL + "ca/", "The location selected is not 'Canada English'");
        softAssert.assertTrue(homePage.containCanadaLocalID(), "The 'Canada' location is not selected");

        homePage.clickMenuMenButton();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        softAssert.assertTrue(homePage.menPageTitleDisplayed(), "The page titled 'MEN' is not Displayed");

        softAssert.assertAll();
    }

    @Test(description = "Check main menu sort filter for 'MEN - All Shoes' ")
    /**
     * @TestRailCases(testCasesId = "6")
     * @MethodOwner(owner = "rstoliar", platform = "web")
     */
    public void checkMenuSortFilterTest() {

        final String allShoesMenPageURL = "https://www.nike.com/ca/w/mens-shoes-nik1zy7ok";
        HomePage homePage = new HomePage(driver);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(driver.getCurrentUrl().toLowerCase(Locale.ROOT), URL, "Can't open the HomeNikePage");
        homePage.clickLocationCanadaEnglBar();
        softAssert.assertEquals(driver.getCurrentUrl()
                .toLowerCase(Locale.ROOT), URL + "ca/", "The location selected is not 'Canada English'");
        softAssert.assertTrue(homePage.containCanadaLocalID(), "The 'Canada' location is not selected");

        homePage.moveCursorToMenMenuButton();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        softAssert.assertTrue(homePage.menuMenDropDownIsDisplayed(), "The 'Drop-Down Men menu' is not displayed");

        homePage.clickMenuMenAllShoesBar();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        MenShoesFilterPage menShoesFilterPage = new MenShoesFilterPage(driver);
        driver.getCurrentUrl();
        softAssert.assertTrue(menShoesFilterPage.conformationAllShoesMenPage(), "Men's All Shoes  - page is not displayed");
        softAssert.assertEquals(driver.getCurrentUrl(), allShoesMenPageURL, "The current URL is not equals to needed 'https://www.nike.com/ca/w/mens-shoes-nik1zy7ok'");

        softAssert.assertAll();
    }

    @Test(description = "Check inner sort filter for 'MEN - All Shoes - Shop by price - 0-74$' ")
    /**
     * @TestRailCases(testCasesId = "7")
     * @MethodOwner(owner = "rstoliar", platform = "web")
     */
    public void checkInnerSortFilterTest() {
        HomePage homePage = new HomePage(driver);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(driver.getCurrentUrl().toLowerCase(Locale.ROOT), URL);
        homePage.clickLocationCanadaEnglBar();
        softAssert.assertEquals(driver.getCurrentUrl().toLowerCase(Locale.ROOT), URL + "ca/");
        softAssert.assertTrue(homePage.containCanadaLocalID());

        homePage.moveCursorToMenMenuButton();
        homePage.clickMenuMenAllShoesBar();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.getCurrentUrl();
        MenShoesFilterPage menShoesFilterPage = new MenShoesFilterPage(driver);
        softAssert.assertEquals(driver.getCurrentUrl(), "https://www.nike.com/ca/w/mens-shoes-nik1zy7ok");


//        MenShoesFilterPage menShoesFilterPage = new MenShoesFilterPage(driver);

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


