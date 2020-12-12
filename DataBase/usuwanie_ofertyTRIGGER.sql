DELIMITER $$
	CREATE TRIGGER usuwanie_oferty BEFORE DELETE ON oferta
	FOR EACH ROW 
	BEGIN
	DECLARE oferta_do_usuniecia INT;
    SET oferta_do_usuniecia = OLD.id_oferty;
	
    -- teraz skoro wiemy jaka oferta zostala usunieta, to musimy usunac rezerwacje, ktore zawieraja ta oferte
	
	DELETE FROM rezerwacje WHERE rezerwacje.id_oferty = oferta_do_usuniecia;
END $$
DELIMITER ;