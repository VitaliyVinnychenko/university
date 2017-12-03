SELECT DISTINCT P1.model, P2.model
  FROM PC P1, PC P2
  WHERE P1.model <> P2.model AND P1.speed = P2.speed AND P1.ram = P2.ram AND P1.code < P2.code
