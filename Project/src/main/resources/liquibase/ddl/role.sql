--liquibase formatted sql

create table schema.role
(
    id   bigserial    not null,
    role varchar(255) not null,
    primary key (id)
)