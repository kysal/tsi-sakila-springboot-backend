Feature: register user into database
  Scenario Outline: Inserting a new user into the Sakila database
    Given a new user is created with the attributes "<password>", "<firstName>", "<lastName>"
    And a random username
    When creating the database user
    Then the website will return the new user database record
    Examples:
      | password | firstName | lastName |
      | password |   testing |     user |