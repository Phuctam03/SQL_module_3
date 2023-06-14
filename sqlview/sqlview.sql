create database demo ;
use demo;
create table Products(
    id int  primary key auto_increment,
    productCode varchar(50),
    productName varchar(50),
    productPrice double,
    productAmount int ,
    productDescription varchar(50),
    productStatus bit
);
insert into Products( productCode,productName,productPrice,productAmount,productDescription,productStatus) values
 ('p1','abc','340.5','10','bcd',1);
 insert into Products( productCode,productName,productPrice,productAmount,productDescription,productStatus) values
 ('p2','bcd','340.5','10','bcd',0);
 insert into Products( productCode,productName,productPrice,productAmount,productDescription,productStatus) values
 ('p3','afg','340.5','10','bcd',1);
 
create unique index index_Products on Products(productCode); 
explain select productCode from Products;
create index index_Name_Price on Products(productName, productPrice);
explain select productPrice,productName from Products ;

create view Product_view as select productCode,productName,productPrice,productStatus from Products ;
select* from Product_view;
SET SQL_SAFE_UPDATES=0;
update Product_view set productPrice = 450.6; 
drop view Product_view;

DELIMITER //
create procedure procedure_Products()
begin
   select * from Products;
end //
DELIMITER ;
call procedure_Products();

DELIMITER //
create procedure procedure_addProduce(
  in productCode varchar(50),
  in  productName varchar(50),
  in  productPrice double,
  in  productAmount int,
  in  productDescription varchar(50),
  in  productStatus bit)
begin 
  insert into products(productCode,productName,productPrice,productAmount,productDescription,productStatus)
   values (productCode,productName,productPrice,productAmount,productDescription,productStatus);
end //
DELIMITER ;
call procedure_addProduce('p5','utf',340.5,20,'afb',0);


DELIMITER //
create procedure procedure_updateProduce(in id int,
 in productCode varchar(50),
  in  productName varchar(50),
  in  productPrice double,
  in  productAmount int,
  in  productDescription varchar(50),
  in  productStatus bit
)
begin
   update products set
    products.productCode = productCode , products.productName = productName, products.productPrice = productPrice,
    products.productAmount = productAmount,products.productDescription = productDescription,products.productStatus = productStatus 
    where products.id = id ;
END //
DELIMITER ;
call procedure_updateProduce(4,'p45','thyu',123.3,40,'CDE',1);

DELIMITER //
create procedure procedure_deleteProducts(in id int)
begin
   delete from products  where products.id = id ;
end //
DELIMITER ;

call procedure_deleteProducts(7);

