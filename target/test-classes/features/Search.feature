Feature: Search functionality

Scenario: User searches for a valid product
Given user opens the application
When user enters the valid product "HP" into the search field
And user clicks on search button
Then user should get a valid product displayed in the search results

Scenario: User searches for a invalid product
Given user opens the application
When user enters the invalid product "Honda" into the search field
And user clicks on search button
Then user should get a message about no product match

Scenario: User searches without any product
Given user opens the application
When user enters nothing into into the search field
And user clicks on search button
Then user should get a message about no product match
