@task
Feature: Filters  User

	@regression
	Scenario: Filters for New User
		Given I Navigate to Users Page
		 When I Select Username Equals option
		 And I  input username
		 And I Select Email Contains option
		 And I  input "@"
		 And I select date from the From Calender
		 And  I select date from the To Calender
		 And I click Filter Button
		 Then I verify Users from the result table
