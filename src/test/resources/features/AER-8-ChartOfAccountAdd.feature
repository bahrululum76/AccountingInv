#Feature: Add new account
  #As a user I want to be able to add a new account and see that
  #this new account is listed in the chart of accounts. 
#
  #Background:
    #Given a logged in admin user
#
  #Scenario: Add a new account
    #When I navigate the menu and select the item at "General Journal > Chart of Accounts"
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
#
#
##Account Number : required, string, max length 100
##description: required, string, max length 100
##heading: required 
##gifi: optional