@OthersTab
Feature: selenium easy website
  I want to use this template for my feature file2222222222222
  Background:
      Given I login to the application P
    	And I click on the Progress tab
    	
  Scenario: 01 Test progress bar jquery
   And I click on JQuery Download Progress bars option
   And I click on start download button
   Then I check if current progress is shown
   Then I verify if download complete is shown and how much time it took to download
   And I click on close download button 
   Then I verify if download widndow is closed
   
     Scenario: 02 testing cancel download button 
   And I click on JQuery Download Progress bars option
   And I click on start download button
   Then I check if current progress is shown
   Then I click on cancel download button
   Then I verify if download widndow is closed
   
     Scenario: 03 Test progress bar bootstrap
   And I click on Bootstrap Download Progress bars option
   And I click on download button
   Then I check if progress percentage is shown
   Then I verify if Hundred percent is shown and how much time it took to download
 
   
   