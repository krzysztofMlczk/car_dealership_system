DELIMITER $$
	CREATE TRIGGER producent_constraint BEFORE INSERT ON modele
	FOR EACH ROW 
	BEGIN
    IF NOT(EXISTS(SELECT * FROM dostepni_producenci WHERE dostepni_producenci.marka = NEW.marka)) THEN
		signal sqlstate '45000';
    END IF; 
END $$
DELIMITER ;