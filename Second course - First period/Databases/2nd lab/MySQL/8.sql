USE Labor_SQL;

SELECT Ships.name, Classes.country
FROM Ships
	INNER JOIN Classes ON Classes.class = Ships.class
WHERE Ships.name IN (SELECT ship FROM Outcomes WHERE result = 'sunk');
