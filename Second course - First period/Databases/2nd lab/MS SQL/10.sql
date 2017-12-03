SELECT ship as name from Outcomes WHERE LEN(ship)-LEN(REPLACE(ship, ' ', ''))  > 0
  UNION (SELECT name from Ships WHERE LEN(name)-LEN(REPLACE(name, ' ', '')) > 0)
