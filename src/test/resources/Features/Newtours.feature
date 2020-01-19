Feature: Newtours

Background: 
When Launch the application

@TestSceanrio @Test11
Scenario: Verify user can login to application with valid credentials 
Then Login to application with valid credentails
Then Verify login page displayed

@TestSceanrio 
Scenario: Verify user registration form
When Click on Registration link
Then Enter the customer details
Then Verify the Success message after registration
Then CLick on sign-in hyperlink and verify login page displayed
Then Login to application with valid credentails
Then Verify login page displayed
 
@TestSceanrio 
Scenario: Verify the flight round trip functionality 
Then Login to application with valid credentails
Then Verify login page displayed
Then Choose the round trip details
Then Verify the Search result display for round trip

@TestSceanrio @Test1
Scenario: Verify the flight OneWay trip functionality 
Then Login to application with valid credentails
Then Verify login page displayed
Then Choose the OneWay trip details
Then Verify the Search result display for OneWay trip

@TestScenarioMultiple
Scenario Outline: login with different user credentials
Then Login to application with <Userid>,<Password> credentails
Then Verify login page displayed
Examples: 
|Userid|Password|
|testing|testing|
|testing|testing|	



