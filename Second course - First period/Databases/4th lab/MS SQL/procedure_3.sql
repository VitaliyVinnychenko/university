CREATE PROCEDURE test.dynamicTable AS
  BEGIN
    CREATE TABLE #Table (id INT)
    DECLARE @name NVARCHAR(50)

    DECLARE positions_cursor CURSOR FOR
    SELECT name
    FROM test.positions;

    OPEN positions_cursor

    FETCH NEXT FROM positions_cursor
    INTO @name

    WHILE @@FETCH_STATUS = 0
    BEGIN
      EXEC ('ALTER TABLE #Table ADD ' + @name  +' INT')

      FETCH NEXT FROM positions_cursor INTO @name
    END
    CLOSE positions_cursor;
    DEALLOCATE positions_cursor;

    SELECT * FROM #Table
  END
GO
