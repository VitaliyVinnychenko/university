CREATE TRIGGER sub_trg_2
ON test.disciplines
INSTEAD OF INSERT
AS
BEGIN
  DECLARE @exam_type INT
  DECLARE @name NVARCHAR(50)
  DECLARE @period_number INT
  DECLARE @ssid NVARCHAR(20)

  SELECT @exam_type = exam_type, @name = name, @period_number = period_number, @ssid = ssid FROM inserted

  IF NOT EXISTS(SELECT id FROM test.exam_types WHERE id = @exam_type) OR
    EXISTS(SELECT * FROM test.disciplines WHERE name = @name)
    BEGIN
      ROLLBACK TRANSACTION
    END
  ELSE
    BEGIN
      DECLARE @_id INT = (SELECT id FROM test.exam_types WHERE id = @exam_type)

      SET IDENTITY_INSERT test.employees OFF
      INSERT INTO test.disciplines (name, period_number, ssid, exam_type)
        VALUES (@name, @period_number, @ssid, @_id)
    END
END
GO
