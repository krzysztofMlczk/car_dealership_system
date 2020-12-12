DELIMITER $$
	CREATE TRIGGER usuwanie_rezerwacji BEFORE DELETE ON rezerwacje
	FOR EACH ROW 
	BEGIN
	DECLARE ilosc_sztuk_usunietej_rezerwacji INT;
	DECLARE id_oferty_usunietej_rezerwacji INT;
    SET ilosc_sztuk_usunietej_rezerwacji = OLD.ilosc_zamowionych_sztuk;
	SET id_oferty_usunietej_rezerwacji = OLD.id_oferty;
	
    -- teraz skoro wiemy jaka rezerwacja zostal anulowana, to musimy dodac ilosc_zamowionych_sztuk do stanu magazynowego oferty, ktorej dotyczyla rezerwacja
	
	UPDATE oferta SET oferta.stan_magazynowy = oferta.stan_magazynowy + ilosc_sztuk_usunietej_rezerwacji WHERE oferta.id_oferty = id_oferty_usunietej_rezerwacji;
END $$
DELIMITER ;