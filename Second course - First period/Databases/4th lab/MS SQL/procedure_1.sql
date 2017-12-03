CREATE PROCEDURE test.InsertEmployee
  @first_name NVARCHAR(50),
  @last_name NVARCHAR(50),
  @middle_name NVARCHAR(50),
  @experience INT,
  @birth_date DATE,
  @passport_id NCHAR(10),
  @rank_id INT,
  @degree_id INT,
  @possition_id INT
AS
  BEGIN
    INSERT INTO test.employees VALUES
    (@first_name, @last_name, @middle_name, @experience, @birth_date, @passport_id, @rank_id, @degree_id, @possition_id)
  END
GO

EXEC test.InsertEmployee 'dsfsdfsd', 'sdfdsfsdf', 'sdfdsfsdf', 1, '2010-11-17', 'qw123456', 1, 1, 1
