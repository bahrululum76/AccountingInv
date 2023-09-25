Feature:  COA
  	
###########CREATE Price group

@Create_coa
  Scenario Outline: add coa
    Given user login sebagai 1
      And user is already on page <menu>
    When  user create coa
    Then  System showed alert in page coa <message>
   Examples:
    | message                 |menu |
    |Create Chart of Account Successfully.|chart-of-account|

#@Update_coa
  #Scenario Outline: update coa
    #Given user login sebagai 1
      #And user is already on page <menu>
    #When  user update coa
    #Then  System showed alert in page coa <message>
    #
   #Examples:
    #| message               |menu |
    #|Update Chart of Account Successfully.|chart-of-account|
    #
#@Delete_coa
  #Scenario Outline: delete coa
    #Given user login sebagai 1
      #And user is already on page <menu>
    #When  user delete coa
    #Then  System showed alert in page coa <message>
    #
  #Examples:
   #| message                   |menu |
   #|Delete Chart Of Account Success |chart-of-account|
   
#Scenario: Add a new account
    #Given I navigate the menu and select the item at "General Journal > Chart of Accounts"
    #Then I should see the Chart of Accounts screen
      #And I expect the report to contain 78 rows
    #When I press "Create Account"
    #Then I should see the Account screen
    #When I enter "T0001" into "Account Number"
      #And I enter "New Account" into "Description"
      #And I press "Save"
    #Then I should see the Account screen
    #When I navigate the menu and select the item at "General Journal > Chart of Accounts"
    #Then I should see the Chart of Accounts screen
      #And I expect the report to contain 79 rows

  #Scenario: Delete the account from the chart of accounts
    #Given a gl account with these properties:
    #| Property       | Value                |
    #| Account Number | T0001                |
    #| Description    | New Account          |
    #| Category       | A                    |
    #| Heading        | 1000--CURRENT ASSETS |
    #When I navigate the menu and select the item at "General Journal > Chart of Accounts"
    #Then I should see the Chart of Accounts screen
      #And I expect the report to contain 79 rows
      #And I expect the 'Description' report column to contain 'New Account' for Account Number 'T0001'
    #When I click "[Delete]" for the row with Account Number "T0001"
      #Then I should see the Chart of Accounts screen
      #And I expect the report to contain 78 rows
 
  #Scenario: Delete the account from the chart of accounts
    #Given a gl account with these properties:
    #| Property       | Value                |
    #| Account Number | T0001                |
    #| Description    | New Account          |
    #| Category       | A                    |
    #| Heading        | 1000--CURRENT ASSETS |
    #When I navigate the menu and select the item at "General Journal > Chart of Accounts"
      #And I click "Update" for the row with Account Number "T0001"
      #And I enter description with "Account Updated"
      #And I press save
    #Then system showed succesfully updated 
      #And I see account number "T0001" with description "Account Update"
   