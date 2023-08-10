Feature: Product Filtering and Adding to Cart

  Background:
    Given the user is on the product page

  Scenario Outline: Filtering products by size
    When the user selects "<size>" from the size filter
    Then only products of size "<product>" are displayed
    Examples:
      | size |product|
    |   L      | Cropped Stay Groovy off white+  |


  Scenario: Adding a product to the cart
    When the user clicks the Add to Cart button for a product
    Then the product is added to the cart
