SELECT 
    machine_id,
    ROUND(AVG(duration), 3) AS processing_time
FROM (
    SELECT 
        a.machine_id,
        (b.timestamp - a.timestamp) AS duration
    FROM Activity a
    JOIN Activity b
        ON a.machine_id = b.machine_id
        AND a.process_id = b.process_id
    WHERE a.activity_type = 'start'
      AND b.activity_type = 'end'
) AS durations
GROUP BY machine_id;
