#Feature: Posting to accounting on installment loan of a member 
  #
  #Background:
    #Given there are installments
      #| employee_id |Date   | Loan Ref number | Amount      | acc no     | acc name  
      #| A0001       |01-Jul |                 |  2.500.000  | 101.05.101 | MANDIRI 0060009768783
      #
    #and the user is
      #| employee_id |Date   | Loan Ref number | Amount      | acc no     | acc name 
      #| A0001       |01-Jul |                 | 2.083.333   | 105.00.000 |PIUTANG PINJAMAN
      #
    #and koperasi receives loan interest (kemayoran branch)
      #| employee_id |Date   | Loan Ref number | Amount      | acc no                  | acc name
      #| A001        |01-Jul |                 |  416.666    | 41 sedang di tanyakan   |PIUTANG BUNGA PINJAMAN
      #
  #Scenario: Post AR Monitor for installment loan
    #When a member installment payment at the same time
    #Then system created AR Monitor for that member as follows
      #|Date       | Personal ID | Loan Ref Number| Total Loan      | Outstanding Balance  |Installment| Paid    |Due Date  | unpaid / overpaid Amount|
      #|01-Jun 23  |             |                | 100.000.000     | 97.916.666           |2.083.333  | 0       |-         | 0                       |