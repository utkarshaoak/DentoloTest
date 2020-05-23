Feature: Openweather Features


  @EndToEnd1 @EndToEnd @test
  Scenario Outline: Verify user should be able to navigate to the site and fill data on Tarifauswahl page
    Given I navigate to the faircare registration
    When I select tariff
      | tariff_option  |
      | <tariffOption> |
    When I select a date of birth
      | Tag   | Monat   | Jahr   |
      | <day> | <month> | <year> |
    Then I click on weiter and I verify I system should navigate to Vertragsangaben page
    And I select Anrede, fill the data in Vorname and Nachname
      | Vorname  | Nachname |
      | Utkarsha(+) | Oak      |
    And fill the details in policy details
      | Vorname  | Nachname | Tag | Monat  | Jahr | Email                  | Tel_no         | street_name | street_no | postcode_5 | postcode_name |
      | Utkarsha | Oak      | 1.  | Januar | 2002 | utkarsha.oak@gmail.com | 176 379 69 519 | testt       | 5         | 12345      | Homburg       |
    And I will add IBAN no and cleck on weiter
      | IBAN                        |
      | DE89 3704 0044 0532 0130 00 |
    And I select insurance coverage
    Then I apply for insurance and I verify the insurance has been applied successfully
    Examples:
      | tariffOption       | day | month  | year |
      | Zahnschutz Komfort | 1.  | Januar | 2005 |
      | Zahnschutz Premium | 2.  | April  | 2007 |






