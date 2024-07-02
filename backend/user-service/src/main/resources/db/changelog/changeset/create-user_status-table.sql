CREATE schema IF NOT EXISTS modsen;
CREATE TABLE IF NOT EXISTS modsen.user_status
(
    id int NOT NULL primary key,
    status varchar(128) NOT NULL UNIQUE
);

alter table modsen.user
    add status_id integer;

alter table modsen.user
    add constraint user_status_fk
        foreign key (status_id) references modsen.user_status(id);