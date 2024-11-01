package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class AdminPage extends BasePage {

    private By adminTab = By.id("menu_admin_viewAdminModule");
    private By addButton = By.id("btnAdd");


    private By userRoleDropdown = By.id("systemUser_userType"); // Dropdown for User Role
    private By employeeNameField = By.id("systemUser_employeeName_empName"); // Employee Name field
    private By statusDropdown = By.id("systemUser_status"); // Dropdown for Status
    private By usernameField = By.id("systemUser_userName"); // Username field
    private By passwordField = By.id("systemUser_password"); // Password field
    private By confirmPasswordField = By.id("systemUser_confirmPassword"); // Confirm Password field
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
        // Select User Role
        Select roleSelect = new Select(driver.findElement(userRoleDropdown));
        roleSelect.selectByVisibleText(userRole); // Select user role from dropdown

        // Enter Employee Name
        driver.findElement(employeeNameField).sendKeys(employeeName);

        // Select Status
        Select statusSelect = new Select(driver.findElement(statusDropdown));
        statusSelect.selectByVisibleText(status); // Select status from dropdown

        // Enter Username
        driver.findElement(usernameField).sendKeys(username);

        // Enter Password
        driver.findElement(passwordField).sendKeys(password);

        // Enter Confirm Password
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
