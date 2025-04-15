package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitHelper {

    public WebDriver driver;

    public WaitHelper(WebDriver driver) {

        this.driver = driver;
    }

 // for the normal @finby or other normal xpath
    public void WaitForElement(WebElement element, long timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

// for the config.properties file reader wait
    public WebElement WaitForElement1(By locator, long timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
        // Wait until the element is visible and return the WebElement
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }


    //for the excel sheet xpath
    public WebElement WaitForElement2(WebElement element, int timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }


    //for the Displaying the card details wait
    public WebElement WaitForElement3(By locator, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }


}
