package stepdefinitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;

public class VerifyOTPStepDefinitions {
    
    private Response response;

    @Given("I am on the OTP verification page")
    public void iAmOnOTPVerificationPage() {
        // Implementation to navigate to the OTP verification page
    }

    @When("I verify OTP {string} for game {string}")
    public void iVerifyOTPForGame(String otp, String gameId) {
        RequestSpecification request = given()
                .header("gameid", gameId)
                .contentType("application/json")
                .body("{\"phone\": \"+919999999999\", \"otp\": \"" + otp + "\", \"deviceInfo\": {\"APP_TYPE\": \"android\", \"DeviceData\": {\"deviceUID\": \"36e27f877d1a7c25\"}}}");
        response = request.post("https://api.getstan.app/api/v4/verify/otp");
    }

    @Then("OTP should be verified successfully")
    public void otpShouldBeVerifiedSuccessfully() {
        response.then().statusCode(200);
        System.out.println(response.getBody().asString());
    }
}
