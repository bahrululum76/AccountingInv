Feature: bank
     
  Scenario Outline: add bank 
   Given user login sebagai 1
      And user is already on page <menu>  
    When I ready on page add bank
      And I enter Bank Account Name 
      And I enter Bank Description
      And I enter Bank Account Number
      And i selected COA
    Then The system should show a success alert on the cash & bank page <message>
   
   Examples:
    | message  | menu   |
    |Create Bank Success|cash-bank|
      
  Scenario Outline: update bank
   Given user login sebagai 1
      And user is already on page <menu>  
    When User edit bank
    Then The system should show a success alert on the cash & bank page <message>
   
   Examples:
    | message         |menu|
    |Update Bank Success|cash-bank|
   
    
  Scenario Outline: delete bank
   Given user login sebagai 1
      And user is already on page <menu>  
    When User delete bank
    Then The system should show a success alert on the cash & bank page <message>
   
   Examples:
    | message           |menu|
    |Delete Bank Success|cash-bank|
      
  #Scenario: change the bank account that already has transaction data
    #Given I have bank data "Bank Mandiri"
      #And the system can only change the bank description
    #When I enter Bank Description with untuk pembayaran pos anggota
    #Then The system should show a success alert
      #And redirect to list bank
      
  #scenario: delete a bank account that has no transactions
    #Given I have bank data "Bank Mandiri"
    #When I selected Account BANK "Bank Mandiri"
      #and I press delete
    #Then The system should show a success alert
      #And redirect to list bank
      #and Bank account "Bank Mandiri" is not displayed
      
  #scenario: delete the bank that has the transaction
    #Given I have bank data "Bank Mandiri"
      #And there are ACCOUNT TRANSACTIONS
    #When I selected Account BANK "Bank Mandiri"
      #and I press delete
    #Then The system should show a error alert