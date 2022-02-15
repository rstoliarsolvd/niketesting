//import com.solvd.nike.SearchResultPage;
//import com.solvd.nike.SignUpPage;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.slf4j.LoggerFactory;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//
//import java.util.logging.Logger;
//
//public class SignUpPageTest {
//
//    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(SignUpPageTest.class);
//
//    public WebDriver driver;
//
//    @BeforeMethod
//    public void setUp(){
//        System.setProperty("webdriver.chrome.driver", "/Users/rstoliar/Downloads/chromedriver");
//        driver= new ChromeDriver();
//    }
//
//    @Test
//    public void CheckSignUpFormTest(){}
//
//    @Test
//    public void CheckClosingUnFilledSignUpFormTest(){
//        SignUpPage signUpPage = new SignUpPage(driver);
//        signUpPage.getOutWindowArea().click();
//
//    }
//}
