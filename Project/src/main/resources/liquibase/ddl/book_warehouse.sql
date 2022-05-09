--liquibase formatted sql

create table schema.book_warehouse
(
    id                    bigserial not null,
    the_rest_of_the_books int8      not null,
    version               int8,
    primary key (id)
)