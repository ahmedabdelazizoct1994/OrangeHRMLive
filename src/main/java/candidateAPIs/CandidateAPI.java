package candidateAPIs;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utils.ConfigReader;

import static io.restassured.RestAssured.given;
import java.util.HashMap;
import java.util.Map;

public class CandidateAPI {

    // Base URL for OrangeHRM
    private static final String BASE_URL = "https://opensource-demo.orangehrmlive.com/";

    // Login credentials
    private static final String USERNAME = ConfigReader.getProperty("username");
    private static final String PASSWORD = ConfigReader.getProperty("password");

    // Authentication token, assuming we need it for authorization
    private String authToken;

    // Step 1: Authenticate and obtain a session token
    public void authenticate() {
        Map<String, String> credentials = new HashMap<>();
        credentials.put("username", USERNAME);
        credentials.put("password", PASSWORD);

        Response response = given()
                .baseUri(BASE_URL)
                .contentType(ContentType.JSON)
                .body(credentials)
                .post("/auth");

        authToken = response.jsonPath().getString("token"); // Assuming a token is returned
    }

    // Step 2: Add a Candidate
    public void addCandidate(String firstName,String lastName,String email,String jobTitle) {
        // Candidate data
        Map<String, Object> candidateData = new HashMap<>();
        candidateData.put("firstName", firstName);
        candidateData.put("lastName", lastName);
        candidateData.put("email", email);
        candidateData.put("jobTitle",jobTitle);

        Response response = given()
                .baseUri(BASE_URL)
                .header("Authorization", "Bearer " + authToken)
                .contentType(ContentType.JSON)
                .body(candidateData)
                .post("/api/v1/recruitment/candidates");

        if (response.statusCode() == 201) {
            System.out.println("Candidate added successfully");
        } else {
            System.out.println("Failed to add candidate: " + response.getBody().asString());
        }
    }

    public void deleteCandidate(String candidateId) {
        Response response = given()
                .baseUri(BASE_URL)
                .header("Authorization", "Bearer " + authToken)
                .contentType(ContentType.JSON)
                .delete("/api/v1/recruitment/candidates/" + candidateId);

        if (response.statusCode() == 200) {
            System.out.println("Candidate deleted successfully");
        } else {
            System.out.println("Failed to delete candidate: " + response.getBody().asString());
        }
    }

}
