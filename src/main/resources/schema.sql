DROP TABLE IF EXISTS PRODUCT;
DROP TABLE IF EXISTS CUSTOMER;

CREATE TABLE CUSTOMER(id INT(7) NOT NULL PRIMARY KEY AUTO_INCREMENT, name VARCHAR (20) NOT NULL, email VARCHAR (50));
CREATE TABLE PRODUCT(id INT(7) NOT NULL PRIMARY KEY AUTO_INCREMENT, product_name VARCHAR (20), customer_id INT(7), CONSTRAINT PRODUCT_FK FOREIGN KEY (customer_id) REFERENCES CUSTOMER(id));