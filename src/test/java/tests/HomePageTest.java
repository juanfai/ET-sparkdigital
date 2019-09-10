package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.GoogleAuth;
import pages.HomePage;

public class HomePageTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("https://estimation-tool-qa.sparkdigital.rocks/");
        GoogleAuth googleAuth = new GoogleAuth(driver);
        googleAuth.logIn("estimationtool", "sparkdigital");
    };

    @AfterMethod
    public void tearDown() {
        driver.close();
    };

    @Test
    public void createProject() {
        HomePage homePage = new HomePage(driver);
        
        homePage.addProject();
    }
}