#Feature: Record of "Bunga Simpanan Sukarela" from SimpanPinjam App
  #SimpanPinjam App wants to record a payment Simpanan Sukarela
  #So accounting system can track and monitor journal
  #
  #Scenario: Journal entries
    #Given Simpan App membentuk bunga simpanan sukarela per tahun 
    #When the system makes a journal with the "BIAYA BUNGA SIMPANAN SUKARELA ANGGOTA KEMAYORANK" account on debit
      #And the SIMPANAN SUKARELA ANGGOTA KEMAYORAN account on credit
    #Then the journal forms a balance in total debits and credits