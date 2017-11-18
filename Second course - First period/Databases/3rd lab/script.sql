CREATE DATABASE IF NOT EXISTS lab_3;
USE lab_3;

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
CREATE TRIGGER upd_check BEFORE INSERT ON pharmacyFOR EACH ROW
    BEGIN
        SET NEW.phone = CONCAT('(', SUBSTRING(NEW.phone, 1, 3), ') ',
                        SUBSTRING(NEW.phone, 4, 3), '-', SUBSTRING(NEW.phone, 7, 2), '-',
                        substring(NEW.phone, -2));
    END;


CREATE TABLE IF NOT EXISTS medicines
(
    id             INT AUTO_INCREMENT
      PRIMARY KEY,
    name           VARCHAR(150) NOT NULL,
    instruction    TEXT         NOT NULL,
    number_in_pack INT          NOT NULL,
    packing        VARCHAR(100) NOT NULL,
    image          VARCHAR(100) NULL,
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
CREATE INDEX pharmacy_has_medicines_pharmacy_id_fk
  ON pharmacy_has_medicines (pharmacy_id);

  CREATE TRIGGER trigger_name
  BEFORE INSERT ON pharmacy_has_medicines
  FOR EACH ROW
    BEGIN
      IF new.number_of_medicine < 0 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'The number of medicines cannot ne lass the zero!', MYSQL_ERRNO = 1001;
      END IF;
    END;
