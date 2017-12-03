CREATE FUNCTION test.avgExperience()
  RETURNS int
  BEGIN
    DECLARE @result INT
    SELECT @result = AVG(experience) FROM test.employees;

    RETURN @result;
  END
GO

SELECT * FROM test.employees WHERE experience > test.avgExperience();
