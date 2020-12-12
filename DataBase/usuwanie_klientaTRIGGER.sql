DELIMITER $$
	CREATE TRIGGER usuwanie_klienta BEFORE DELETE ON klienci
	FOR EACH ROW 
	BEGIN
	DECLARE klient_do_usuniecia INT;
    SET klient_do_usuniecia = OLD.id_klienta;
	
    -- teraz skoro wiemy jaki klient zostal usuniety, to musimy usunac rezerwacje, ktore sa tego klienta
	
	DELETE FROM rezerwacje WHERE rezerwacje.id_klienta = klient_do_usuniecia;
END $$
DELIMITER ;