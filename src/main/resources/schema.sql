CREATE TABLE IF NOT EXISTS User (
    id BIGINT PRIMARY KEY auto_increment,
    username VARCHAR(128) UNIQUE,
    password VARCHAR(256),
    salary BIGINT,
    age INT
);
