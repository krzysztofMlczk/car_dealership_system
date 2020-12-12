DELIMITER $$
	CREATE PROCEDURE oblicz_cene_calkowita(IN idModelu INT, IN kolor VARCHAR(20), IN pakiet VARCHAR(20), OUT wynik INT)
	BEGIN 
	DECLARE cena_bazowa_modelu INT;
	DECLARE cenaKoloru INT;
	DECLARE cenaPakietu INT;

	SET cena_bazowa_modelu = (SELECT cena_bazowa FROM modele WHERE modele.id_modelu = idModelu LIMIT 1);
	SET cenaKoloru = (SELECT cena_koloru FROM kolory WHERE kolory.nazwa_koloru = kolor LIMIT 1);
	SET cenaPakietu = (SELECT cena_pakietu FROM pakiety WHERE pakiety.nazwa_pakietu = pakiet LIMIT 1);

	SET wynik = cena_bazowa_modelu + cenaKoloru + cenaPakietu;
END$$
DELIMITER ;