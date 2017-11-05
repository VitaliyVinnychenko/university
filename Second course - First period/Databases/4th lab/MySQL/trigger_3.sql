DELIMITER //
DROP TRIGGER IF EXISTS check_medicines;

CREATE TRIGGER check_medicines
BEFORE INSERT ON medicines
FOR EACH ROW
  BEGIN
    IF NEW.ministery_code NOT LIKE '[А-Яа-я]{2}\-[0-9]{3}\-[0-9]{2}' THEN
      SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'WRONG ministery_code VALUE';
    END IF;
  END //
DELIMITER ;
