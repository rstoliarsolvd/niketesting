import com.solvd.nike.SearchResultPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.logging.Logger;

public class SearchResultPageTest {

    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(SearchResultPageTest.class);

    public WebDriver driver;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "/Users/rstoliar/Downloads/chromedriver");
        driver= new ChromeDriver();
    }

    @Test
    public void CheckHomeButtonTest(){
        SearchResultPage searchResultPage = new SearchResultPage(driver);
        searchResultPage.getHomeButton().click();

    }


}
