Feature:  Price Group

###########CREATE Price group


  Scenario Outline: add price group
    Given user login sebagai 1
      And user is already on page <menu>
    When  user create price group
    Then  System showed alert in page price group <message>
   Examples:
    |menu  | message                 |
    |good-services/price-groups    |Price Group Successfully created.|

  Scenario Outline: update price group
    Given user login sebagai 1
      And user is already on page <menu>
    When  user update price group
    Then  System showed alert in page price group <message>
    
   Examples:
    |menu  | message               |
    |good-services/price-groups|Price Group successfully updated.|
    

  Scenario Outline: delete price group
    Given user login sebagai 1
      And user is already on page <menu>
    When  user delete price group
    Then  System showed alert in page price group <message>
    
   Examples:
   | message                   |menu    |
   |Group successfully deleted. |good-services/price-groups|