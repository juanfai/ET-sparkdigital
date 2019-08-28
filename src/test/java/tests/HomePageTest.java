package tests;

import java.util.Set;
import java.util.Iterator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.GoogleAuth;

public class HomePageTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("https://estimation-tool-qa.sparkdigital.rocks/");
    };

    @AfterMethod
    public void tearDown() {
        driver.close();
    };

    @Test
    public void test1() {
        GoogleAuth googleAuth = new GoogleAuth(driver);
        googleAuth.logIn("tu usuario de spark", "el password");
    }

    @Test
    public void test2() {
        GoogleAuth googleAuth = new GoogleAuth(driver);
        googleAuth.logIn("tu usuario de spark", "el password");
    }
}