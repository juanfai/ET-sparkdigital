package pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleAuth {
    private WebDriver driver;
    public GoogleAuth(WebDriver driver) {
        this.driver = driver;
    }
    
    public void logIn(String user, String password) {
    // Create wait time lapse
        WebDriverWait wait = new WebDriverWait(driver, 10);// POR QUE ME LO SUBRAYA ASI?

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
                driver.findElement(By.name("identifier")).sendKeys(user);
                driver.findElement(By.id("identifierNext")).click();
                WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
                passwordInput.sendKeys(password);
                WebElement passwordNextButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("passwordNext")));
                passwordNextButton.click();
                driver.switchTo().window(mainWindow);// POR QUE SE CIERRA LA MAINWINDOW????
            }
        }
    }
}
