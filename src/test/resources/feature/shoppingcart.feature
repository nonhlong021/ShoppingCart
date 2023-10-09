@shop
Feature: Product Filtering and Adding to Cart

@here
  Scenario Outline: Filtering products by size
    When the user selects "<size>" from the size filter
    Then only products of size "<product>" are displayed
    Examples:
      | size |product|
    |   L      | 10|

  Scenario Outline: Validate that a user can add a product to cart
    When the user clicks the Add to Cart button for a product "<product_name>"
    Then the product "<product_name>" is present in the cart

    Examples:
      |  product_name                 |
      | Cropped Stay Groovy off white |

