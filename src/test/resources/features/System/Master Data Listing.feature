Feature:  Master Data Listing

#
############CREATE Master Data Listing


  Scenario Outline: add listing
    Given user login sebagai 1
      And user is already on page <menu> 
    When  user create listing
    Then  System showed alert in page listing <message>
   Examples:
    |menu  | message               |
    |system/listings       |Listing Successfully created. |
    

  Scenario Outline: update listing
    Given user login sebagai 1
      And user is already on page <menu> 
    When  user update listing
    Then  System showed alert in page listing <message>
    
   Examples:
    |menu  | message               |
    |system/listings           |Listing successfully updated. |
    
   
  Scenario Outline: delete listing
    Given user login sebagai 1
      And user is already on page <menu> 
    When  user delete listing
    Then  System showed alert in page listing <message>
    
   Examples:
   | message                  | menu   |
   |Listing successfully deleted. |system/listings |
   
  #Scenario: add master data listing
    #When the user enters the MDL name
      #And user selects 'Jabodetabek' as the Area
      #And the user enters the expiration date
      #And the user selects 'PT Anu Prima' as the Supplier
      #And the user selects 'PT Antar Mitra Sembada' as the Supplier
      #And the user selects 'Pocari' as the Part
      #And the user selects 'Citato' as the Part
      #And the user selects 'pcs' as the Unit
      #And the user selects 'box' as the Unit
      #And the user enters the validation price unit
    #Then the system displays the data successfully added