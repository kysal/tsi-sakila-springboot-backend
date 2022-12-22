Feature:
  Scenario Outline: Getting a specific page of search results
    Given a list of films exists at page <page> and search term "<search>"
    When requesting film details of search
    Then the ids <id1> <id2> will be shown for the search
    Examples:
      | page | search | id1 | id2 |
      |    1 |   ace  |   2 |  59 |