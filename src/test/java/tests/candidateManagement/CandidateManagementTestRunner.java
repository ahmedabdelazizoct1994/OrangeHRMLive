package tests.candidateManagement;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/tests/candidateManagement/candidateManagement.feature",
        glue = "tests",
        plugin = {"pretty", "html:target/cucumber-reports.html"})
public class CandidateManagementTestRunner extends AbstractTestNGCucumberTests {
}



