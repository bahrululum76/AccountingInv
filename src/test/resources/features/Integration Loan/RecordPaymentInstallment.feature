#Feature: Record of Payment of installment from SimpanPinjam App
  #SimpanPinjam App wants to record a payment (payment of installment received from a member)
  #So accounting system can track and monitor account receivable and update the account balance 
  #
  #Scenario: AR Report for that member installment 
    #Given member has IDR 100.000.000  in "total loan" 
    #When a member pays a monthly loan of IDR  2.083.333,333 
    #Then I expect to see the paid of 2.083.333,333
      #And I expect to see the due /outstanding balance of 97.916.666,667 
#
  #Scenario: AR Report for that member pay monthly interest 
    #When members pay monthly interest of  416.666,667 
    #Then I expect to see the total of 416.666,667
      #And I expect to see the paid of 416.666,667
      #And I expect to see the due /outstanding balance of  0 
#
#
  #Scenario: View journal entries member installment
    #When a member pays a monthly loan of IDR 2.083.333,333 
       #And members pay monthly interest of 416.666,667
    #Then And I expect to see the account "Bank MANDIRI 0060009768783" balance "2.500.000"
      #And I expect to see the account "Piutang Pinjaman" balance "2.083.333,333" on the credit
      #And I expect to see the account "Piutang Bunga Pinjaman" balance "416.666,667" on the credit