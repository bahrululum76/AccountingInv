#Feature: View Report AR disbursement 
  #SimpanPinjam App loans disbursement of a member posting to Account Receivable 
#
  #Background:
    #Given considering that the loan has been approved for 100,000,000 
    #
  #Scenario: AR Report from member loan disbursement 
    #When the member branch kemayoran has a loan of 100,000,000
      #And admin SimpanPinjam App confirmation for member loan disbursement
    #Then I expect to see a total of 100,000,000
      #And I expect to see a paid of 0
      #And I expect to see a due of 100,000,000