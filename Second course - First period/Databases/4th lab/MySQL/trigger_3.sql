DELIMITER //
DROP TRIGGER IF EXISTS check_medicines;

CREATE TRIGGER check_medicines
BEFORE INSERT ON medicines
FOR EACH ROW
  BEGIN
    IF NEW.ministery_code LIKE '^([^\u041C\u041F\u043C\u043F]{2})\-(\d{3})\-(\d{2})' THEN
      SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'WRONG ministery_code VALUE';
    END IF;
  END //
DELIMITER ;
