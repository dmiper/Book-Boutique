--liquibase formatted sql

create table schema.order_details
(
    id               bigserial not null,
    price            int8      not null,
    quantity         int8      not null,
    book_id          int8,
    order_details_id int8,
    primary key (id)
)