CREATE DATABASE WebShop

CREATE TABLE product (
productName varchar(128)  primary key,
price float not null,
quantity int not null,
visible int not null
);

INSERT INTO product (`productName`, `price`, `quantity`, `visible`) VALUES ('Dell laptop', '490.95', '100', '1');
INSERT INTO product (`productName`, `price`, `quantity`, `visible`) VALUES ('Nexus 5', '230.59', '200', '0');
INSERT INTO product (`productName`, `price`, `quantity`, `visible`) VALUES ('Iphone 6s', '399.49', '300', '1');

CREATE TABLE cart (
cartId varchar(128)  primary key,
productName varchar(128) not null,
quantity int not null,
grandTotal decimal(10,2) not null
);
