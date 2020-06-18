Feature: Post API
@API
Scenario: Post Api Testing
Given User post Api
When User retrieves response for Post API
Then status code is 201 for PostAPI
Then  Validates title was created


