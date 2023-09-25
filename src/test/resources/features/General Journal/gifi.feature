Feature: Gifi

############CREATE gifi

  Scenario Outline: add gifi
   Given user login sebagai 1
      And user is already on page <menu>
    When user create gifi <desc> and <gifi>
    Then System showed alert in page gifi <message>

  Examples: 
      |gifi| desc               | message             |menu|
      |12334|Gifi A						| Create Gifi Success |gifi|
      #|1000| Cash and deposits | Create Gifi Success |
      #|1060|Accounts receivable|Create Gifi Success  |
      #|1061|Allowance for doubtful accounts|Create Gifi Success|
      #|1073|Amounts receivable from members of NPOs|Create Gifi Success|
      #|1120|Inventories        |Create Gifi Success|
      

  Scenario Outline: update gifi
   Given user login sebagai 1
      And user is already on page <menu>
    When  user update gifi <desc>
    Then  System showed alert in page gifi <message>
    
   Examples:
    |desc          | message               |menu|
    |Gifi Modify A |Update Gifi Success    |gifi|
    

  Scenario Outline: delete gifi
   Given user login sebagai 1
      And user is already on page <menu>
    When  user delete gifi
    Then  System showed alert in page gifi <message>
    
  Examples:
   | message            |menu|
   |Delete Gifi Success |gifi|
