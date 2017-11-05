DELIMITER //
DROP PROCEDURE IF EXISTS ShowPharmacyMedicines//

CREATE PROCEDURE ShowPharmacyMedicines(IN _name VARCHAR(150))
  BEGIN


    IF _name IS NULL OR _name = '' THEN
     SELECT * FROM pharmacy_has_medicines;
    ELSE
      SELECT * FROM pharmacy_has_medicines WHERE medicines_name = _name;
    END IF;
  END //
DELIMITER ;
