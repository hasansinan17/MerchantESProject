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





public class CommentsAPISteps extends CommonMethods{
	private static RequestSpecification request;
	private Response response;
	@Given("User comments Api")
	public void user_comments_Api() {
		request = given().header("Content-Type", "application/json");
		request.body(readJson(APIConstants.COMMENTS_JSON_FILEPATH));
	 
	}

	@When("User retrieves response for Comments API")
	public void user_retrieves_response_for_Comments_API() {
		response = request.when().post(APIConstants.COMMENTS_URI);
		response.prettyPrint();
	   
	}

	@Then("status code is {int} for CommentsAPI")
	public void status_code_is_for_CommentsAPI(Integer int1) {
		response.then().assertThat().statusCode(int1);
	 
	}

	@Then("Validates name  was created")
	public void validates_name_was_created() {
		response.then().body("name", equalTo("hasan sinan1"));
	}

	

	

   


}
	

	
