
import com.solvd.nike.HomePage;
import com.solvd.nike.SearchResultPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class HomePageTest {
    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(HomePageTest.class);
    private WebDriver driver;


    //    @BeforeMethod
//    public void setUp() {
//        System.setProperty("webdriver.chrome.driver", "/Users/rstoliar/Downloads/chromedriver");
//        driver = new ChromeDriver();
//    }

    @Test
    public void CheckSignUpFormTest(){
//        HomePage homePage = new HomePage(driver);
//        driver.get("https://www.nike.com/");
//        LOGGER.info("Home page created");
    }

//    @Test
//    public void CheckClosingUnFilledSignUpFormTest() {
//        HomePage homePage = new HomePage(driver);
//        homePage.getSignUpButton().click();
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//        homePage.getOutWindowArea().click();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.quit();
//
//    }

//    @Test
//    public void checkSearchFieldTest() {
//        HomePage homePage = new HomePage(driver);
//        homePage.getSearchField().click();
//        homePage.getMenuMenButton().sendKeys("run");
//        homePage.getSearchButtom().click();
//
//        SearchResultPage searchResultPage = new SearchResultPage(driver);
//        List<WebElement> runSearchResults = searchResultPage.getRunSearchResultList();
//
//        SoftAssert softAssert = new SoftAssert();
//        runSearchResults
//                .forEach(searchResult -> {
//                    softAssert.assertTrue(searchResult.getText().toLowerCase(Locale.ROOT).contains("run"));
//                    LOGGER.info(searchResult.getText());
//
////                     findElement(By.cssSelector("div.product-card__subtitle[role='link']"))
//
//                });
//        softAssert.assertAll();
//    }
}

