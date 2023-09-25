#Feature: Posting to accounting on loans disbursement of a member 
  #if user is requested to disburse payment on an approved loan to a member 
  #
  #Background:
    #Given a loan is already approved, borrowed is registed on a branch (for example kemayoran branch) 
    #and user is to post/journal the disbursed loan to a relevant account (in this case to account receivable of kemayoran branch) 
      #| employee_id |Nominal Pinjaman | acc no      | acc name         | id pinjaman  | tanggal | 
      #| A0001       |100.000.000      | 105.00.000  | PIUTANG PINJAMAN |            
      #| A0002       |50.000.000       | 105.00.000  | PIUTANG PINJAMAN |
      #
    #and to post fund transfer to accounting (cash/bank account)
      #| employee_id |Amount       | acc no      | acc name                  |
      #| A0001       |99.000.000   | 101.05.101  | Bank Mandiri 0060009768783|
      #
    #and of the approved loan is deducted so called Tabungan Resiko fund, and user is to post/journal this tabungan resiko to accounting system (in this case to tabungan risiko kemayoran branch since user si registed as member of kemayoran branch  )
      #| employee_id |Amount       | acc no      | acc name                  |
      #| A0001       |500.000      | 401.01.003  | TABUNGAN RESIKO KEMAYORAN |
      #
    #and of the loan service, koperasi receives admin fee and other fee for the loan service and user is to post this fee to income account as kemayoran branch income 
      #| employee_id |Amount       | acc no      | acc name                          |
      #| A0001       |500.000      | 606.01.003  | PENDAPATAN ADM PINJAMAN KEMAYORAN |
      #
  #Scenario: Post journal entries for pencairan pinjaman 
    #When user disburs payment to a member at the same time 
    #Then system created journal entries as follows
      #| Account                                         Membr ID |Loan Ref Number |Date | Source              | Debit       | Kredit    |
      #| 105.00.000 - Piutang Pinjaman                           | Pinjaman            | 100.000.000 | 0         | 
      #| 101.05.101 - MANDIRI 0060009768783                      | Pinjaman            |             | 99.000.000|
      #| 401.01.003 - TABUNGAN RESIKO KEMAYORAN                  | Pinjaman            |             |    500.000|
      #| 606.01.003 - PENDAPATAN ADM PINJAMAN KEMAYORAN  | Pinjaman    | 0           |    500.000|
    #Then system created AR Report for that member as follows
      #|Date       | Member ID | Loan Ref Number| Total Loan      | Outstanding Balance  |Installment| Paid            |Due Date  | unpaid / overpaid Amount| |
      #|01-Jun 23  |                                              | 90.000.000           |10.000.000 | 10.000.000      |-         |0     
      #|01-Jul 23  |                                              | 80.000.000           |10.000.000 | 9.000.000       |          | 1.000.000