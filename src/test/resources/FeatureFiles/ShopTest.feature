Feature: Login, product search, [add to cart and continue shopping], add the same product to the cart
  Scenario: validate home page, search product, and add to cart
    Given The user navigates to the login page with username and password from config.properties
    When I check the home page title as "Order Lab Tests from Home Without a Doctor's Visit | Labcorp OnDemand"
    Then I click on the shop tests button.
    And I should be on the product list page to check the title as "Explore Our Lab Tests | Labcorp OnDemand"
    When I click on the search icon and am able to navigate the search page.
    Then I fill the product name in the search bar and by clicking the enter button
    Then I should able to see (Sign up now to receive your discount.) window
    When I click on the No thanks button.
    Then I should see the product name "Vitamin C Test"
    When I click on the add to cart button.
    Then I should be able to see "Item successfully added to your cart."
    When I click on the continue shopping button and am able to navigate same product page.
    Then I try to add the same product.
    Then I should get the message "Quantity Limit Reached"