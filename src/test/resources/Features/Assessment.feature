Feature: Assessment
  Scenario:Traveloka assessment
    Given Open URL "https://www.traveloka.com/"
    And Click on Navigation Menu Transports
    And Click on Flights
    And On Flight Search Form, click on Round Trip checkbox
    And Click on Search button
    And Wait until the page is fully loaded
    And Click on Change Search button
    And Change From text field to "LBJ"
    And Change To text field to "LHR"
    When Click on Search button
    And Wait until the page is fully loaded
    Then Verify that Error state: "No Flight Available" is displayed

