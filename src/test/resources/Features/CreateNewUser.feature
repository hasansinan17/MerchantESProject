@task
Feature: Create New User
  @smoke
  Scenario: Create User
    Given I Navigate to Users Page
    And I click New User Button
    When I add "Hasan", "Sinan"  and "sinanhasan@gmail.com"
    And I click Create User Button
    Then I verify Users has been succesfully created
    
