SELECT DISTINCT maker FROM Product A INNER JOIN PC ON A.model = PC.model AND PC.speed >= 750
