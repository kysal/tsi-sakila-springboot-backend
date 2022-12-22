Feature: get specific address
  Scenario Outline: Getting a specific Address record from the database
    Given an address exists with id <addressId>
    When requesting address details
    Then the website will show "<address>", "<address2>", "<district>", <cityId>, "<postalcode>" and "<phone>" of the address
    Examples:
      | addressId |          address | address2 |   district | cityId | postalcode |        phone |
      |         6 | 1121 Loja Avenue |          | California |    449 |      17886 | 838635286649 |