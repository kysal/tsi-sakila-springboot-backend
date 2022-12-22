Feature: get actor costars
  Scenario Outline: Getting to costars of a specific actor
    Given an actor exists with the id <actorId>
    When requesting the actor costars
    Then The website will show the <costarId1> <costarId1> <costarId1> <costarId1> <costarId1> of the actor
    Examples:
      | actorId | costarId1 |  costarId2 | costarId3 | costarId4 | costarId5 |
      |       1 | 4         |         64 |20         |127        |        119|