#Author: Izertis
#Keywords Summary : InputProcessor
Feature: Process data OAI-PMH

  Scenario: InputProcessor read oai-pmh data from tail and process this data
    Given read oai-pmh
    Then the service process oai-pmh data