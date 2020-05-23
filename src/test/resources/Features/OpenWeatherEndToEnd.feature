Feature: Openweather Features


  @EndToEnd1 @EndToEnd
  Scenario: Verify Open Weather all links working on home page
    Given I navigate to the Open Weather
    Then I verify all links are working on landing page
    And I verify all images are loading properly on landing page


  @EndToEnd2  @EndToEnd
  Scenario: Verify user is able to search weather for current city
    Given I navigate to the Open Weather
    When I search for the city "Mumbai"
    Then I should see searched city Result contains "Mumbai"

  @EndToEnd3  @EndToEnd
  Scenario: Verify user is able to search weather for current city
    Given I navigate to the Open Weather
    When I search for the city "nocityww"
    Then I should see searched city Result contains "Not found"

  @Test4  @EndToEnd @api
  Scenario Outline: Verify api of city is giving result
    Given I search for the city "<CityName>" with API
    Then I should see searched city Result contains "<CityName>"  in API
    Examples:
      | CityName |
      | London   |
      | Mumbai   |





