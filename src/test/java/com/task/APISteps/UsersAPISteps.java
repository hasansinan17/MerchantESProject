package com.task.APISteps;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import com.task.utils.APIConstants;
import com.task.utils.CommonMethods;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;





public class UsersAPISteps extends CommonMethods{
	private static RequestSpecification request;
	private Response response;
	
	@Given("User USERS Api")
	public void user_USERS_Api() {
		request = given().header("Content-Type", "application/json");
		request.body(readJson(APIConstants.USERS_JSON_FILEPATH));
	}

	@When("User retrieves response for Users API")
	public void user_retrieves_response_for_Users_API() {
		response = request.when().post(APIConstants.USER_URI);
		response.prettyPrint();
	  
	}

	@Then("status code is {int} for UsersAPI")
	public void status_code_is_for_UsersAPI(Integer int1) {
		response.then().assertThat().statusCode(int1);
	}

	@Then("Validates username  was created")
	public void validates_username_was_created() {
		response.then().body("username", equalTo("Kaptan Sinan"));
	 
	}

	
}