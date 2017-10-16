USE Labor_SQL;

SELECT DISTINCT maker
FROM Product
WHERE model = ANY (SELECT model FROM Laptop)
			AND maker = ANY (SELECT maker FROM Product
                WHERE model = ANY (SELECT model FROM Printer));
