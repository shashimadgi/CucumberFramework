package stepdefinitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;

public class SendOTPStepDefinitions {
    
    private Response response;

    @Given("I am on the login page")
    public void iAmOnLoginPage() {
        // Implementation to navigate to the login page
    }

    @When("I send OTP for game {string}")
    public void iSendOTPForGame(String gameId) {
        RequestSpecification request = given()
                .header("gameid", gameId)
                .contentType("application/json")
                .body("{\"phone\": \"+917243464979\", \"isSignup\": true, \"deviceInfo\": {\"APP_TYPE\": \"android\", \"DeviceData\": {\"deviceUID\": {\"_h\": 0, \"_i\": 3, \"_j\": {\"_h\": 0, \"_i\": 1, \"_j\": \"36e27f877d1a7c24\", \"_k\": null}, \"_k\": null}, \"installReferrer\": {\"_h\": 0, \"_i\": 1, \"_j\": \"utm_source=google-play&utm_medium=organic\", \"_k\": null}, \"carrier\": {\"_h\": 0, \"_i\": 1, \"_j\": \"\", \"_k\": null}, \"manufacturer\": {\"_h\": 0, \"_i\": 1, \"_j\": \"realme\", \"_k\": null}, \"ipAddress\": {\"_h\": 0, \"_i\": 1, \"_j\": \"192.168.57.66\", \"_k\": null}, \"model\": \"RMX3501\", \"firstInstallTime\": {\"_h\": 0, \"_i\": 1, \"_j\": 1689061417338, \"_k\": null}, \"androidVersion\": {\"_h\": 0, \"_i\": 1, \"_j\": 31, \"_k\": null}, \"width\": 360, \"height\": 724, \"hasNotch\": false}}}");
        response = request.post("https://api.getstan.app/api/v1/auth/otp/send");
    }

    @Then("OTP should be sent successfully")
    public void otpShouldBeSentSuccessfully() {
        response.then().statusCode(200);
        System.out.println(response.getBody().asString());
    }
}
