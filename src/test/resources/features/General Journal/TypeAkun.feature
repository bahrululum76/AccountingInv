Feature:  tipe akun
    

#
############CREATE Tipe Akun
@Create_tipe_akun
  Scenario Outline: add tipe akun
    Given user login sebagai 1
      And user is already on page <menu>
    When user create tipe akun <name>
    Then System showed alert in page tipe akun <message>
    
   Examples:
    |name        | message                    | menu |
    |Type        |Create Account Type Success |account-type|
    #|asset       |Create Account Type Success |
#		|Liability   |Create Account Type Success |
#		|Equity      |Create Account Type Success |
#		|Income 		 |Create Account Type Success |
#		|Expense     |Create Account Type Success |
		
    
########Feature: update 'tipe akun'
@Update_tipe_akun
  Scenario Outline: update nama tipe akun
    Given user login sebagai 1
      And user is already on page <menu>
      When user Edit tipe akun <name>
      Then System showed alert in page tipe akun <message>
    Examples:
    |name        | message   |menu|
    |Modify  |Update Account Type Success |account-type|
    #
   #
####Feature: delete 'tipe akun'
@delete_type_akun    
  Scenario Outline: delete tipe akun
    Given user login sebagai 1
      And user is already on page <menu>
    When user hapus data tipe akun
    Then System showed alert in page tipe akun <message>
	Examples:
		| message   |menu|
    |Delete Account Type Success |account-type|
    #|Delete Account Type Success |
    #|Delete Account Type Success |
    #|Delete Account Type Success |
    #|Delete Account Type Success |  