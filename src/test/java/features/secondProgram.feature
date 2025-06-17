Feature: Application Login

  Background:
    When launch the browser from config variables
    And hit the home page url of banking site


  @RegressionTest1  @NetBanking
  Scenario: User Page default login

    Given User is on NetBanking landing page
    When User login into application with "Jin" and Password 1234
    Then Home Page is displayed
    And Cards are displayed


  @SmokeTest @RegressionTest1 @Mortgage
  Scenario Outline: Mortgage User Page default login
    Given User is on NetBanking landing page
    When User login into application with "<Username>" and Password "<Password>"
    Then Home Page is displayed
    And Cards are displayed

    Examples:
      | Username  | Password |
      | debituser | hello12  |
      | crediuser | lpo213   |


