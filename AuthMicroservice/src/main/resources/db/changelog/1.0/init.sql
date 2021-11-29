create table users
(
    id bigserial,
    email varchar(255) not null,
    first_name varchar(100) not null,
    last_name varchar(100) not null,
    password varchar(255) not null,
    role varchar(100) default 'user' not null,
    status boolean default true not null
);

create unique index users_email_uindex
    on users (email);

create unique index users_id_uindex
    on users (id);

alter table users
    add constraint users_pk
        primary key (id);

create table orders
(
    id bigserial,
    product_name varchar(255) not null,
    quantity int not null
);

create unique index orders_id_uindex
    on orders (id);

alter table orders
    add constraint orders_pk
        primary key (id);


INSERT INTO users (id, email, first_name, last_name, password, role, status)
VALUES (1, 'admin@mail.ru', 'Admin', 'Adminov', '$2a$12$1YcRLjs42qfmgYtlzsOIAuzqUqZfNvt1j0J38yykxYiRpxNbZuGvO', 'ADMIN',
        true);

INSERT INTO users (id, email, first_name, last_name, password, role, status)
VALUES (2, 'user@mail.ru', 'User', 'Userov', '$2a$12$Z1I65qUogoU6lL7d2oWEee6jZxBzOKVCz.lwxj.KP9ELaqGBzWWCi', 'USER',
        true);

INSERT INTO users (id, email, first_name, last_name, password, role, status)
VALUES (3, 'testStatus@mail.ru', 'User', 'Userov', '$2a$12$Z1I65qUogoU6lL7d2oWEee6jZxBzOKVCz.lwxj.KP9ELaqGBzWWCi', 'USER',
        false);


INSERT INTO orders (id, product_name, quantity)
VALUES (1, 'table', 14);

INSERT INTO orders (id, product_name, quantity)
VALUES (2, 'book', 32);

INSERT INTO orders (id, product_name, quantity)
VALUES (3, 'phone', 9);