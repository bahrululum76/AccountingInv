Feature: Contact Person
 
 Scenario Outline: contact search with entity class person
    Given user login sebagai 1
      And user is already on page <menu>
    When I enter a entity class person
    Then I should see the result search entity personal
    
 Examples:
    | index| name        |menu |
    |0     |Customer  	  |contact/search|
    

  Scenario Outline: Add person contact
   Given user login sebagai 1
      And user is already on page <menu>
 		When User Create Contack Person
 		Then System showed alert in page search_contact <message>
 		
Examples:
    | message              |menu |
    |Create Person Contact Success|contact/search|
    

  Scenario Outline: Update person contact
   Given user login sebagai 1
      And user is already on page <menu>
 		When User Update Contack person
 		Then System showed alert in page search_contact <message>
 		
Examples:
    |name        | message              |menu |
    |     |Update Person Contact Success|contact/search|
    

  Scenario Outline: Delete person contact
   Given user login sebagai 1
      And user is already on page <menu>
 		When User Delete Contack person
 		Then System showed alert in page search_contact <message>
 		
 Examples:
    |name        | message              |menu |
    |     |Delete Person Contact Success|contact/search|