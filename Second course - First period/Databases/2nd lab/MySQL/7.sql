USE Labor_SQL;

SELECT DISTINCT Product.type, Laptop.model, Laptop.speed
FROM Laptop
INNER JOIN Product ON Product.type = 'Laptop'
WHERE Laptop.speed < ALL (SELECT speed FROM PC);
