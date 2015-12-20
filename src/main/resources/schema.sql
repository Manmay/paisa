/* table : user */
create table users (
    id integer auto_increment not null primary key,
    first_name varchar(128) not null,
    last_name varchar(128) not null,
    phone varchar(16) not null,
    email varchar(32) not null,
    password varchar(32) not null,
    role varchar(16) not null, 
    enabled boolean not null 
);


/* table : loanTypes */
create table loan_types (
    id integer auto_increment not null primary key, 
    name varchar(64) not null, 
    description varchar(512),
    image varchar(128)
);