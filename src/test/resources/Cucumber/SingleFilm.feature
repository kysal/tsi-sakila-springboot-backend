Feature: get specific film
  Scenario Outline: Getting a specific Film record from the Sakila database
    Given a film exists with id <filmId>
    When requesting film details
    Then the website will show "<title>" "<description>" <releaseYear> <languageId> <originalLanguageId> <rentalDuration> <rentalRate> <length> <replacementCost> and "<rating>" of film
    Examples:
      | filmId |            title |                                                                                      description | releaseYear | languageId | originalLanguageId | rentalDuration | rentalRate | length | replacementCost | rating |
      |      1 | ACADEMY DINOSAUR | A Epic Drama of a Feminist And a Mad Scientist who must Battle a Teacher in The Canadian Rockies |        2006 |          1 |              0  |              6 |       0.99 |     86 |           20.99 |     PG |
