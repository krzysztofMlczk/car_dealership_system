DELIMITER $$
	CREATE TRIGGER klient_constraint BEFORE INSERT ON rezerwacje
	FOR EACH ROW 
	BEGIN
    IF NOT(EXISTS(SELECT * FROM klienci WHERE klienci.id_klienta = NEW.id_klienta)) THEN
		signal sqlstate '45000';
    END IF; 
END $$
DELIMITER ;