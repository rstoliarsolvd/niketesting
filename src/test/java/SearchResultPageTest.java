import com.solvd.nike.HomePage;
import com.solvd.nike.SearchResultPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class SearchResultPageTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(SearchResultPageTest.class);

    public WebDriver driver;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "/Users/rstoliar/Downloads/chromedriver");
        driver= new ChromeDriver();
    }

    @Test
    public void checkHomeButtonTest(){
        SearchResultPage searchResultPage = new SearchResultPage(driver);
        searchResultPage.getHomeButton().click();

    }


    @Test
    public void checkSearchRunResultTest(){
        SearchResultPage searchResultPage = new SearchResultPage(driver);
        SoftAssert softAssert = new SoftAssert();

        driver.manage().timeouts().pageLoadTimeout(6, TimeUnit.SECONDS);
        searchResultPage.getCloseLocatorMenuButton().click();
        driver.manage().timeouts().pageLoadTimeout(6, TimeUnit.SECONDS);
//        if (true) {
//            searchResultPage.getCloseLocatorMenuButton().click();
//        }
//            driver.manage().timeouts().pageLoadTimeout(6, TimeUnit.SECONDS);


        searchResultPage.getRunSearchResultList().stream()
                .forEach(item->softAssert.assertTrue(item.getText().toLowerCase(Locale.ROOT)
                        .contains("run")));
                softAssert.assertAll();

    }


}
