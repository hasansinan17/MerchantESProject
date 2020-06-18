Feature: USERS API
@API
Scenario: Users Api Testing
Given User USERS Api
When User retrieves response for Users API
Then status code is 201 for UsersAPI
Then  Validates username  was created


