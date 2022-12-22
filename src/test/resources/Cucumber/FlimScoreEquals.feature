Feature: two film scores equal
  Scenario Outline: Get two specific film score records and compare them
    Given two film scores exist with <filmId1> <userId1> <filmId2> <userId2>
    When comparing the two film scores
    Then they will be correctly determined to equal "<equal>"
    Examples:
      | filmId1 | userId1 | filmId2 | userId2 | equal |
    | 1 | 1 | 1 | 1 | true |
    | 1 | 2 | 1 | 1 | false |
    | 2 | 1 | 1 | 1 | false |