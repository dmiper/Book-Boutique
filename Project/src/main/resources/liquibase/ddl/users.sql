--liquibase formatted sql

create table schema.users
(
    id            bigserial    not null,
    email         varchar(255) not null unique ,
    hash_password varchar(255) not null,
    login_name    varchar(255) not null unique ,
    buyer_id      int8,
    role_id       int8,
    primary key (id),

    foreign key (buyer_id) references schema.buyers,
    foreign key (role_id) references schema.role
);
