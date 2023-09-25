Feature:  Heading
 
#
#
############CREATE Heading


  Scenario Outline: add Heading parent
   Given user login sebagai 1
      And user is already on page <menu>
    When user create Heading parent
    Then System showed alert in page Heading <message>
    
   Examples:
    |menu        | message               |
    |chart-of-account/add|Create Account Heading Success 	 |   


  Scenario Outline: add Heading
   Given user login sebagai 1
      And user is already on page <menu>
    When user create Heading <name> and <no>
    Then System showed alert in page Heading <message>
    
   Examples:
    |no    |name  | message                       | menu |
    |      |      |Create Account Heading Success |chart-of-account/add|
    #| 100.00.000 |AKTIVA LANCAR    |Create Account Heading Success 	 |
    #|101.01.000  |KAS     |Create Account Heading Success 	 |
    #|101.05.000|BANK     |Create Account Heading Success 	 |  
    #|105.00.000|PIUTANG PINJAMAN  |Create Account Heading Success 	 |    
    #|100.00.000|AKTIVA TETAP |Create Account Heading Success 	 |
#####Feature: update 'Heading'

  Scenario Outline: update nama Heading
   Given user login sebagai 1
      And user is already on page <menu>
      When user Edit Heading <name>
      Then System showed alert in page Heading <message>
   Examples:
    |name        | message   |menu |
    |TypeModify  |Update Account Heading Success |chart-of-account/add|
    #
   #
