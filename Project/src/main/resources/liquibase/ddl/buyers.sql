--liquibase formatted sql

create table schema.buyers
(
    id                bigserial not null,
    date_of_birth     date      not null,
    date_registration date      not null,
    first_name        varchar(255),
    last_name         varchar(255),
    primary key (id)
)