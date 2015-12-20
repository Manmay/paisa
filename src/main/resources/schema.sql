/* table : user */
create table users (
    id integer auto_increment not null primary key,
    first_name varchar(128) not null,
    last_name varchar(128) not null,
    email varchar(32) not null,
    phone_number varchar(16) not null,
    password varchar(32) not null, 
    enabled boolean not null 
);


/* table : login */
create table login (
    id integer auto_increment not null primary key,
    user_id integer not null,
    user_name varchar(64) not null, 
    password varchar(32) not null,
    role varchar(16) not null,
    constraint login_fk1 foreign key (user_id) references users(id)
);

/* table : loanTypes */
create table loan_types (
    id integer auto_increment not null primary key, 
    name varchar(64) not null, 
    description varchar(512),
    image varchar(128)
);