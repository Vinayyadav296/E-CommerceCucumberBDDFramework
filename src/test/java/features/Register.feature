Feature: Registration functionality

Scenario: User creates account with only mandatory fields

Given user navigates to the register account page
When user enters the details in below fields
|firstName  |Karan          |
|lastName   |Motoori          |
|email      |KaranMotoor2@gmail.com|
|telephone  |1245645566     |
|password   |Karan@321      |
And user clicks on privacy policy
Then user clicks on continue button
Then user account should created successfully


Scenario: User creates account with all fields

Given user navigates to the register account page
When user enters the details in below fields
|firstName  |Karan          |
|lastName   |theDetective          |
|email      |KaranDetect2@gmail.com|
|telephone  |1245645566     |
|password   |Karan@321      |
And user select yes for news letter	
And user clicks on privacy policy
Then user clicks on continue button
Then user account should created successfully


Scenario: User creates a duplicate account  

Given user navigates to the register account page
When user enters the details in below fields
|firstName  |Karan          |
|lastName   |Bisht          |
|email      |KaranDetect2@gmail.com|
|telephone  |1245645566     |
|password   |Karan@321      |
And user select yes for news letter	
And user clicks on privacy policy
Then user clicks on continue button
Then user should get a warning message about duplicate email


Scenario: User creates a account without filling any details  

Given user navigates to the register account page
And user does not filled any details into the fields
Then user clicks on continue button
Then user should get a warning message for filling every mandatory fields
