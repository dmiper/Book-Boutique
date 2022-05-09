--liquibase formatted sql

create table schema.authors
(
    id        bigserial    not null,
    full_name varchar(255) not null,
    primary key (id)
)

