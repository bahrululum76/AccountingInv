Feature:  Journal Entry
#
###########CREATE Journal Entry

  Scenario Outline: add jurnal entry 
   Given user login sebagai 1
      And user is already on page <menu>
    When user create journal entry
    Then System showed alert on Journal of entry page <message>
   
   Examples:
    |name        | message               | menu |
    |Type     |Success create journal entry. |jurnal-entry |
#
    #
   Scenario Outline: update jurnal entry 
   Given user login sebagai 1
      And user is already on page <menu>
    When user update journal entry
    Then System showed alert on Journal of entry page <message>
   
   Examples:
    |name        | message               | menu| 
    |Type     |General Ledger successfully updated. |jurnal-entry |   
    
   #Scenario Outline: update jurnal entry 
   #Given user login sebagai 1
      #And user is already on page <menu>
    #When user delete journal entry
    #Then System showed alert on Journal of entry page <message>
   #
   #Examples:
    #|name        | message               | menu| 
    #|Type     |General Ledger successfully deleted. |jurnal-entry |   
    