Feature: Login page feature
@Smoke
Scenario: Login page title
Given user is on login page
When user gets the title of the page
Then page title should be "Login - My Store"

Scenario: Forgot Password link
Given user is on login page
Then forgot your password link should be displayed

Scenario: Login with correct credentials
Given user is on login page
When user enters username "kamalsarathh@gmail.com"
And user enters password "Mobileadhoc@25"
And user clicks on Login button
Then user gets the title of the page
And page title should be "My account - My Store"

Scenario Outline: Login with incorrect credentials
Given user is on login page
When user enters username "<username>"
And user enters password "<password>"
And user clicks on Login button
Then user gets the Authentication error
And user gets the title of the page
And page title should be "Login - My Store"
Examples:
|username|password|
|kamalsarathh@gmail.com1|Mobileadhoc@253|
|kamalsarathh@gmail.com2|Mobileadhoc@254|
|kamalsarathh@gmail.com3|Mobileadhoc@255|

