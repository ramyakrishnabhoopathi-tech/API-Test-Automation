package stepdefinitions;

import assertions.ResponseAssertions;
import utils.Config;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserSteps {

    Response response;

    @Given("I use the REST API")
    public void i_use_the_rest_api() {

        RestAssured.baseURI =
                Config.getProperty("baseUrl");
    }

    @When("User retrieves user data")
    public void user_retrieves_user_data() {

        response =
                given()
                        .header("x-api-key", "free_user_3DReBygwEYwWVemfGcnrApTfX7R")
                        .when()
                        .get("/2");

        response.prettyPrint();
    }

    @Then("Print response status code")
    public void print_response_status_code() {

        System.out.println("Status Code : " + response.statusCode());
        ResponseAssertions.validateStatusCode(response,200);
    }

    @Then("Print first name from response")
    public void print_first_name_from_response() {

        String firstName =
                response.jsonPath().getString("data.first_name");

        System.out.println("First Name : " + firstName);
        ResponseAssertions.printFirstName(response);
    }

    @Then("Print avatar URL from response")
    public void print_avatar_url_from_response() {

        String avatar =
                response.jsonPath().getString("data.avatar");

        System.out.println("Avatar URL : " + avatar);
        ResponseAssertions.printAvatar(response);
    }
    @Then("Update the email address")
    public void update_the_email_address() {

        String requestBody =
                "{ \"email\": \"ramya@test.com\" }";

        Response updateResponse =
                given()
                        .header("x-api-key", "free_user_3DReBygwEYwWVemfGcnrApTfX7R")
                        .header("Content-Type", "application/json")
                        .body(requestBody)
                        .when()
                        .put("/2");

        System.out.println(updateResponse.asPrettyString());
    }

    @Then("Delete the last name")
    public void delete_the_last_name() {

        String requestBody =
                "{ \"last_name\": \"\" }";

        Response deleteResponse =
                given()
                        .header("x-api-key", "free_user_3DReBygwEYwWVemfGcnrApTfX7R")
                        .header("Content-Type", "application/json")
                        .body(requestBody)
                        .when()
                        .patch("/2");

        System.out.println(deleteResponse.asPrettyString());
    }
}
