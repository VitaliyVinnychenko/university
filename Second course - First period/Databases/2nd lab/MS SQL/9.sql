SELECT trip_no, c.name, plane, town_from, town_to, duration =
                CASE
                  WHEN DATEPART(HOUR, (time_in - time_out)) < 10 AND DATEPART(MINUTE, (time_in - time_out)) < 10
                    THEN CONCAT('0', DATEPART(HOUR, (time_in - time_out)), ':0', DATEPART(MINUTE, (time_in - time_out)))
                  WHEN DATEPART(HOUR, (time_in - time_out)) < 10
                    THEN CONCAT('0', DATEPART(HOUR, (time_in - time_out)), ':', DATEPART(MINUTE, (time_in - time_out)))
                  WHEN DATEPART(MINUTE, (time_in - time_out)) < 10
                    THEN CONCAT(DATEPART(HOUR, (time_in - time_out)), ':0', DATEPART(MINUTE, (time_in - time_out)))
                  ELSE CONCAT(DATEPART(HOUR, (time_in - time_out)), ':', DATEPART(MINUTE, (time_in - time_out)))
                END
  FROM Trip t INNER JOIN Company c ON c.ID_comp = t.ID_comp
