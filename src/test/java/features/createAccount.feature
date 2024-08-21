Feature: Creating account on Luma

  Scenario: Verify that new user can create account successfully with proper details
    Given User is at Singup page of Luma
    When User enters all the details and Clicked on Create account buttom
    Then User's account get created and message displayed.

