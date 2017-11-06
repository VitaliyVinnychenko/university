CREATE TRIGGER save_db_structure
BEFORE INSERT ON employees
FOR EACH ROW
  BEGIN
    INSERT INTO job_level (name) VALUES (NEW.job_level);
  END;
