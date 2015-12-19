create table users (
    id integer auto_increment not null primary key,
    first_name varchar(128) not null,
    last_name varchar(128) not null,
    email varchar(32) not null, 
    password varchar(32) not null, 
    role varchar(16) not null,
    enabled boolean not null 
);