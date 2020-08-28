@TableTabSearch&Sort
Feature: selenium easy website
  I want to use this template for my feature file
  Background:
      Given I login to the application
    	And I click on the Table  tab
  

  Scenario: 01 Test 5 drop down options after clicking Table tab
    Then I verify five drop-down values are getting displayed

  Scenario: 02 Test page Table sort and search demo
    When I click on Table sort & search option
    Then I verify  Table sort and search demo page is getting displayed

  Scenario Outline: 03  Test search field of Table sort and search demo for keyword which is  present
  	 When I click on Table sort & search option
     And I enter <Keywords> in search field
     Then I verify if rows containing <Keywords> field are displayed

    Examples: 
      | Keywords          |
      | Software Engineer |
      | Accountant |
      | London            |

  Scenario Outline: 04 Test search field of Table sort and search demo for keyword which is not present
  	 When I click on Table sort & search option
    And I enter <Nkeywords> in search field
    Then I verify if No matching records found is displayed

    Examples: 
      | Nkeywords |
      | abdc      |
      | ohhh      |
      | helo wol  |


  Scenario Outline: 05 Test show entries drop down option
  	 When I click on Table sort & search option
    And I click show entries drop down option
    And I select <NO> from the drop down list
    Then I check if that <NO> of rows are displyed

    Examples: 
      | NO  |
      |  10 |
      |  25 |
      |  50 |
      | 100 |
      
#@TableTabDataSearch
#
 #	Scenario Outline: 06  Test Tasks field of table-search-filter-demo for keyword which is  present
    #When I click on Table Data Search option
    #And I enter <Keywords> in Tasks field
    #Then I verify if rows containing <Keywords> are displayed on Tasks table
#
    #Examples: 
      #| Keywords        |
      #| Wireframes	 |
      #| completed       |
      #|Jane            |
#
  #Scenario Outline: 07 Test  Tasks field of table-search-filter-demo for keyword which is not  present
    #Given I login to the application
    #And I click on the Table  tab
    #When I click on Table Data Search option
    #And I enter <Keywords> in Tasks field
    #Then I verify if No matching records found is displayed on Tasks table
#
    #Examples: 
      #| Keywords  |
      #| abdc      |
      #| ohhh      |
      #| helo wol  |
      #| testing t |
      #
 #@TableTabFilterDemo
      #
    #Scenario: 08 Test Filter records option for green colour
    #And I click on the Table Filter option
    #When I click on green button of the Filter Records Table
    #Then I verify if only green emojis are visible
    #When I click on red button of the Filter Records Table
    #Then I verify if only red emojis are visible
    #When I click on orange button of the Filter Records Table
    #Then I verify if only orange emojis are visible
   #
