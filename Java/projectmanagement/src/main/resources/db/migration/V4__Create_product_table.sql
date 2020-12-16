create table product ( 
  	product_id int not null primary key auto_increment, 
    product_name varchar(100) not null,
    price int not null, 
    size int not null,
    weight int not null,
  	storage_location int,
    foreign key (storage_location) references storages (storage_location));
    