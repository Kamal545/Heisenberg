Feature: DataBase

Scenario: Fetch the max salary
Given user connects to the Database
When user executes query "select employee_id,max(salary) salary from employees;"
Then employeeid should be 100 and max salary is 24000.00

