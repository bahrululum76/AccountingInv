Feature: Change Password
  
  Scenario Outline: change password
  	Given user login sebagai 1
      And user is already on page <menu>
    When I enter password into old password 
      And I enter a new password into New password
      And I enter a new password into Verify
    Then I should see a message success changed password <message>
 		
Examples:
    | message              |menu|
    |Password successfully updated.|change-password|
    