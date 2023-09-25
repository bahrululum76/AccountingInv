Feature:  Group

#
############CREATE group


  Scenario Outline: add group not parent
    Given user login sebagai 1
      And user is already on page <menu>
    When  user create group
    Then  System showed alert in page group <message>
   Examples:
    |menu  | message               |
    |good-services/groups|Group Successfully created.|
    

  Scenario Outline: add group parent
    Given user login sebagai 1
      And user is already on page <menu>
    When  user create group parent
    Then  System showed alert in page group <message>
   Examples:
    |menu  | message               |
    |good-services/groups           |Group Successfully created. |
    

  Scenario Outline: update group
    Given user login sebagai 1
      And user is already on page <menu>
    When  user update group
    Then  System showed alert in page group <message>
    
   Examples:
    |menu  | message               |
    |good-services/groups           |Group successfully updated. |
    

  Scenario Outline: delete group
    Given user login sebagai 1
      And user is already on page <menu>
    When  user delete group
    Then  System showed alert in page group <message>
    
   Examples:
   | message               |menu    |
   |Group successfully deleted. |good-services/groups |