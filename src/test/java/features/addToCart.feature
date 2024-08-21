@addtocart
Feature: User should be able to login and search items and able to add them into card.

  Scenario: Validate user with valid user id and password is able to login and search any items and add to cart
    Given User is at login page
    When User enter username and password and click on submit
    Then Home page is opened and search box is open
#    When User enters item name in search button and click on search button
#    Then Items deatils are open with option to add card
#    When user clicked on add to cart
#    Then Items are added to cart.