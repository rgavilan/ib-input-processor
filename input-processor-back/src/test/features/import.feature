#Author: Izertis
#Keywords Summary : InputProcessor
Feature: Communication Backend ImportResultController

  Scenario: InputResultController receives a message with filters
    Given call to backend  input result controller
    Then the controller call to servie and find result to send response
