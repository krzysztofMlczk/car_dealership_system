DELIMITER $$
CREATE PROCEDURE rezerwacja_modelu(IN id_oferty_do_rezerwacji INT, IN id_klienta_do_rezerwacji INT, IN ilosc INT)
BEGIN
	
	START TRANSACTION;
    
    INSERT INTO rezerwacje(id_oferty, id_klienta, ilosc_zamowionych_sztuk, data_rezerwacji)
		VALUES(id_oferty_do_rezerwacji, id_klienta_do_rezerwacji, ilosc, CURDATE());
	
    UPDATE oferta SET stan_magazynowy = (stan_magazynowy - ilosc) WHERE id_oferty = id_oferty_do_rezerwacji;
    
    IF (SELECT stan_magazynowy FROM oferta WHERE id_oferty = id_oferty_do_rezerwacji) >=0 THEN COMMIT;
    ELSE ROLLBACK;
    END IF;
END $$
DELIMITER ;