@tInputFormTab
Feature: Title of your feature
  I want to use this template for my feature file

  Background: 
    Given login to the applicationI
    And I click on Input Forms tab

  Scenario Outline: 01 Test Two Input Fields for integers
    And I click on Simple Form Demo option
    And I type <Enter a> in Enter a and <Enter b> in Enter b integer
    And I click on Get Total
    Then I verify if the total is correct for <Enter a>  <Enter b> integers

    Examples: 
      | Enter a | Enter b |
      |    5670 |     430 |
      |    4563 |      50 |

  Scenario Outline: 02 Test Two Input Fields for strings
    And I click on Simple Form Demo option
    And I type <Enter a> in Enter a and <Enter b> in Enter b string
    And I click on Get Total
    Then I verify if the total is correct for <Enter a>  <Enter b> strings

    Examples: 
      | Enter a | Enter b |
      | hellow  | world   |
      | tesing  | testing |

  Scenario Outline: 03 Test Two Input Fields for floats
    And I click on Simple Form Demo option
    And I type <Enter a> in Enter a and <Enter b> in Enter b floats
    And I click on Get Total
    Then I verify if the total is correct for <Enter a>  <Enter b> floats

    Examples: 
      | Enter a | Enter b |
      |   80.90 |   60.90 |
      |   40.60 |    50.8 |

  Scenario: 04 Test checkbox and check all button
    And I click on checkbox Demo option
    And I check Click on this check box checkbox
    Then I verify if success msg is shown
    And I uncheck check box checkbox
    Then I verify if success msg is not shown
    And I cick on check all button
    Then I verify if all four options are checked

  Scenario Outline: 05 test radio buttons
    And I click on Radio button Demo option
    And I select <sex> radio button and <Age group> radio button
    When I click on Get Values button
    Then I verify if <sex> and <Age group> is correct

    Examples: 
      | sex    | Age group |
      | Female | 0 to 5    |
      | Male   | 5 to 15   |

  Scenario: 06 Test multi select list demo
    And I click on dropdown demo
    And I select three cities
    And I click on first selected
    Then I check if its city1
    And I click on  get all selected
    Then I check if its three cities

  Scenario: 07 test select multiple values in jquery dropdown
    And I click on jquery dropdown
    And I click on select state option
    And I select city1 city2
    And I deselect city1
    Then I verify if only one city is selected
