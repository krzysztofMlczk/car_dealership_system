DELIMITER $$
CREATE TRIGGER ustaw_cene_oferty BEFORE INSERT ON oferta
FOR EACH ROW 
BEGIN
	DECLARE wynik INT;
	CALL oblicz_cene_calkowita(NEW.id_modelu, NEW.kolor, NEW.nazwa_pakietu, wynik);
    SET NEW.cena_calkowita = wynik;
END $$
DELIMITER ;