Feature: Account Page Feature

Background:
Given user has already logged in to application
|username|password|
|kamalsarathh@gmail.com|Mobileadhoc@25|
|kamalsarathh@gmail.com2|Mobileadhoc@254|
|kamalsarathh@gmail.com3|Mobileadhoc@255|

@accounts
Scenario: Accounts page title
Given user is on Accounts page
When user gets the title of the page
Then page title should be "My account - My Store"

@accounts
Scenario: Accounts section count
Given user is on Accounts page
Then user gets accounts section
|ORDER HISTORY AND DETAILS|
|MY CREDIT SLIPS|
|MY ADDRESSES|
|MY PERSONAL INFORMATION|
|MY WISHLISTS|
And accounts section count should be 5
And all sections links should be clickable and active
|Order history - My Store|
|Order slip - My Store|
|Addresses - My Store|
|Identity - My Store|
|My Store|

@accounts
@Smoke
Scenario: Accounts page Store Information
Given user is on Accounts page
Then user gets Store Information
|Selenium Framework, Research Triangle Park, North Carolina, USA|
|Call us now: (347) 466-7432|
|Email: support@seleniumframework.com|
And header should be "Store information"