CREATE DATABASE IF NOT EXISTS lab_5;
USE lab_5;

CREATE TABLE IF NOT EXISTS street
(
  id   INT AUTO_INCREMENT
    PRIMARY KEY,
  name VARCHAR(50) NOT NULL,
  CONSTRAINT street_id_uindex
  UNIQUE (id)
);


CREATE TABLE IF NOT EXISTS pharmacy
(
  id              INT AUTO_INCREMENT
    PRIMARY KEY,
  name            VARCHAR(50)  NOT NULL,
  phone           VARCHAR(15)  NOT NULL,
  owner_full_name VARCHAR(100) NOT NULL,
  street_id       INT          NOT NULL,
  CONSTRAINT pharmacy_id_uindex
  UNIQUE (id),
  CONSTRAINT pharmacy_street_id_fk
  FOREIGN KEY (street_id) REFERENCES street (id)
);

CREATE INDEX pharmacy_street_id_fk
  ON pharmacy (street_id);

CREATE TRIGGER upd_check BEFORE INSERT ON pharmacy FOR EACH ROW
    BEGIN
        SET NEW.phone = CONCAT('(', SUBSTRING(NEW.phone, 1, 3), ') ',
                        SUBSTRING(NEW.phone, 4, 3), '-', SUBSTRING(NEW.phone, 7, 2), '-',
                        substring(NEW.phone, -2));
    END;


CREATE TABLE medicines
(
  id             INT AUTO_INCREMENT
    PRIMARY KEY,
  name           VARCHAR(150) NOT NULL,
  instruction    TEXT         NOT NULL,
  number_in_pack INT          NOT NULL,
  packing        VARCHAR(100) NOT NULL,
  CONSTRAINT medicines_id_uindex
  UNIQUE (id)
);


CREATE TABLE IF NOT EXISTS pharmacy_has_medicines
(
  pharmacy_id        INT NOT NULL,
  medicine_id        INT NULL,
  number_of_medicine INT NULL,
  CONSTRAINT pharmacy_has_medicines_pharmacy_id_fk
  FOREIGN KEY (pharmacy_id) REFERENCES pharmacy (id),
  CONSTRAINT pharmacy_has_medicines_medicines_id_fk
  FOREIGN KEY (medicine_id) REFERENCES medicines (id)
);

CREATE INDEX pharmacy_has_medicines_medicines_id_fk
  ON pharmacy_has_medicines (medicine_id);


INSERT INTO street (name) VALUES ('Наукова'),('Городоцька'),('Степана Бандери'),('Кульпарківська'),('Пулюя'),
  ('Дорошенка'),('Листопадового Чину');

INSERT INTO medicines (name, instruction, number_in_pack, packing) VALUES
  ('Лорапемід', 'N/A', 15, 'N/A'),
  ('Ношпа', 'N/A', 10, 'N/A'),
  ('Ніфуруксазіт', 'N/A', 8, 'N/A'),
  ('Парацитамол', 'N/A', 12, 'N/A'),
  ('Цитрамон', 'N/A', 15, 'N/A'),
  ('Мультигрип', 'N/A', 10, 'N/A');

INSERT INTO pharmacy (name, phone, owner_full_name, street_id) VALUES
  ('Аптека 1', '1234567890', 'Вінниченко Віталій Вікторович', 1),
  ('Аптека 2', '0987654321', 'Мацях Микола Ярославович', 2);

INSERT INTO pharmacy_has_medicines (pharmacy_id, medicine_id, number_of_medicine) VALUES
  (1, 3, 20),
  (1, 1, 7),
  (2, 6, 113);


DELIMITER //
DROP PROCEDURE IF EXISTS InsertPharmacy;

CREATE PROCEDURE InsertPharmacy
(
IN name_in varchar(50),
IN phone_in varchar(15),
IN owner_full_name_in VARCHAR(100),
in street_in VARCHAR(15)
)
BEGIN
	DECLARE msg varchar(40);

  IF NOT EXISTS( SELECT * FROM street WHERE name=street_in)
    THEN SET msg = 'This street is absent';
  ELSEIF LENGTH(phone_in) <> 10
    THEN SET msg = 'Phone number should consists of 10 digits';
  ELSE
		INSERT pharmacy (name, phone, owner_full_name, street_id)
        Value ( name_in, phone_in, owner_full_name_in,
			     (SELECT id FROM street WHERE street.name=street_in) );
		SET msg = 'OK';

	END IF;

	SELECT msg AS msg;

END //
DELIMITER ;