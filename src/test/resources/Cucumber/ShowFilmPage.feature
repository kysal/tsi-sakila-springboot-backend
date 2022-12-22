Feature: get specific film page
  Scenario Outline: Getting a specific page of film ids
    Given a list of films exists at page <page>
    When requesting the film details
    Then the ids <id1> <id2> will be shown
    Examples:
      | page | id1 | id2 |
    | 1 | 1 | 2 |