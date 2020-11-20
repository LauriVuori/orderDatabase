CREATE TABLE CUSTOMER ( 
    CUSTOMERID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    COMPANY VARCHAR(100) NOT NULL,
    FORENAME VARCHAR(100), 
    SURNAME VARCHAR(100), 
    ADDRESS VARCHAR(100) NOT NULL);

CREATE TABLE STORAGES ( 
    STORAGELOCATION INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    CAPACITY INT NOT NULL,
    PRODUCTNAME VARCHAR(100));

CREATE TABLE DELIVERY ( 
    MAXWEIGHT INT NOT NULL,
    MAXSIZE INT NOT NULL, 
    DELIVERY_DATE DATE NOT NULL, 
    DELIVERY_ADDRESS VARCHAR(100) NOT NULL,
    DELIVERYID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    CUSTOMERID INT,
    FOREIGN KEY (CUSTOMERID) REFERENCES CUSTOMER (CUSTOMERID));

CREATE TABLE PRODUCT ( 
  	PRODUCTID INT NOT NULL PRIMARY KEY AUTO_INCREMENT, 
    PRODUCTNAME VARCHAR(100) NOT NULL,
    PRICE INT NOT NULL, 
    SIZE INT NOT NULL,
    WEIGHT INT NOT NULL,
  	STORAGELOCATION INT,
    FOREIGN KEY (STORAGELOCATION) REFERENCES STORAGES (STORAGELOCATION));

CREATE TABLE ORDERS ( 
    ORDERDATE DATE NOT NULL,
    ORDERID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  	DELIVERYID INT,
  	CUSTOMERID INT,
    FOREIGN KEY (DELIVERYID) REFERENCES DELIVERY (DELIVERYID),
    FOREIGN KEY (CUSTOMERID) REFERENCES CUSTOMER (CUSTOMERID));


CREATE TABLE ORDERPRODUCT(
    ORDERPRODUCT BIGINT NOT NULL,
    PRODUCTCOUNT INT,
    PRODUCTID INT,
    ORDERID INT,
    FOREIGN KEY (PRODUCTID) REFERENCES PRODUCT (PRODUCTID),
    FOREIGN KEY (ORDERID) REFERENCES ORDERS (ORDERID));





INSERT INTO ORDERPRODUCT (ORDERPRODUCT, PRODUCTCOUNT) VALUES (325325, 2);

INSERT INTO CUSTOMER (COMPANY, FORENAME, SURNAME, ADDRESS) VALUES ('RyoUkot', 'Petteri', 'Kivi', 'Kuja 2');
INSERT INTO CUSTOMER (COMPANY, FORENAME, SURNAME, ADDRESS) VALUES ('RyoUkot', 'Pete', 'Oja', 'Kuja 3');
INSERT INTO CUSTOMER (COMPANY, FORENAME, SURNAME, ADDRESS) VALUES ('Ryoäijät', 'Topi', 'Saha', 'Tie 15');

INSERT INTO DELIVERY (MAXSIZE, MAXWEIGHT, DELIVERY_DATE, DELIVERY_ADDRESS) VALUES (100, 100, '2020-06-14' , 'Kotikuja 13, 65200 VAASA');
INSERT INTO DELIVERY (MAXSIZE, MAXWEIGHT, DELIVERY_DATE, DELIVERY_ADDRESS) VALUES (100, 100, '2020-06-16' , 'Kotikuja 54, 65200 VAASA');
INSERT INTO DELIVERY (MAXSIZE, MAXWEIGHT, DELIVERY_DATE, DELIVERY_ADDRESS) VALUES (100, 150, '2020-02-16' , 'Kotikuja 535, 54533 SEINAJOKI');

INSERT INTO ORDERS (ORDERDATE) VALUES ('2020-04-14');
INSERT INTO ORDERS (ORDERDATE) VALUES ('2020-04-12');

INSERT INTO STORAGES (CAPACITY, PRODUCTNAME) VALUES (5, 'Tuoli');
INSERT INTO STORAGES (CAPACITY, PRODUCTNAME) VALUES (5, 'Kiikku');
INSERT INTO STORAGES (CAPACITY, PRODUCTNAME) VALUES (5, 'Sänky');
INSERT INTO STORAGES (CAPACITY, PRODUCTNAME) VALUES (5, 'Sohva');

INSERT INTO PRODUCT (PRODUCTNAME, PRICE, SIZE, WEIGHT, STORAGELOCATION) VALUES ('Sohva', 900, 80, 1, 4);
INSERT INTO PRODUCT (PRODUCTNAME, PRICE, SIZE, WEIGHT, STORAGELOCATION) VALUES ('Sänky', 800, 90, 2, 3);
INSERT INTO PRODUCT (PRODUCTNAME, PRICE, SIZE, WEIGHT, STORAGELOCATION) VALUES ('Tuoli', 450, 90, 2, 1); 
INSERT INTO PRODUCT (PRODUCTNAME, PRICE, SIZE, WEIGHT, STORAGELOCATION) VALUES ('Kiikku', 620, 90, 2, 2);
INSERT INTO PRODUCT (PRODUCTNAME, PRICE, SIZE, WEIGHT) VALUES ('Jakkara', 50, 90, 2);

UPDATE ORDERS SET DELIVERYID = 2 WHERE ORDERID = 1;
UPDATE ORDERS SET DELIVERYID = 1 WHERE ORDERID = 2;
UPDATE ORDERS SET CUSTOMERID = 1 WHERE ORDERID = 1;
UPDATE ORDERS SET CUSTOMERID = 2 WHERE ORDERID = 2;
UPDATE DELIVERY SET CUSTOMERID = 2 WHERE DELIVERYID = 1;
UPDATE DELIVERY SET CUSTOMERID = 1 WHERE DELIVERYID = 2;


UPDATE ORDERS SET ORDERDATE = '2020-03-12' WHERE ORDERID = 1;
UPDATE CUSTOMER SET COMPANY = 'terve.fi' WHERE COMPANY = 'RyoUkot';
UPDATE PRODUCT SET WEIGHT = 15 WHERE PRODUCTID = 1;

UPDATE DELIVERY SET CUSTOMERID = 1 WHERE DELIVERYID = 1;
UPDATE DELIVERY SET CUSTOMERID = 2 WHERE DELIVERYID = 2;
UPDATE DELIVERY SET CUSTOMERID = 3 WHERE DELIVERYID = 3;

UPDATE ORDERS SET CUSTOMERID = '1' WHERE ORDERID = '1';
UPDATE ORDERS SET CUSTOMERID = '2' WHERE ORDERID = '2';

DELETE FROM CUSTOMER WHERE FORENAME = 'Petteri';
DELETE FROM PRODUCT WHERE PRODUCTID = 1;
DELETE FROM ORDERS WHERE ORDERID = 1;

ALTER TABLE PRODUCT ADD COLOUR VARCHAR(100);
ALTER TABLE DELIVERY DROP COLUMN MAXSIZE;

-- SELECT ASIAKAS.ID, ASIAKAS.ETUNIMI, ASIAKAS.SUKUNIMI, LAINA.LAINAPVM, KIRJA.KIRJANIMI FROM ASIAKAS, LAINA, KIRJA WHERE ASIAKAS.id = LAINA.asiakasid and LAINA.kirjaid = KIRJA.id

-- autoincrement id ehkä??
-- sijoitetaan customer tauluun-->
-- INSTERT INTO CUSTOMER (CUSTOMERID, COMPANY, FORENAME) VALUES (12345, 6789, "VILLEPETTERI"); 
-- avataan customer näkyviin
-- SELECT * FROM CUSTOMER;
-- poistetaan customer taulu
-- DROP TABLE CUSTOMER;
--1. Create tables that doesnt have foreign keys(viiteavaimia muihin tauluihin)
-- assosiatiivinen taulu(2 viiteavainta, täyty luoda taulut, joista viiteavaimet)
-- mitä jos kaikissa tauluissa viiteavaimia?
-- AUTO_INCREMENT -> kasvava numerosarja
-- yhdistetty viiteavain primary key (muuttuja1, muuttuja2)
SELECT ORDERS.DELIVERYID, DELIVERY.DELIVERYID, DELIVERY.MAXWEIGHT, DELIVERY.MAXSIZE FROM ORDERS RIGHT JOIN DELIVERY ON ORDERS.DELIVERYID = DELIVERY.DELIVERYID;

-- SELECT * FROM KIRJA WHERE TYYPPIKOODI=(SELECT TYYPPIKOODI FROM KIRJATYYPI WHERE TYYPPIKUVAUS='dekkarit');

-- It is possible to write the INSERT INTO statement in two ways.
-- The first way specifies both the column names and the values to be inserted:


-- If you are adding values for all the columns of 
-- the table, you do not need to specify the column 
-- names in the SQL query. However, make sure the 
-- order of the values is in the same order as the 
-- columns in the table. The INSERT INTO syntax 
-- would be as follows:

-- INSERT INTO table_name
-- VALUES (value1, value2, value3, ...);

--SELECT column_name(s)
--FROM table1
--INNER JOIN table2
--ON table1.column_name = table2.column_name;

