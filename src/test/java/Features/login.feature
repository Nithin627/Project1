Feature: Orange HRM Login Test

Scenario Outline: Login into the Orange HRM site as a valid user
Given User on the Orange HRM login page
When User Enter the <username> and <password>
Then User clicks on the login button
And User validate the Orange HRM home page

Examples:
|username|password |
| Admin  |admin123 |