DROP PROCEDURE getRandDataToTwoTables;
CREATE PROCEDURE getRandDataToTwoTables()
  BEGIN
    DECLARE zoneName VARCHAR(100) DEFAULT NULL;
    DECLARE flag INT DEFAULT 0;
    DECLARE Expression VARCHAR(100);

    DECLARE tCursor CURSOR FOR SELECT name FROM influence_zone;
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET flag = 1;

    CREATE TEMPORARY TABLE TempTable_1(id SERIAL, name varchar(100), created_at TIMESTAMP DEFAULT current_timestamp(0));
    CREATE TEMPORARY TABLE TempTable_2(id SERIAL, name varchar(100), created_at TIMESTAMP DEFAULT current_timestamp(0));

    OPEN tCursor;

    REPEAT
      FETCH tCursor INTO zoneName;

      SET @Expression = CONCAT('INSERT INTO TempTable_', FLOOR(RAND() * 2 + 1), '(name) VALUES ("', zoneName, '");');
      PREPARE myquery FROM @Expression;
      EXECUTE myquery;

      UNTIL flag
    END REPEAT;

    SELECT * FROM TempTable_1;
    SELECT * FROM TempTable_2;

    DROP TABLE TempTable_1, TempTable_2;

    CLOSE tCursor;
  END;

CALL getRandDataToTwoTables();
