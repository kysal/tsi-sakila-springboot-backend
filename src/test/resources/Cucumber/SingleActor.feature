Feature: get specific actor
  Scenario Outline: Getting a specific Actor record from the Sakila database
    Given an actor exists with id <actorId>
    When requesting actor details
    Then the website will show "<firstName>" and "<lastName>" of actor
    Examples:
      | actorId | firstName |     lastName |
      | 1       |  PENELOPE |      GUINESS |
      | 5       |    JOHNNY | LOLLOBRIGIDA |

