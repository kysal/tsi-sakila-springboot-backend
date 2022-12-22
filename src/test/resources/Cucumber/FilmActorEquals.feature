Feature: two film actors equal
  Scenario Outline: Get two specific film actor records and compare
    Given two film actors exist with <filmId1> <actorId1> <filmId2> <actorId2>
    When comparing two film actors
    Then the film actors will be correctly determined to equal "<equal>"
    Examples:
      | filmId1 | actorId1 | filmId2 | actorId2 | equal |
      | 1 | 1 | 1 | 1 | true |
      | 1 | 2 | 1 | 1 | false |
      | 2 | 1 | 1 | 1 | false |