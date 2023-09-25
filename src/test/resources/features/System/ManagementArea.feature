Feature: Management Area

  Scenario Outline: add management area
    Given user login sebagai 1
      And user is already on page <menu>
    When the user enters name Area
      And the user selects Outlet
    Then System showed alert in page management-area <message>
		Examples:
		| message   |menu|
    |Region Successfully created. |system/management-area|    
  
  Scenario Outline: UPDATE management area
    Given user login sebagai 1
      And user is already on page <menu>
    When User update management area
    Then System showed alert in page management-area <message>
		Examples:
		| message   |menu|
    |Region successfully updated. |system/management-area|   
    
  Scenario Outline: update management area
    Given user login sebagai 1
      And user is already on page <menu> 
    When User delete management area
    Then System showed alert in page management-area <message>
	Examples:
		| message   |menu|
    |Region successfully deleted. |system/management-area|