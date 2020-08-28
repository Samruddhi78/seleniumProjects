@AlertsModalsTab
Feature: selenium easy website
  I want to use this template for my feature file
  Background:
      Given login to the applicationA
    	And I click on Alert&Modals tab

Scenario: 01 Test Autoclosable alert bootstrap message
And I click on Bootstrap Alerts option
And I click on Autoclosable success alert
And I check if the alert box is visible 
Then I verify if the box closes after 5 sec

Scenario: 02 Test normal success message
And I click on Bootstrap Alerts option
And I click on normal success alert
And I check if the normal alert box is visible 
Then I verify if the box doesnt close after 5 sec
And I click on close button
Then I verify if normal alert box is close
  
 Scenario: 03 Test Bootstap multiple modals 
 And I click on Bootstrap Modals option
 And I click on Multiple Launch Modal button
 Then I verify is modal is open
 And I click on Launch Modal button on Modal
 Then I verify if second modal is open
 And I click on close button of current modal
 Then I verify if second modal is close and first modal is visible
 And I click on close button of fist modal
 Then I verify if first modal is closed
 
 Scenario: 04 test single window popup
 And I click on window popup modal option
 And I click on follow on twitter button
 Then I verify if new window is open for twitter login
 And I click on close button to close the window
 Then I verify if the new window is close
 