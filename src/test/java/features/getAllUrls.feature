Feature: To get all The URLS at a particular Table
  @SCC
 Scenario Outline: Get all the usrls in list
    Given I login at SCC Portal
    And Navigate to Handouts
    And Select the '<semester>'
    Then I get all the links for downloads and download files
   Examples:
   |semester       |
#   |Semester I     |
#   |Semester II    |
#   |Semester III   |
   |Semester IV    |