
Feature: Create User Post api endpoint using Excel file data

Scenario: Verify user is created using create Post api endpoint by data from Excel File

Given Post endpoint with body data is available from Excel File as "name" , "job"

When User hits the post endpoint to create user with Excel File

Then User should get created as required from Excel File
