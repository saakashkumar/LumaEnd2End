Feature: Creating account on Luma

  Scenario Outline: Verify that new user can create account successfully with proper details
    Given '<User>' is at Singup page of Luma
    When User enters all the details and Clicked on Create account buttom
    Then User's account get created and message displayed.
    Examples:
    |User    |
    |Admin   |
#    |Customer|
