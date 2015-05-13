CREATE TABLE IF NOT EXISTS access_log
(
    TIME BIGINT PRIMARY KEY NOT NULL,
    ID TEXT NOT NULL,
    LOCATION TEXT NOT NULL
) AS SELECT * FROM CSVREAD('classpath:db/cardswipe.csv');