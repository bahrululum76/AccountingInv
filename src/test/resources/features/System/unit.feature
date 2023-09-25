Feature:  Unit

#
############CREATE Unit


  Scenario Outline: add unit
    Given user login sebagai 1
      And user is already on page <menu> 
    When  user create unit
    Then  System showed alert in page unit <message>
   Examples:
    |menu | message               |
    |setting/unit   |Unit Successfully created. |
    

  Scenario Outline: update unit
    Given user login sebagai 1
      And user is already on page <menu> 
    When  user update unit
    Then  System showed alert in page unit <message>
    
   Examples:
    |menu  | message               |
    |setting/unit|Unit successfully updated. |
    

  Scenario Outline: update status unit
    Given user login sebagai 1
      And user is already on page <menu> 
    When  user update status unit
    Then  System showed alert in page unit <message>
    
   Examples:
    |menu  | message               |
    |setting/unit|Unit successfully update status. |    
    

  Scenario Outline: delete unit
    Given user login sebagai 1
      And user is already on page <menu> 
    When  user delete unit
    Then  System showed alert in page unit <message>
    
   Examples:
   | message                  |menu   |
   |Unit successfully deleted. |setting/unit  |