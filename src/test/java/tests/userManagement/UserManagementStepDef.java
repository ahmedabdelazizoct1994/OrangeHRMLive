package tests.userManagement;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.AdminPage;
import pages.LoginPage;
import utils.ConfigReader;

public class UserManagementStepDef extends BaseTest {
    LoginPage loginPage;
    AdminPage adminPage;
    @Before
    public void init() {
        setUp();
        loginPage = new LoginPage(driver);
        AdminPage adminPage = new AdminPage(driver);

    }

    private int initialRecordCount;
    private int updatedRecordCount;

    @Given("I enter the username {string}")
    public void iEnterTheUsername(String username) {

        loginPage.enterUsername(ConfigReader.getProperty(username));
    }

    @And("I enter the password {string}")
    public void iEnterThePassword(String password) {
        loginPage.enterPassword(ConfigReader.getProperty(password));
    }

    @When("I click on the login button")
    public void i_click_on_the_login_button() {
        loginPage.clickLoginButton();
    }

    @When("I click on the Admin tab on the left side menu")
    public void i_click_on_the_admin_tab_on_the_left_side_menu() {
        adminPage.clickAdminTab();
    }

    @Then("I get the number of records found")
    public void i_get_the_number_of_records_found() {
        initialRecordCount = adminPage.getRecordCount();
    }

    @When("I click on the add button")
    public void i_click_on_the_add_button() {
        adminPage.clickAddButton();
    }

    @When("I fill in the required data with role {string}, employee name {string}, status {string}, username {string}, password {string}")
    public void i_fill_in_the_required_data(String userRole, String employeeName, String status, String username, String password) {
        adminPage.fillRequiredData(ConfigReader.getProperty(userRole), ConfigReader.getProperty(employeeName),
                ConfigReader.getProperty(status), ConfigReader.getProperty(username), ConfigReader.getProperty(password));
    }

    @When("I click on the save button")
    public void i_click_on_the_save_button() {
        adminPage.clickSaveButton();
    }

    @Then("I verify that the number of records increased by 1")
    public void i_verify_that_the_number_of_records_increased_by_1() {
        updatedRecordCount = adminPage.getRecordCount();
        Assert.assertEquals(updatedRecordCount, initialRecordCount + 1, "Record count did not increase as expected");
    }

    @When("I search with the username {string} for the new user")
    public void iSearchWithTheUsernameForTheNewUser(String newUsername) {
        adminPage.searchUser(ConfigReader.getProperty(newUsername));
    }

    @When("I delete the new user")
    public void i_delete_the_new_user(String deletedUser) {
        adminPage.deleteUser(ConfigReader.getProperty(deletedUser));
    }

    @Then("I verify that the number of records decreased by 1")
    public void i_verify_that_the_number_of_records_decreased_by_1() {
        updatedRecordCount = adminPage.getRecordCount();
        Assert.assertEquals(updatedRecordCount, initialRecordCount, "Record count did not decrease as expected");
    }

}
