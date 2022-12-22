Feature: modify specific film score
  Scenario Outline: Creating a new film score, updating it and deleting it
    Given a film exists of id <filmId> and a user exists with id <userId>
    When creating a new film score of <addScore>
#    And updating film score to <updateScore>
#    And deleting film score
    Then the film score will be removed
    Examples:
      | filmId | userId | addScore | updateScore |
      |   100  |      2 |     4  |     6  |