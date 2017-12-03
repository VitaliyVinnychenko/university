CREATE FUNCTION test.getPosition(@id INT)
  RETURNS NVARCHAR(50)
  BEGIN
    DECLARE @result NVARCHAR(50)
    SELECT @result = name FROM test.positions WHERE id = @id

    RETURN @result
  END
GO

SELECT first_name, last_name, middle_name, passport_id, test.getPosition(possition_id) AS position FROM test.employees;
