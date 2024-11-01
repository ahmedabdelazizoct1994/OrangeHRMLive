package tests.userManagement;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ConfigReader;
import utils.WebDriverManagerUtil;

public class BaseTest {
    protected WebDriver driver;

    public void setUp() {
        driver = WebDriverManagerUtil.getDriver();
        driver.get(ConfigReader.getProperty("url"));
    }


    @AfterMethod
    public void tearDown() {
        WebDriverManagerUtil.quitDriver();
    }
}
