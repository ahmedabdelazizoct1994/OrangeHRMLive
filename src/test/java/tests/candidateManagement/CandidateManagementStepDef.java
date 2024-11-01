package tests.candidateManagement;

import candidateAPIs.CandidateAPI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import utils.ConfigReader;

public class CandidateManagementStepDef {

    private CandidateAPI candidateAPI = new CandidateAPI();
    //   private String candidateId; // To store the candidate ID after addition

    @Given("I navigate to the OrangeHRM website")
    public void i_navigate_to_the_OrangeHRM_website() {
        candidateAPI.authenticate(); // Authenticate to obtain token
    }

    @When("I add a candidate with firstName {string},  lastName {string}, email {string} and jobTitle {string}")
    public void iAddACandidateWithFirstNameLastNameEmailAndJobTitle(String firstName, String lastName, String email, String jobTitle) {
        candidateAPI.addCandidate(ConfigReader.getProperty(firstName),
                ConfigReader.getProperty(lastName),
                ConfigReader.getProperty(email),
                ConfigReader.getProperty(jobTitle));
    }

//        @Then("I should see a success message for the candidate addition")
//        public void i_should_see_a_success_message_for_the_candidate_addition() {
//            Assert.assertNotNull(candidateId, "Candidate ID should not be null after adding a candidate.");
//            System.out.println("Candidate added successfully with ID: " + candidateId);
//        }

    @When("I delete the candidate with ID {string}")
    public void i_delete_the_candidate_with_ID(String id) {
        candidateAPI.deleteCandidate(ConfigReader.getProperty(id)); // Call the method to delete candidate
    }


//        @Then("I should see a success message for the candidate deletion")
//        public void i_should_see_a_success_message_for_the_candidate_deletion() {
//            System.out.println("Candidate deleted successfully");
//        }
}
