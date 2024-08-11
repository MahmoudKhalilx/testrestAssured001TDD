Feature: API Client Management

#  Scenario Outline: Create a new API client
#    Given I have a new API client request ClientName "<ClientNameClientName>" and ClientEmail "<ClientEmail>"
#    When I send a POST request to create an API client
#    Then the response status code should be 201
#    And the response should contain an access token
#Examples:
#    | ClientNameClientName | ClientEmail |
#    | mahmoudKhalil1 | mahmoudKhalil1@test.com |
##    | mahmoudKhalil2 | mahmoudKhalil2@test.com |


#  Scenario Outline: Get List of Books by type
#    When I send a GET request to fetch "<Type>" books
#    Then the response status code should be 200
#    And the response should contain a list of "<Type>" books
#    Then I store the book ID
#Examples:
#    |Type|
#  |non-fiction|
#    |fiction|

#  Scenario: GET a specific book
#  When I sent the book ID
#    When I send a GET request to fetch book with ID 1
#    Then the response status code should be 200
#    And the response should contain details of the requested book


#  Scenario: Submit an order
#    Given I have a valid access token
#    Then I store the book ID
#    And I have an order request for book with ID 1
#    When I send a POST request to submit the order
#    Then the response status code should be 201
#    And the response should contain the order details
#
#



  Scenario Outline: Create a new API client and submit an order
    Given I have a new API client request ClientName "mahmoudKhalil1" and ClientEmail "mahmoudKhalil1@test.com"

    When I send a POST request to create an API client
    Then the response status code should be 201
    And I store the access token from the response

    When I send a GET request to fetch "<Type>" books
    Then the response status code should be 200
    And the response should contain a list of "<Type>" books
    Then I store the book ID
    When I send a GET request to fetch book with ID
    Then the response status code should be 200
    And the response should contain details of the requested book

    When I submit an order for the stored book ID with customer name "Salvador Windler"
    Then the response status code should be 201

##      assert customerName,createdBy, and get id
    When I send a GET request to get all orders
    Then the response status code should be 200


    And the response should contain orders details
    Then I store the first order id

    Then I send a GET request to get order with selected id
    And the response should contain orders details


    When I send a "Patch" request to "update" the order
    Then the response status code should be 204

    When I send a "Delete" request to "Delete" the order
    Then the response status code should be 204

    When I send a GET request to get all orders
    And the response should contain orders details without deleted order







    Examples:
      |Type|
      |fiction|
      |non-fiction|
