DELIMITER //
DROP TRIGGER IF EXISTS delete_street;

CREATE TRIGGER delete_street
BEFORE DELETE ON street
FOR EACH ROW
  BEGIN
    INSERT INTO street_deletion_log (name) VALUE (OLD.name);
  END //
DELIMITER ;
