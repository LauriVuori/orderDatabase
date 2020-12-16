create table orders ( 
    order_date date not null,
    order_id int not null primary key auto_increment,
  	delivery_id int,
  	customer_id int,
    foreign key (delivery_id) references delivery (delivery_id),
    foreign key (customer_id) references customer (customer_id));
    