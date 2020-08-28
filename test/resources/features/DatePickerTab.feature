@DatePickerTab
Feature: selenium easy website List box tab
  I want to use this template for my feature file
  Background:
      Given I login to the applicationD
    	And I click on the Date pickers tab
    	
   Scenario: 01 Testing Today button
   And I click on Bootstrap Date Picker option
   And I click on select date button
   And I click on Today butoon
   Then I verify if today's date is selected in select box
   
      
   Scenario: 03 testing date picker for previous button
   And I click on Bootstrap Date Picker option
   And I click on select date button
   And I select date by clicking privious button
   Then I verify if date is visible and has month july 
   
   Scenario: 02 Testing clear button
   And I click on Bootstrap Date Picker option
   And I click on select date button
   And I click on  third date
   And I verify if its visible on select box
   And I click on select date button
   When I click on clear button
   Then I verify if dd/mm/yyyy


   Scenario: 04 Testing if start date is less than end date
      And I click on Bootstrap Date Picker option
   And I select date thirteen as a start date
   Then I verify if end date and start date is same
   When I select end date as ten
   Then I verify if end date and start date is same
