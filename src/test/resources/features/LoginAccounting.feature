#Feature: Login
#
#Background:
  #Given User is already on the login page
  #
  #Scenario: User filled correct email and password
    #Given User is already on the login page
    #Given email and password input has filled
     #When User click the button Login
    #Then System showed success alert <message>
 #
 #		 Examples: 
      #|username   | password | message  |
      #|admin@example.com |P@ssw0rd123| Login Berhasil |
      #
      #
  #Scenario: User fills incorrect email or password
    #Given email and password input has filled <username> and <password>
    #When User click the button Login
    #Then System showed success alert <message>
 #
    #Examples: 
      #|username   | password | message  |
      #|admin@exam3le.com |P@ss3423w0rd123| Email atau password yang anda masukkan salah |      
      #
  #Scenario: User has not filled email and password
    #Given email and password input has filled <username> and <password>
    #When User click the button Login
    #Then System showed an error message below the email field that said <message1>
    #And System showed an error message below the password field that said <message2>
     #
     #Examples: 
      #|username   | password | message1  | message2  |  
      #|         |    | Email tidak boleh kosong | Password tidak boleh kosong |   
      #
  #Scenario: Kepala Finance invalid format email address
    #Given email and password input has filled <username> and <password>
    #When System showed an error message below the email field that said 
    #Examples: 
      #|username   | password | message  |
      #|adminexam3le.com |P@ssw0rd123| Email tidak valid |  
#
#GL Admin    
#AP Admin
#AR Admin