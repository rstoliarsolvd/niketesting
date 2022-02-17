
import com.solvd.nike.HomePage;
import com.solvd.nike.SearchResultPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


import java.util.Locale;
import java.util.concurrent.TimeUnit;


public class HomePageTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(HomePageTest.class);
    private WebDriver driver;
    String url = "https://www.nike.com/ca";

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/rstoliar/Downloads/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(url);
//        driver.get("site1");
//        driver.get("https://www.nike.com/");
    }

//    @Test
//    /**
//     (description = "Check possibility of choosing location - 'Canada, English'")
//     @TestRailCases(testCasesId = "1")
//     @MethodOwner(owner = "rstoliar", platform = "web")
//     */
//    public void checkChooseLocationTest() {
////        driver.get("https://www.nike.com/");
//        HomePage homePage = new HomePage(driver);
//        SoftAssert softAssert = new SoftAssert();
//        homePage.getLocationCanadaEnglBar().click();
//        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
//        softAssert.assertTrue(homePage.getLocalisationID().getText().contains("Canada"));
//        driver.quit();
//    }

//    @Test
//    /**
//     (description = "Check possibility of closing pop-up sign-up window
//     without filling fields")
//     @TestRailCases(testCasesId = "2")
//     @MethodOwner(owner = "rstoliar", platform = "web")
//     */
//    public void checkClosingUnFilledSignUpFormTest() {
//        HomePage homePage = new HomePage(driver);
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
////        homePage.getSignUpButton().click();
////        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//        homePage.getOutWindowArea().click();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.quit();
//
//    }

    @Test
    public void checkSignUpFormTest() {

        HomePage homePage = new HomePage(driver);
//        if (homePage.getLocationWindowOpen().isDisplayed()) {
//            homePage.getCloseLocatorMenuButton().click();
//            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//        }
        if (homePage.getLocatorWindowClass().isDisplayed()) {
            homePage.getCloseLocatorMenuButton().click();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        }

        homePage.getSignUpForEmailBar().click();
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);

        if (homePage.getLocatorWindowClass().isDisplayed()) {
            homePage.getCloseLocatorMenuButton().click();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        }
        if (homePage.getLocatorWindowClass().isDisplayed()) {
            homePage.getCloseLocatorMenuButton().click();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        }
        if (homePage.getLocatorWindowClass().isDisplayed()) {
            homePage.getCloseLocatorMenuButton().click();
            new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("nav.hf-language-menu")))
                            .findElement(By.cssSelector("button[aria-label='Close Menu'] .g72-x-circle.fs32-nav-sm.nav-color-black"))
                    .click();
        }

        homePage.getEmailAddressField().click();
        homePage.getEmailAddressField().sendKeys("gogo@go.com");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        homePage.getDobField().click();
        homePage.getDobField().sendKeys("20.02.2000");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        homePage.getSelectGenderSelect().click();
        homePage.getMenGenderSelect().click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        homePage.getSignUpButton().click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.quit();

    }
//
//    @Test
//    public void checkHelpButtonTest() {
//        HomePage homePage = new HomePage(driver);
//        homePage.getHelpButton().click();
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//    }
//
//
//    @Test
//    public void checkSearchFieldTest() {
//        HomePage homePage = new HomePage(driver);
//        homePage.getSearchField().click();
//        homePage.getMenuMenButton().sendKeys("run");
//        homePage.getSearchButton().click();
//
//        SearchResultPage searchResultPage = new SearchResultPage(driver);
//        SoftAssert softAssert = new SoftAssert();
//
//        driver.manage().timeouts().pageLoadTimeout(6, TimeUnit.SECONDS);
//        searchResultPage.getCloseLocatorMenuButton().click();
//        driver.manage().timeouts().pageLoadTimeout(6, TimeUnit.SECONDS);
//        if (true) {
//            searchResultPage.getCloseLocatorMenuButton().click();
//        }
//        driver.manage().timeouts().pageLoadTimeout(6, TimeUnit.SECONDS);
//
//
//        searchResultPage.getRunSearchResultList().stream()
//                .forEach(item -> softAssert.assertTrue(item.getText().toLowerCase(Locale.ROOT)
//                        .contains("run")));
//        softAssert.assertAll();
//
//    }
}

