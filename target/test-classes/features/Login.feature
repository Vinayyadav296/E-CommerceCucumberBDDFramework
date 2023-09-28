Feature: Login Functionality

#Scenario: Login with valid credentials

Scenario Outline: Login with valid credentials

Given User navigate to the login page
#When user enter the valid email address "Vinaysingh@gmail.com" into email field
#When user enter the valid password "Vinay@321" into the password field
When user enter the valid email address "<username>" into email field
When user enter the valid password "<password>" into the password field
And user clicks on the login button
Then user should be able to login successfully
Examples:
|username                 |password|
|amotooricap1@gmail.com   |12345   |
|amotooricap2@gmail.com   |12345   |
|amotooricap3@gmail.com   |12345   |
Scenario: Login with invalid credentials

Given User navigate to the login page
When user enter the invalid email address "Vinay@gmail.com" into email field
When user enter the invalid password "Vinay@" into the password field
And user clicks on the login button
Then user should get proper warning message of invalid credentials

Scenario: Login with valid email and invalid password

Given User navigate to the login page
When user enter the valid email address "Vinaysingh@gmail.com" into email field
When user enter the invalid password "Vinay@" into the password field
And user clicks on the login button
Then user should get proper warning message of invalid credentials
#Then user should get the warning message of the invalid password


Scenario: Login with invalid email and valid password

Given User navigate to the login page
When user enter the invalid email address "Vinay@gmail.com" into email field
When user enter the valid password "Vinay@321" into the password field
And user clicks on the login button
Then user should get proper warning message of invalid credentials
#Then user should get the warning message of the invalid email

Scenario: Login without providing any credentials

Given User navigate to the login page
When user does not provide any email address in the email field
When user does not provide any password in the password field
And user clicks on the login button
Then user should get proper warning message of invalid credentials
#Then user should get the warning message of enter email and password

