

create database users_db;

use users_db;

create table users(
    first_name varchar(15) not null,
    last_name varchar(20) not null,
    email varchar(40) not null,
    phone varchar(20),
    company varchar(20),
    pass varchar(257) not null,
    primary key (email)
);