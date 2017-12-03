SELECT maker FROM Product p WHERE type = 'PC' GROUP BY maker HAVING COUNT(model) > 1
