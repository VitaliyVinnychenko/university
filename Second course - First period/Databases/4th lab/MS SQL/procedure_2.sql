CREATE PROCEDURE test.tableWithRandNames AS
  BEGIN
    DECLARE @cnt INT = 0;
    DECLARE @name NVARCHAR(50)

    WHILE @cnt < 10
    BEGIN
      SET @name = 'Noname' + CAST(ROUND(RAND() * 1000 + 1, 0) AS NVARCHAR(50))

      IF NOT EXISTS(SELECT * FROM test.degrees WHERE name = @name)
        BEGIN
          INSERT INTO test.degrees VALUES (@name)
          SET @cnt = @cnt + 1;
        END
    END;
  END
GO
