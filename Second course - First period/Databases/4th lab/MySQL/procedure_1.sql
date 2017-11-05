DELIMITER //
DROP PROCEDURE IF EXISTS InsertPharmacy//

CREATE PROCEDURE InsertPharmacy(
  IN _name VARCHAR(100),
  IN _house_number INT(11),
  IN _schedule VARCHAR(45),
  IN _free_saturday TINYINT(4),
  IN _free_sunday TINYINT(4),
  IN _website VARCHAR(150),
  IN _street_name VARCHAR(100)
)
  BEGIN
    INSERT INTO pharmacy (name, house_number, schedule, free_saturday, free_sunday, website, street_name)
    VALUES (_name, _house_number, _schedule, _free_saturday, _free_sunday, _website, _street_name);
  END //

DELIMITER ;
