#Feature: GL Report for Accounting System to record disbursement and fees for an approved Loan 
  #Posting to accounting on loans disbursement of a member 
  #if user is requested to disburse payment on an approved loan to a member 
  #
  #Background:
    #Given considering that the loan has been approved for 100,000,000 
      #And the borrower is registered at a particular branch
      #And transfer of funds (bank mandiri account) of 99,000,000
      #And of the approved loan is deducted so called Tabungan Resiko fund of 500,000
      #And 500,000 loan services
      #
  #Scenario: Post General Ledger for loan disbursement
    #When SimpanPinjam confirmation Loan Disbursement of member brach kemayoran 
   #Then account 105.00.000 "piutang pinjaman kemayoran" balance "100.000.000" on debit
    #And account 101.05.101 "bank mandiri" balance "99.000.000" on credit
    #And account 401.01.003 "tabungan resiko" balance "500.000" on credit
    #And account 606.01.003 "pendapatan adm pinjaman" "500.000" on credit
    #And total credit "100.000.000" 
    #And total debit "100.000.000"