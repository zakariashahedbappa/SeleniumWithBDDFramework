Feature: Verify job posting is working as expected

  Scenario: user can search job and verify its not return zero
    Given User open the browser and open the "https://risk.lexisnexis.co.uk/"
    When User click on the About Us from top menu
    And when user click on the career option
    And User switch to the career tab
    And User click on the search job button
    And User search for the job "automation tester"
    And click on the search button
    Then verify the search results not zero


