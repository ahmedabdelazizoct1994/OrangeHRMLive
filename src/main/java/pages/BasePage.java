package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WebDriverManagerUtil;

import java.time.Duration;

    public class BasePage {
        protected WebDriver driver;
        private WebDriverWait wait;


        public BasePage(WebDriver driver) {
            this.driver = driver;
            this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); }


    // Utility method to find an element with a wait
    protected WebElement findElement(By locator) {
          return driver.findElement(locator);
        //return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}