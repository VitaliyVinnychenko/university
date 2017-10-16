USE Labor_SQL;

SELECT maker,
	CASE WHEN sum(case type when 'Laptop' then 1 else 0 end) = 1
		THEN 'yes'
	ELSE CASE WHEN sum(case type when 'Laptop' then 1 else 0 end) > 1
		THEN CONCAT('yes(', sum(case type when 'Laptop' then 1 else 0 end), ')')
			ELSE 'no' END END AS 'laptop'
FROM Product GROUP BY maker;
