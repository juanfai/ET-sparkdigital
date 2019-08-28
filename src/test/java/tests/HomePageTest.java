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
    public void login() {
        // Create wait time lapse
        WebDriverWait wait = new WebDriverWait(driver, 10);

        // Find login button
        driver.findElement(By.className("login-button")).click();

        // Handle windows
        String mainWindow=driver.getWindowHandle();

        Set<String> windowsSet = driver.getWindowHandles();
        Iterator<String> windowsIterator = windowsSet.iterator();

        while(windowsIterator.hasNext()){
            String popUpWindow = windowsIterator.next();

            if(!mainWindow.equalsIgnoreCase(popUpWindow)){
                // Switch to pop up window
                driver.switchTo().window(popUpWindow);

                // Complete login form
                driver.findElement(By.name("identifier")).sendKeys("jfaisal");
                driver.findElement(By.id("identifierNext")).click();
                WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
                passwordInput.sendKeys("01Benjamin");
                WebElement passwordNextButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("passwordNext")));
                passwordNextButton.click();
                driver.switchTo().window(mainWindow);
            };
        };
    };
};