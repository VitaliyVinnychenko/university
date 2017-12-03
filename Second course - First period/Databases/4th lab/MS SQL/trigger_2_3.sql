CREATE TRIGGER sub_trg_1
ON test.employees
INSTEAD OF INSERT
AS
BEGIN
  DECLARE @ln NVARCHAR(20)
  DECLARE @fn NVARCHAR(20)
  DECLARE @mn NVARCHAR(20)
  DECLARE @pid NVARCHAR(10)
  DECLARE @exp INT
  DECLARE @bd DATE
  DECLARE @ri INT
  DECLARE @di INT
  DECLARE @pi INT

  SELECT @pid = passport_id, @ln = last_name, @fn = first_name, @mn = middle_name, @exp = experience,
    @bd = birth_date, @pi = possition_id, @di = degree_id, @ri = rank_id FROM inserted

  IF @ln LIKE N'%вай' OR @ln LIKE N'%ва'
    BEGIN
      ROLLBACK TRANSACTION;
    END
  ELSE
    BEGIN
      SET IDENTITY_INSERT test.employees OFF
      INSERT INTO test.employees (passport_id, first_name, last_name, middle_name, experience,
                                  birth_date, possition_id, degree_id, rank_id)
        VALUES ((CONCAT(LEFT(@pid , 2), ' ', RIGHT(@pid, 8))), @fn, @ln, @mn, @exp, @bd, @pi, @di, @ri)
    END
END
GO
