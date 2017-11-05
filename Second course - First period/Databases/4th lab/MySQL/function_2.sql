DELIMITER //
DROP FUNCTION IF EXISTS getJobLevelName;

CREATE FUNCTION getJobLevelName(_id INT)
  RETURNS VARCHAR(100)
  BEGIN
    DECLARE _name VARCHAR(100);
    SELECT name INTO _name FROM job_level WHERE id = _id;

    RETURN _name;
  END;

DELIMITER ;


SELECT full_name, uuid, passport_id, experience_years, login, getJobLevelName(job_level) AS job_level from employees;
