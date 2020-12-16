create table delivery ( 
    delivery_id int not null primary key auto_increment,
    max_weight int,
    customer_id int not null,
    delivery_date date not null, 
    delivery_address varchar(100) not null,
    foreign key (customer_id) references customer (customer_id));