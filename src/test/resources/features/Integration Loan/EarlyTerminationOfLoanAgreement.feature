#Feature: Early Termination Of Loan Agreement
  #
  #Scenario: AR Report from members pay the remaining of the loan
    #Given member branch kemayoran has a remaining loan of 20,000,000
      #And the member wants to pay off the loan
    #When the admin SimpanPinjam App confirms the member's pre-termination Loan
    #Then I expect to see a paid of 20,000,000
      #And I expect to see the due/ outstanding balance amount of 0
      #
  #Scenario: Journal entries
    #Given member branch kemayoran has a remaining loan of 20,000,000
      #And The loan penalty is 600,000
    #When the admin Simpan Pinjam App confirms the member's pre-termination Loan
    #Then the system makes a journal with a bank account of 20,600,000 on debit
      #and "PIUTANG PIHAK KETIGAKEMAYORAN" account of 20,000,000 on credits
      #and "PENDAPATAN PINALTY PINJAMAN" account of 600,000 on credits
      #and the journal forms a balance in total debits and credits