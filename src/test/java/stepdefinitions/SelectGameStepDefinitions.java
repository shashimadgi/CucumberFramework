package stepdefinitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;

public class SelectGameStepDefinitions {
    
    private Response response;

    @Given("I am on the game selection page")
    public void iAmOnGameSelectionPage() {
        // Implementation to navigate to the game selection page
    }

    @When("I select game {string}")
    public void iSelectGame(String gameId) {
        RequestSpecification request = given()
                .header("Accept", "application/json, text/plain, */*")
                .header("Content-Type", "application/json")
                .header("gameid", gameId)
                .header("AppVersion", "110")
                .header("Platform", "android")
                .header("SID", "1689061440422-74140")
                .header("TS", "undefined")
                .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJiZ21pUHJvZmlsZUlkIjo0Mzc5MjksImV4cCI6MTcwNDk2NDE5NiwiZnJlZWZpcmVQcm9maWxlSWQiOjQzNzkzOCwiaWF0IjoxNzAyMzcyMTk2LCJpZCI6NTA5NjIxfQ.nUPsvMVt3-zp43326--rMREXqc60uIV6YqZTkulRAuM");
        response = request.post("https://api.getstan.app/api/v4/select/game");
    }

    @Then("Game should be selected successfully")
    public void gameShouldBeSelectedSuccessfully() {
        response.then().statusCode(200);
        System.out.println(response.getBody().asString());  
    }
}
