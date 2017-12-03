SELECT DISTINCT maker FROM Product p
  WHERE type = 'Laptop' AND model IN (SELECT model FROM Laptop l WHERE speed >= 600 AND l.model = p.model)
