# use JDBC_DAO;

delete from orders;
delete from customers;

insert into CUSTOMERS values (1, 'alexey', 'popov', 32, '+79998887766');
insert into CUSTOMERS values (2, 'Alexey', 'Ivanov', 18, '+79997776655');
insert into CUSTOMERS values (3, 'ALEXEY', 'SIDOROV', 73, '+79996665544');
insert into CUSTOMERS values (4, 'ivan', 'bychkov', 44, '+79995554433');
insert into CUSTOMERS values (5, 'Ivan', 'Petrov', 51, '+79994443322');

insert into ORDERS (date, customer_id, product_name, amount)
values ('13.01.2017',
        (select id from CUSTOMERS where id = 1),
        'shampoo',
        2);

insert into ORDERS (date, customer_id, product_name, amount)
values ('22.01.017',
        (select id from CUSTOMERS where id = 2),
        'cheese',
        300);

insert into ORDERS (date, customer_id, product_name, amount)
values ('01.01.2017',
        (select id from CUSTOMERS where id = 3),
        'hat',
        1);

insert into ORDERS (date, customer_id, product_name, amount)
values ('15.02.2017',
        (select id from CUSTOMERS where id = 4),
        'watch',
        1);

insert into ORDERS (date, customer_id, product_name, amount)
values ('08.03.2017',
        (select id from CUSTOMERS where id = 5),
        'flowers',
        99);

insert into ORDERS (date, customer_id, product_name, amount)
values ('14.01.2017',
        (select id from CUSTOMERS where id = 1),
        'toothpaste',
        2);

insert into ORDERS (date, customer_id, product_name, amount)
values ('23.03.2017',
        (select id from CUSTOMERS where id = 4),
        'socks',
        5);