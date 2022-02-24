import com.solvd.nike.ExtraNRPage;
import com.solvd.nike.ExtraSortPage;
import com.solvd.nike.HomePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Locale;

public class ExtraSortPageTest {
    private static final Logger LOGGER = LogManager.getLogger(ExtraSortPageTest.class);
    private WebDriver driver;
    private static final String SITEURL = "https://www.nike.com/gb/w/new-accessories-equipment-3n82yzawwpw";
    private static final String URL = "https://www.nike.com/";


    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/rstoliar/Downloads/chromedriver");
        driver = new ChromeDriver();
        driver.get(SITEURL);
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
    public void checkDifferenceOriginalAndNewestListsTest() {
        /**
         * home page enter
         * choose location United Kingdom
         * choose New Release
         * choose Accessories and Equipment
         */
        Integer n = 39;

        HomePage homePage = new HomePage(driver);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(driver.getCurrentUrl().toLowerCase(Locale.ROOT), URL, "Can't open the HomeNikePage");
        homePage.clickUnitedKingdomBar();
        softAssert.assertEquals(driver.getCurrentUrl()
                .toLowerCase(Locale.ROOT), URL + "gb/", "The location selected is not 'United Kingdom'");


        homePage.clickMenuNewReleasesButton();

        driver.getCurrentUrl();
        ExtraNRPage extraNRPage = new ExtraNRPage(driver);
        extraNRPage.clickAccessoriesEquipmentBar();

//        driver.getCurrentUrl();
        driver.get(SITEURL);
        ExtraSortPage extraSortPage = new ExtraSortPage(driver);

        softAssert.assertEquals(driver.getCurrentUrl().toLowerCase(Locale.ROOT), SITEURL, "Can't open the NewAccessoriesAndEquipmentPage");
//        softAssert.assertTrue(extraSortPage.getProductsNumber() == n, "Start size of list of products is not equal to n");

        Double unsortedFirst = extraSortPage.getFirstPrice();
        Double unsortedSecond = extraSortPage.getSecondPrice();
        Double unsortedThird = extraSortPage.getThirdPrice();

        softAssert.assertFalse((unsortedFirst < unsortedSecond && unsortedSecond < unsortedThird) || (unsortedFirst > unsortedSecond && unsortedSecond > unsortedThird), "Start array looks like sorted");
        extraSortPage.clickSortButton();
        softAssert.assertTrue(extraSortPage.isSortMenuOpened(), "Sort Menu can't be opened");

        extraSortPage.clickMenuNewestBar();
        softAssert.assertTrue(extraSortPage.selectorNewestChosen(), "The page with sort 'Newest' can't be opened");

        Double newSortedFirst = extraSortPage.getFirstPrice();
        Double newSortedSecond = extraSortPage.getSecondPrice();
        Double newSortedThird = extraSortPage.getThirdPrice();
        softAssert.assertFalse(unsortedFirst == newSortedFirst
                && unsortedSecond == newSortedSecond && unsortedThird == newSortedThird);

        softAssert.assertAll();
    }

}
