package com.task.steps;

import java.util.List;


import org.openqa.selenium.WebElement;
import com.task.utils.CommonMethods;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FiltersStep extends CommonMethods {
	@When("I Select Username Equals option")
	public void i_Select_Username_Equals_option() {
		selectDdValue(user.userDD, "Equals");

	}

	@When("I  input username")
	public void i_input_username() {
		sendText(user.inputUserName, "Hasan");

	}

	@When("I Select Email Contains option")
	public void i_Select_Email_Contains_option() {
		selectDdValue(user.emailDD, "Contains");
	}

	@When("I  input {string}")
	public void i_input(String string) {
		sendText(user.inputEmail, string);

	}

	@When("I select date from the From Calender")
	public void i_select_date_from_the_From_Calender() {
		click(user.from);
		String month = user.month.getText();
		String year = user.year.getText();
		if (!(month.equals("June") && year.equals("2020"))) {
			click(user.prev);
		}
		List<WebElement> days = user.fromDate;
		for (WebElement day : days) {
			String date = day.getText();
			if (date.equals("12")) {
				click(day);
			}

		}

	}

	@When("I select date from the To Calender")
	public void i_select_date_from_the_To_Calender() {
		click(user.to);
		String month = user.month.getText();
		String year = user.year.getText();
		if (!(month.equals("July") && year.equals("2020"))) {
			click(user.next);
		}
		List<WebElement> days = user.fromDate;
		for (WebElement day : days) {
			String date = day.getText();
			if (date.equals("22")) {
				click(day);
			}

		}

	}

	@When("I click Filter Button")
	public void i_click_Filter_Button() {
		click(user.filterBtn);

	}

	@Then("I verify Users from the result table")
	public void i_verify_Users_from_the_result_table() {
		List<WebElement> resultTable=user.resultRows;
		for (WebElement table : resultTable) {
			String data=table.getText();
			if (data.equals("Hasan")) {
				System.out.println("New user is on the result table ");
			}else {
				
				System.err.println("New user is not on the result table ");
			}
			
		}

	}

}
