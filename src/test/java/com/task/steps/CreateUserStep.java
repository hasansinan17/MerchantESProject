package com.task.steps;

import org.junit.Assert;

import com.task.utils.CommonMethods;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CreateUserStep extends CommonMethods{
	@Given("I Navigate to Users Page")
	public void i_Navigate_to_Users_Page() {
	  click(dash.linkUsers);
	}

	@Given("I click New User Button")
	public void i_click_New_User_Button() {
		click(user.linkNewUser);
	   
	}

	@When("I add {string}, {string}  and {string}")
	public void i_add_and(String name, String pass, String email) {
		sendText(newUser.userName, name);
		sendText(newUser.password, pass);
		sendText(newUser.email, email);
	}

	@When("I click Create User Button")
	public void i_click_Create_User_Button() {
		click(newUser.createUserBtn);
	  
	}

	@Then("I verify Users has been succesfully created")
	public void i_verify_Users_has_been_succesfully_created() {
		String actualMsg=user.confMessage.getText();
		String expectedMsg="User was successfully created.";
		Assert.assertEquals("User is NOT created",expectedMsg,actualMsg);
	    
	}
	
}
