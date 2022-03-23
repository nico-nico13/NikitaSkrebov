Feature: Logs on Different Elements Page display and correspond with checkbox status

  Scenario: Different Elements Page Logs display test

    Given I open JDI GitHub site
    And I login as user "Roman Iovlev"
    And I click on "Service" button in Header
    And I click on "Different Elements" button in Service dropdown
    When I select 'Wind' and 'Water' checkboxes
    And I select 'Selen' radio-checkbox
    And I select 'Yellow' in dropdown
    Then 1 log row has "Wind: condition changed to true" text in log section
    And 1 log row has "Water: condition changed to true" text in log section
    And 1 log row has "metal: value changed to Selen" text in log section
    And 1 log row has "Colors: value changed to Yellow" text in log section