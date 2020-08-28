@OthersTab
Feature: selenium easy website222222222
  I want to use this template for my feature file2222222222222
  Background:
      Given I login to the applicationO
    	And I click on the Others tab
  
 Scenario: 01 Test drag and drop option
    And I click on Drag and Drop option
    And I check if the drag and drop table is present
    And I drag Draggable1 and drop it in drop here box
    But it is not in left list 
    Then I verify if the Draggable1 is in droped item list box
    But it is not in Items to drag box
    Then I verify if both the items are in item list box
 
 Scenario: 02  test get new user option
 And I click on Dynamic Data Loading
 When I click on Get New User button
 And I check if Loading is shown and how long it takes to load data
 Then I verify if all the deatils are available after loading  
 
 
  