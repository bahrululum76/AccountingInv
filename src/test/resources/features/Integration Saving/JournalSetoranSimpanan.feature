#Feature: Record of "SetoranSimpanan" from SimpanPinjam App
  #SimpanPinjam App wants to record a payment "Simpanan Pokok, Wajib, dan Sukarela"
  #So accounting system can track and monitor journal
  #
  #Scenario: Journal entries
    #Given the admin of the savings and loan app confirms the member's principal savings (Simpanan Pokok)
       #And the admin of the savings and loan app confirms the member's mandatory savings (Simpanan Wajib)
       #And the admin of the savings and loan app confirms members' voluntary savings (Simpanan Sukarela)
       #and  the admin of the savings and loan app is deposited into the kokarmina account
    #When the system makes a journal with the "SIMPANAN POKOK KEMAYORAN" account on credit
      #And the SIMPANAN WAJIB KEMAYORAN account on credit
      #And the SIMPANAN SUKARELA ANGGOTA KEMAYORAN account on credit
      #And the BANK KOKARMINA's account was debited
    #Then the journal forms a balance in total debits and credits