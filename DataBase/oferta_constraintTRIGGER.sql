DELIMITER $$
	CREATE TRIGGER oferta_constraint BEFORE INSERT ON rezerwacje
	FOR EACH ROW 
	BEGIN
    IF NOT(EXISTS(SELECT * FROM oferta WHERE oferta.id_oferty = NEW.id_oferty)) THEN
		signal sqlstate '45000';
    END IF; 
END $$
DELIMITER ;