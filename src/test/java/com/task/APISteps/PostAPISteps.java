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





public class PostAPISteps extends CommonMethods{
	private static RequestSpecification request;
	private Response response;

@Given("User post Api")
public void user_post_Api() {
	request = given().header("Content-Type", "application/json");
	request.body(readJson(APIConstants.POST_JSON_FILEPATH));

   
}

@When("User retrieves response for Post API")
public void user_retrieves_response_for_Post_API() {
	response = request.when().post(APIConstants.USER_POST_URI);
	response.prettyPrint();
}

@Then("status code is {int} for PostAPI")
public void status_code_is_for_PostAPI(Integer int1) {

	response.then().assertThat().statusCode(int1);

   
}

@Then("Validates title was created")
public void validates_title_was_created() {
	response.then().body("title", equalTo("Hasan Sinan Task"));
    
}
	

	
}