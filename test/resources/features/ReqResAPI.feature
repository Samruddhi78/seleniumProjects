@tag
Feature: Title of your feature
  I want to use this template for my feature file
#
  #
  #Scenario: 01 Get list of all user and verify total user available is userCount[12]
  #* send get request to get all users
  #* verify if response contains userCount
  #
  #Scenario Outline: 02 Update details of any user on the basis of his/her id
  #* I send put request depending on <id> and change first name to <name>
  #* I verify if the data is changed <id> <name>
  #
  #Examples:
  #| name  | id |
  #| ian   |  5 |
  #| damon |  7 |
  #
  #Scenario Outline: 03 Create new user and verify the details of created user
  #* I send post request and create new user <first name> <last name> <email> <avatar>
  #* I verify if the user is created
  #
  #Examples:
  #| first name | last name   | email                | avatar                                                           |
  #| ian        | somerhalder | ian.holt@reqres.in   | https://s3.amazonaws.com/uifaces/faces/twitter/bigmancho/128.jpg |
  #| damon      | salvator    | damon.holt@reqres.in | https://s3.amazonaws.com/uifaces/faces/twitter/bigmancho/128.jpg |
  #
  #Scenario Outline: 04 Delete the user and verify that status code is corect and user has been deleted
  #* I send delete request depending on <id>
  #
  #Examples:
  #| id |
  #|  5 |
  #|  7 |
  
  Scenario Outline: 05  Get details of users whose first_name
    * I send get request to get user first named <name>

    Examples: 
      | name    |
      | Michael |
