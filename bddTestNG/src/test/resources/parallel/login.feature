Feature: The Internet login

  Background: 
    Given user is on the the internet page

  @RegressionTest
  Scenario: The Internet initial login
    ##Given when user is on the the internet page
    When title of login page is The Internet
    Then user enters "tomsmith" and "SuperSecretPassword!"
    And user clicks on login button first
    Then user lands on home page

  @RegressionTest @SmokeTest
  Scenario Outline: Invalid/Wrong username on login
    #Given when user is on the-internet page
    When user enters correct <username> but <password>
    And user clicks on login button second
    Then user login fail with error message at the top one

    Examples: 
      | username | password            |
      | qabhiw   | SuperSecretPassword! |
	
	@SmokeTest
  Scenario Outline: Wrong password on login
    #Given when user is on the-internet page
    When user enters wrong <username> and <password>
    And user clicks on login button third
    Then user login fail with error message at the top two

    Examples: 
      | username | password  |
      | tomsmith | wrongpass |
