package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class AdminPage extends BasePage {

    private By adminTab = By.id("menu_admin_viewAdminModule");
    private By addButton = By.id("btnAdd");


    private By userRoleDropdown = By.id("systemUser_userType");
    private By employeeNameField = By.id("systemUser_employeeName_empName");
    private By statusDropdown = By.id("systemUser_status");
    private By usernameField = By.id("systemUser_userName");
    private By passwordField = By.id("systemUser_password");
    private By confirmPasswordField = By.id("systemUser_confirmPassword");
    private By saveButton = By.id("btnSave");
    private By recordCount = By.id("resultTable");


    private By searchField = By.id("searchSystemUser_userName");
    private By searchButton = By.id("searchBtn");
    private By deleteButton = By.id("btnDelete");


    public AdminPage(WebDriver driver) {
        super(driver);
    }

    public void clickAdminTab() {
        driver.findElement(adminTab).click();
    }
    public int getRecordCount() {
        String text = driver.findElement(recordCount).getText();
        return Integer.parseInt(text.split(" ")[0]);
    }
    public void clickAddButton() {
        driver.findElement(addButton).click();
    }

    public void fillRequiredData(String userRole, String employeeName, String status, String username, String password) {

        Select roleSelect = new Select(driver.findElement(userRoleDropdown));
        roleSelect.selectByVisibleText(userRole);


        driver.findElement(employeeNameField).sendKeys(employeeName);


        Select statusSelect = new Select(driver.findElement(statusDropdown));
        statusSelect.selectByVisibleText(status);


        driver.findElement(usernameField).sendKeys(username);


        driver.findElement(passwordField).sendKeys(password);


        driver.findElement(confirmPasswordField).sendKeys(password);
    }

    public void clickSaveButton() {
        driver.findElement(saveButton).click();
    }

    // Method to search for a user by username
    public void searchUser(String username) {
        driver.findElement(searchField).sendKeys(username);
        driver.findElement(searchButton).click();
    }

    // Method to delete the user
    public void deleteUser(String property) {
        driver.findElement(deleteButton).click();
    }}
