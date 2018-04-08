Feature: Login to YourLaga website and ADD for multiple products and validate products

Background: Login to YourLaga

Given I login to YourLaga

  @AddProducts
  Scenario Outline: Add Multiple products to Basket
 When i QuickView an item
 Then i change item size to "<Size>"
 Then i click on AddToCart button
 Then click Continue shopping button
 Then i click on secondItem quickView and addToCart
 Then i click on Procced to Checkout
 Then Validate Item sizes and it's total 
 Examples:
  |Size|
  |M   |
  
  @AddMessage
  Scenario: Review Previous Orders And Add a Message
  Then i navigate to order history to view my previous orders
  And i select a previous order based on the date "<OrderDate>" and add a comment
  Then i verify that the comment appears under 'messages'
  
  @CaptureScreenGrab
  Scenario: Capture Images
  Then i navigate to order history to view my previous orders
  And i select a previous order based on the date "<OrderDate>" and add a comment
  Then i verify that the first products color is "<colorName>"
  
   

    