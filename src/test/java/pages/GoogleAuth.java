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
    private By loginButton;
    private By nameInput;
    private By nameNextButton;
    private By passwordInput;
    private By passwordNextButton;

    public GoogleAuth(WebDriver driver) {
        this.driver = driver;
        loginButton = By.className("login-button");
        nameInput = By.name("identifier");
        nameNextButton = By.id("identifierNext");
        passwordInput = By.name("password");
        passwordNextButton = By.id("passwordNext");
    }
    
    public void logIn(String user, String password) {
    // Create wait time lapse
        WebDriverWait wait = new WebDriverWait(driver, 10);// POR QUE ME LO SUBRAYA ASI?

        // Find login button
        driver.findElement(loginButton).click();

        // Handle windows
        String mainWindow = driver.getWindowHandle();
        Set<String> windowsSet = driver.getWindowHandles();
        Iterator<String> windowsIterator = windowsSet.iterator();

        while(windowsIterator.hasNext()){
            String popUpWindow = windowsIterator.next();

            if(!mainWindow.equalsIgnoreCase(popUpWindow)){
                // Switch to pop up window
                driver.switchTo().window(popUpWindow);

                // Complete login form
                driver.findElement(nameInput).sendKeys(user);
                driver.findElement(nameNextButton).click();
                WebElement passwordInputWait = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput));
                passwordInputWait.sendKeys(password);
                WebElement passwordNextButtonWait = wait.until(ExpectedConditions.elementToBeClickable(passwordNextButton));
                passwordNextButtonWait.click();
                driver.switchTo().window(mainWindow);// POR QUE SE CIERRA LA MAINWINDOW????
            }
        }
    }
}
