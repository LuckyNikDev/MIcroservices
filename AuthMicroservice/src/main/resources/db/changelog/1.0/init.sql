create table users
(
    id bigserial,
    email varchar(255) not null,
    first_name varchar(100) not null,
    last_name varchar(100) not null,
    password varchar(255) not null,
    role varchar(100) default 'user' not null,
    status varchar(30) default 'ACTIVE' not null
);

create unique index users_email_uindex
    on users (email);

create unique index users_id_uindex
    on users (id);

alter table users
    add constraint users_pk
        primary key (id);


INSERT INTO users (id, email, first_name, last_name, password, role, status)
VALUES (1, 'admin@mail.ru', 'Admin', 'Adminov', '$2a$12$1YcRLjs42qfmgYtlzsOIAuzqUqZfNvt1j0J38yykxYiRpxNbZuGvO', 'ADMIN',
        'ACTIVE');

INSERT INTO users (id, email, first_name, last_name, password, role, status)
VALUES (2, 'user@mail.ru', 'User', 'Userov', '$2a$12$Z1I65qUogoU6lL7d2oWEee6jZxBzOKVCz.lwxj.KP9ELaqGBzWWCi', 'USER',
        'ACTIVE');

INSERT INTO users (id, email, first_name, last_name, password, role, status)
VALUES (3, 'testStatus@mail.ru', 'User', 'Userov', '$2a$12$Z1I65qUogoU6lL7d2oWEee6jZxBzOKVCz.lwxj.KP9ELaqGBzWWCi', 'USER',
        'BANNED');