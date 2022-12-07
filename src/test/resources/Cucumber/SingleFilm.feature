Feature: get specific film
  Scenario Outline: Getting a specific Film record from the Sakila database
    Given a film exists with id <filmId>
    When requesting film details
    Then the website will show "<title>" and "<description>" of film
    Examples:
      | filmId |            title |                                                                                      description |
      |      1 | ACADEMY DINOSAUR | A Epic Drama of a Feminist And a Mad Scientist who must Battle a Teacher in The Canadian Rockies |
      |     74 |  BIRCH ANTITRUST |                 A Fanciful Panorama of a Husband And a Pioneer who must Outgun a Dog in A Baloon |
