
Feature: Fill up the form to submit

@SmokeTest
Scenario Outline: Positive form fillup

Given user is on the demoqa form page
When where page title is title is DEMOQA
Then user enters the mandatory <firstName>, <lastName>, <email> and <mobileNumber>
Then selects their <gender>
And clicks on submit button
Then user will see pop-up containig their submitted info

@RegressionTest
Examples: 
      | firstName  | lastName | email  | gender | mobileNumber |
      | name1 | ln1 | ab@email.com | label[for='gender-radio-1'] | 9876543210 |
      
Examples:          
      | firstName  | lastName | email  | gender | mobileNumber |
      | name2 | ln2 | cd@email.com | label[for='gender-radio-2'] | 1234567890 |
