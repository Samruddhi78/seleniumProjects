@ListBoxTab
Feature: selenium easy website List box tab
  I want to use this template for my feature file
  Background:
      Given I login to the application L
    	And I click on the List Box tab
    	
    
  
 Scenario: 01 testing right shift button 
    And I click on Bootstrap list box option
    And I click on first element of left list
    And I click on shift right button
    Then I verify if the first element is shifted to right list
    But It is not in left list 

 
  Scenario: 02 testing left shift button after multiple selects
    And I click on Bootstrap list box option
    And I click on first element of right list
    And I click on third element of right list
    And I click on fourth element of right list
    And I click on shift left button
    Then It is not in right list
    And I verify if three elements are in left list  
 
 Scenario: 03  Test select all button
 And I click on Bootstrap list box option
 And I click on select all button of right list
 When I click on shift left button
 And I check if right list is empty 
 
  