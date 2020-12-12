DELIMITER $$
	CREATE TRIGGER usuwanie_modelu BEFORE DELETE ON modele
	FOR EACH ROW 
	BEGIN
	DECLARE model_do_usuniecia INT;
    SET model_do_usuniecia = OLD.id_modelu;
	
    -- teraz skoro wiemy jaki model zostal usuniety, to musimy usunac oferty, ktore zawieraja ten model
	
	DELETE FROM oferta WHERE oferta.id_modelu = model_do_usuniecia;
END $$
DELIMITER ;