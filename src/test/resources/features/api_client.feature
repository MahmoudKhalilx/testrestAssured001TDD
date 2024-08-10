Feature: API Client Management

  Scenario Outline: Create a new API client
    Given I have a new API client request ClientName "<ClientNameClientName>" and ClientEmail "<ClientEmail>"
    When I send a POST request to create an API client
    Then the response status code should be 201
    And the response should contain an access token
Examples:
    | ClientNameClientName | ClientEmail |
    | mahmoudKhalil1 | mahmoudKhalil1@test.com |
#    | mahmoudKhalil2 | mahmoudKhalil2@test.com |


  Scenario Outline: Get List of Books by type
    When I send a GET request to fetch "<Type>" books
    Then the response status code should be 200
    And the response should contain a list of "<Type>" books
Examples:
    |Type|
  |non-fiction|
#    |fiction|


  Scenario: Retrieve a specific book
    When I send a GET request to fetch book with ID 1
    Then the response status code should be 200
    And the response should contain details of the requested book