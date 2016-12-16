SELECT pg_terminate_backend(pid)
FROM pg_stat_activity
WHERE datname = 'regress'
      AND pid <> pg_backend_pid()
      AND state = 'idle'
      AND state_change < current_timestamp - INTERVAL '3' MINUTE;

SELECT pg_terminate_backend(pg_stat_activity.pid)
FROM pg_stat_activity
WHERE pg_stat_activity.datname = 'TARGET_DB'
      AND pid <> pg_backend_pid();

SELECT pg_terminate_backend(pg_stat_activity.pid)
FROM pg_stat_activity