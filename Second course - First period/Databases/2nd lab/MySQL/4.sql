USE Labor_SQL;

SELECT DISTINCT maker from Product WHERE model in (SELECT model FROM PC);
