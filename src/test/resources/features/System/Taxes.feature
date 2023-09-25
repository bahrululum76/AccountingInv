Feature:  Taxes

#
############CREATE Taxes

@add_taxes
  Scenario Outline: add taxes
    Given user login sebagai 1
      And user is already on page <menu> 
    When  user create taxes
    Then  System showed alert in page taxes <message>
   Examples:
    |menu  | message               |
    |system/taxes|Tax Successfully created. |
    
#
  #Scenario Outline: update taxes
    #Given user login sebagai 1
      #And user is already on page <menu> 
    #When  user update taxes
    #Then  System showed alert in page taxes <message>
    #
   #Examples:
    #|menu | message               |
    #|system/taxes |Tax successfully updated. |
    #
#
  #Scenario Outline: delete taxes
    #Given user login sebagai 1
      #And user is already on page <menu> 
    #When  user delete taxes
    #Then  System showed alert in page taxes <message>
    #
   #Examples:
   #| message                  |menu  |
   #|Tax successfully deleted. |system/taxes |