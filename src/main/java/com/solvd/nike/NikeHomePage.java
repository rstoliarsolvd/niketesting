package com.solvd.nike;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class NikeHomePage {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/rstoliar/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        File myFile = new File("src/main/resources/config.properties");
        Properties properties = new Properties();
        try {
            properties.load(new FileReader(myFile));
        } catch (IOException e) {
            e.printStackTrace();
        }

        driver.get(properties.getProperty("site1"));
        driver.findElement(By.cssSelector("a[href='https://www.nike.com/ca/']")).click();
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);

        driver.findElement(By.cssSelector("#VisualSearchInput")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.findElement(By.cssSelector("#VisualSearchInput")).sendKeys("run");
        driver.findElement(By.cssSelector(".pre-search-input-icon")).click();

        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);

        driver.findElement(By.cssSelector("a[aria-label='Nike Homepage']")).click();
//        driver.quit();
//        driver.get(properties.getProperty("site"));
        driver.findElement(By.cssSelector("a[aria-label='Men']")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("a[aria-label='Nike Homepage']")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


//        driver.findElement(By.cssSelector("a[aria-label='Men']")).
//
//        driver.findElement(By.cssSelector("a[data-path='sign up for email']")).click();
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
////        driver.findElement(By.cssSelector(".nike-unite-text-input.emailAddress.nike-unite-component.empty"))
////                .sendKeys("gogo.go@go.by");
////        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.quit();
    }
}
