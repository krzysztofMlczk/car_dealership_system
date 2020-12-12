DELIMITER $$
	CREATE TRIGGER usuwanie_producenta BEFORE DELETE ON dostepni_producenci
	FOR EACH ROW 
	BEGIN
	DECLARE producent_do_usuniecia VARCHAR(20);
    SET producent_do_usuniecia = OLD.marka;
	
    -- teraz skoro wiemy jaki producent zostal usuniety, to musimy usunac modele, ktore sa tego producenta
	
	DELETE FROM modele WHERE modele.marka = producent_do_usuniecia;
END $$
DELIMITER ;