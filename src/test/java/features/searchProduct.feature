Feature: Search and Place the Order for Products

  @PlaceOrder
  Scenario: Search Experience for the Product search in both home abd Offers Page
    Given User is on GreenCart landing Page
    When User searched with shortname "Tom" and extracted the actual name of the Product
    Then User searched for "Tom" shortname in the offer page
    And validate product name in offers page matches with Landing Page
#    Examples:
#      | Name  |
#      | Tom   |
#      | Harry |