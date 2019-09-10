package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;

    private By addProjectButton;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        addProjectButton = By.cssSelector("button[aria-label=add]");
    }
        
    public void addProject() {
        driver.findElement(addProjectButton).click();
    }
}
