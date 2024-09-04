CREATE SCHEMA IF NOT EXISTS modsen;

CREATE TABLE IF NOT EXISTS modsen.refresh_token(
    user_id int primary key,
    refresh_token UUID not null,
    update_time TimeStamp not null,
    expiration_time TimeStamp not null
);