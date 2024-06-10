CREATE TABLE product(
id INT PRIMARY key AUTO_INCREMENT,
product_name varchar(10),
description varchar(20),
price DOUBLE,
is_active BOOLEAN DEFAULT true
);