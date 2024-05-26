# create schema JDBC_DAO;
# use JDBC_DAO;
create table CUSTOMERS (
                           id int auto_increment,
                           name varchar(100),
                           surname varchar(100),
                           age int,
                           phone_number varchar(100),
                           primary key (id)
);

create table ORDERS (
                        id int auto_increment,
                        date varchar(100),
                        customer_id int,
                        product_name varchar(100),
                        amount int,
                        primary key (id),
                        foreign key (customer_id)
                            references CUSTOMERS (id)
);