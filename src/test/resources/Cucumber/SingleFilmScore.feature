Feature: get a specific film score
  Scenario Outline: Getting a specific film score record from the database
    Given a film score exists with film id <filmId> and user id <userId>
    When requesting film score details
    Then the website will show <score>
    Examples:
      | filmId | userId | score |
      |      1 |      1 |     5 |