DELIMITER $$
	CREATE TRIGGER model_kolor_pakiet_constraint BEFORE INSERT ON oferta
	FOR EACH ROW 
	BEGIN
    IF NOT(EXISTS(SELECT * FROM modele WHERE modele.id_modelu = NEW.id_modelu) AND 
		EXISTS(SELECT * FROM kolory WHERE kolory.nazwa_koloru = NEW.kolor) AND
		EXISTS(SELECT * FROM pakiety WHERE pakiety.nazwa_pakietu = NEW.nazwa_pakietu))
    THEN
		signal sqlstate '45000';
    END IF; 
END $$
DELIMITER ;