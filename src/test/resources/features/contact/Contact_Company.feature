Feature: Contact Company 

  Scenario Outline: Add company contact
   Given user login sebagai 1
      And user is already on page <menu>
 		When User Create Contack Company
 		Then System showed alert in page search <message>
 		
Examples:
    | message              |menu|
    |Create Company Contact Success 	 |contact/search |
    		 
  Scenario Outline: Update company contact
   Given user login sebagai 1
      And user is already on page <menu>
 		When User Update Contack Company
 		Then System showed alert in page search <message>
 		
Examples:
    |name        | message              |menu |
    |     |Update Company Contact Success |contact/search |
    

  Scenario Outline: Delete company contact
   Given user login sebagai 1
      And user is already on page <menu>
 		When User Delete Contack Company
 		Then System showed alert in page search <message>
 		
Examples:
    |name        | message              | menu |
    |     |Delete Company Contact Success |contact/search |
 
 Scenario Outline: contact search with entity class
   Given user login sebagai 1
      And user is already on page <menu>
    When I enter a entity class
    Then I should see the result search entity class
    
 Examples:
    | index| name        | menu |
    |0     |Customer  	  |contact/search |
    #|1     |Employee     |
    #|2     |Member       |
    #|3     |Vendor       |
    #|4     |Member       |    
    #|5     |Supplier     |
    #
