package tests.userManagement;

 import io.cucumber.testng.AbstractTestNGCucumberTests;
 import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/tests/userManagement/userManagement.feature",
        glue = "UserManagementStepDef",
        plugin = {"pretty", "html:target/cucumber-reports"},
        monochrome = true
)
public class UserManagementTestRunner extends AbstractTestNGCucumberTests {
}
