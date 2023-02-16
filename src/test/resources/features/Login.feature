@test
Feature: Login scenarios

#  Scenario Outline: Login with invalid user name
#    When I enter username as "<username>"
#    And I enter password as "<password>"
#    And I login
#    Then login should fail with an error "<err>"
#    Examples:
#      | username | password | err |
#      | invalidUsername | secret_sauce | Username and password do not match any user in this service. |
#
#  Scenario Outline: Login with invalid password
#    When I enter username as "<username>"
#    And I enter password as "<password>"
#    And I login
#    Then login should fail with an error "<err>"
#    Examples:
#      | username | password | err |
#      | standard_user | invalidPassword | Username and password do not match any user in this service. |

  Scenario Outline: Login with valid user name and password
    When I click on Get Started
    And I enter telephone number as "<telephoneNum>"
    And I click on Login with Password
    And I enter the password as "<passwd>"
    And I click on Login
    Then I should see home page with title "<title>"
    Examples:
      | telephoneNum | passwd | title |
      | 8056310010 | password | PRODUCTS |
      | 8056310010 | password | PRODUCTS |