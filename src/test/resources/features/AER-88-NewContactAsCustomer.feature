#Feature: This application tests general components of contact management
#including new customers so forth.
#
  #Background: 
    #Given class already exists:
      #|Class    | 
      #|Customer |
      #|Employee |
      #|Member   |
      #|Vendor   |
      #|Supplier |
    #Salutation already exists:
      #|Salutation |
      #|Dr.        |
      #|Miss       |
      #|Mr.        |
      #|Mrs.       |
      #|Sir.       |
#
  #Scenario: Create a New Person as Customer
    #When I click on the Add Contact menu entry
      #And I select the 'Person' tab
      #And I select the 'Customer' on Class
      #And enter the Given name of 'Test'
      #And enter a surnaame of 'Another test'
      #And select 'Indonesia' as the country
      #And I enter Personal ID
      #And I enter Birtdate 
      #And click Save
    #
 #TODO
# Scenario: Look up person customer with all info filled out
# Scenario: Look up company vendor wit all info flled ou
# Scenario: Add new Vendor ECA to Customer
# Scenario: Add new Customer ECA to Vendor
# Scenario: add credit account on person Then I see the 'Credit Account' Tab  With no credit accounts in the listing When I click 'Save' on the Credit Account tab Then I see a new line in the listing And the Customer Number field is now filled in.
#
#ControlCode : Required, String 
#Middle Name : Optional
#Surname : Required 
#Personal id : Required, String 
#
##company 
#ControlCode : Required, String
#Name : Required 
#Tax Number : optional, string
#Licensi : optional, string
#sales tax id : optional, string