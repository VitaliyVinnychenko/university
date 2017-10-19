USE Labor_SQL;

(SELECT DISTINCT name, class FROM Ships)
UNION
(SELECT DISTINCT Outcomes.ship, Classes.class
    FROM Outcomes
    INNER JOIN Classes ON Classes.class = Outcomes.ship
) ORDER BY name, class ASC;
