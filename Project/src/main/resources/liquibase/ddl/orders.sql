--liquibase formatted sql

create table schema.orders
(
    id              bigserial not null,
    purchase_amount int8      not null,
    buyers_id       int8,
    primary key (id)
)