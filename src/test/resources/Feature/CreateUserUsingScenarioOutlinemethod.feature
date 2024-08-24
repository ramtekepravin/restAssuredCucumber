Feature: Create Post api endpoint with scenario outline method

Scenario Outline: Verify user is created using create Post method using scenario outline

Given Post endpoint with body data is available as "<name>", "<job>"

When User hits the post endpoint to create data

Then User should get created with proper status code


Examples: 
|name       |job       |
|Nitin      |Develpoer |
|Suraj      |Manager    |