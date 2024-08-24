
Feature: Create User Post api endpoint using JSON file data

Scenario: Verify user is created using create Post api endpoint by data from JSON File

Given Post endpoint with body data is available from JSON File

When User hits the post endpoint to create user with JSON File

Then User should get created as required from JSON File
