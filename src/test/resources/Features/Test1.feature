Feature: Login Action

Scenario Outline: Validate the login feature with valid crendentials 
Given I Open browser and naviagte to "https://example.testproject.io/web/"
When I click on Sign in button
Then  I enters "<username>" and "<password>"
Then  I should be able to land on the homepage

Examples:
|username||password|
|ssree2507@gmail.com||Test@789|
|utest9209@gmail.com||Test@789|
   


