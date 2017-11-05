DELIMITER //
DROP FUNCTION IF EXISTS avgExp;

CREATE FUNCTION avgExp()
  RETURNS INT
  BEGIN
    DECLARE avgYears INT;
    SELECT AVG(experience_years) INTO avgYears FROM employees;

    RETURN avgYears;
  END;

DELIMITER ;

SELECT full_name, uuid, passport_id, experience_years, login from employees WHERE experience_years > avgExp();
