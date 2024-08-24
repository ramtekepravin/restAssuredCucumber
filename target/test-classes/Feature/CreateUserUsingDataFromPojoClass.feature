
Feature: Create User Post api endpoint using pojoclass data

Scenario: Verify user is created using create Post api endpoint by data from pojo clss

Given Post endpoint with body data is available from pojo class

When User hits the post endpoint to create user

Then User should get created as required
