#Feature: Record of SavingWithdrawal from SimpanPinjam App
  #Member wants to Withdrawal So the accounting system can track and monitor the journal
  #
  #Scenario: Journal entries
    #Given member with employee "A0001" Kemayoran branch wants to withdraw a deposit of 1,000,000
    #When the admin SimpanPinjam App confirms the member's deposit withdrawal
    #Then the system makes a journal with a "SIMPANAN SUKARELA ANGGOTA KEMAYORAN" account of 1,000,000 on Debit
      #and account bank of 1,000,000 on Credit
      #and the journal forms a balance in total debits and credits