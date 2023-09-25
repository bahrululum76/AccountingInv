Feature:  Part
#
###########CREATE PART


  Scenario Outline: add part
    Given user login sebagai 1
      And user is already on page <menu>
    When user create part
    Then System showed alert on part page <message>
   
   Examples:
    |menu        | message          |
    |good-services/part     |Part Successfully created. |


  Scenario Outline: update part
    Given user login sebagai 1
      And user is already on page <menu>
    When user update part
    Then System showed alert on part page <message>
   
   Examples:
    |menu        | message          |
    |good-services/part     |Part successfully updated. |   
    

  Scenario Outline: delete part 
    Given user login sebagai 1
      And user is already on page <menu>
    When user delete part
    Then System showed alert on part page <message>
   
   Examples:
    | message          |menu    |
    |Part successfully deleted. |good-services/part|   
