USE Labor_SQL;

SELECT Product.maker, PC.model, PC.price FROM PC INNER JOIN Product ON PC.model = Product.model;
