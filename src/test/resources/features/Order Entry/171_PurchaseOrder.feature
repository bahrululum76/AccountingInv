Feature: Purchase order
  

  Scenario Outline: add purchase order
   Given user login sebagai 2
      And user is already on page <menu>  
    When I enter the Supplier
      And I select 'IDR' as the currency
      And I select 'Today' as the Order Date
      And I select 'Pocari' as the PartNumber
      And I enter the qty of "10"
      And I enter the price of '5000'
      And I enter the description
      And I expect the 'Subtotal' to contain 'Rp 50.000'
      And I press save 
    Then system showed success alert in page purchase order <message>
   
   Examples:
    | message  | menu   |
    |Purchase Order Successfully created.|order-entry/purchase-order|
    |Purchase Order Successfully created.|order-entry/purchase-order|
    
  Scenario Outline: update purchase order
   Given user login sebagai 2
      And user is already on page <menu>   
    When user update purchase order
    Then system showed success alert in page purchase order <message>
   
   Examples:
    | message  | menu   |
    |Purchase Order successfully updated.|order-entry/purchase-order|
    
  Scenario Outline: Approve purchase order
   Given user login sebagai 1
      And user is already on page <menu>   
    When user approve purchase order
    Then system showed success alert in page purchase order <message>
   
   Examples:
    | message  | menu   |
    |Status Berhasil DiApprove|order-entry/approve-po|

  Scenario Outline: Reject purchase order
   Given user login sebagai 1
      And user is already on page <menu>   
    When user reject purchase order
    Then system showed success alert in page purchase order <message>
   
   Examples:
    | message  | menu   |
    |Status Berhasil DiReject|order-entry/approve-po|
    
    
  Scenario Outline: delete purchase order
   Given user login sebagai 2
      And user is already on page <menu> 
    When user delete purchase order 
    Then system showed success alert in page purchase order <message>
   
   Examples:
    | message  | menu   |
    |Purchase Order successfully deleted.|order-entry/purchase-order|