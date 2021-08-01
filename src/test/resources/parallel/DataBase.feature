Feature: DataBase

Scenario: Fetch the max salary
Given user connects to the Database
When user executes query "select employee_id,max(salary) salary from employees;"
Then employeeid should be 100 and max salary is 24000.00
@Smoke
Scenario: Validate Employee details
Given user connects to the Employee Database
When user validates the Employee data
Then it should be
|100| Steven   |King    |steven.king@sqltutorial.org|
|101| Neena    | Kochhar| neena.kochhar@sqltutorial.org|
|102| Lex      | De Haan| lex.de haan@sqltutorial.org|
|103| Alexander| Hunold | alexander.hunold@sqltutorial.org|
|104| Bruce    | Ernst  | bruce.ernst@sqltutorial.org|