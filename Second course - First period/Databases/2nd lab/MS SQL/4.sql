SELECT ship, battle, b.date FROM Outcomes o INNER JOIN Battles b
    ON b.name = o.battle AND (o.result = 'OK' OR o.result = 'sunk') AND o.ship IN
      (SELECT ship FROM Outcomes o2 WHERE o2.result = 'damaged')
