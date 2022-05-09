--liquibase formatted sql

create table schema.books
(
    id                  bigserial    not null,
    number_of_pages     int8         not null,
    price               int8         not null,
    title               varchar(255) not null,
    year_of_publication date         not null,
    author_id           int8,
    book_warehouse_id   int8         not null,
    primary key (id)
)