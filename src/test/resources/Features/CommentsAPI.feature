Feature: Comments API
@API
Scenario: Comments Api Testing
Given User comments Api
When User retrieves response for Comments API
Then status code is 201 for CommentsAPI
Then  Validates name  was created


