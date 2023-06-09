use products_customer;
insert into customer(cName,cAge) values ('Minh Quan','10');
insert into customer(cName,cAge) values ('Ngoc Oanh','20');
insert into customer(cName,cAge) values ('Hong Ha','50');
select* from customer;
insert into oder(cID,oDate,oToTalPrice) values (1,'2006-03-21',null);
insert into oder(cID,oDate,oToTalPrice) values (2,'2006-03-23',null);
insert into oder(cID,oDate,oToTalPrice) values (1,'2006-03-16',null);
select* from oder;
insert into product(pName,pPrice) values ('May Giat',3);
insert into product(pName,pPrice) values ('Tu Lanh',5);
insert into product(pName,pPrice) values ('Dieu Hoa',7);
insert into product(pName,pPrice) values ('Quat',1);
insert into product(pName,pPrice) values ('Bep Dien',2);
insert into orderdetail(oID,pID,odQTY) values (1,1,3);
insert into orderdetail(oID,pID,odQTY) values (1,3,7);
insert into orderdetail(oID,pID,odQTY) values (1,4,2);
insert into orderdetail(oID,pID,odQTY) values (2,1,1);
insert into orderdetail(oID,pID,odQTY) values (3,1,8);
insert into orderdetail(oID,pID,odQTY) values (2,5,4);
insert into orderdetail(oID,pID,odQTY) values (2,3,3);

use products_customer;
select oder.oID,oder.oDate,sum(product.pPrice*orderdetail.odQTY) as oPrice from oder
 join orderdetail on oder.oID = orderdetail.oID 
 join product  on product.pID = orderdetail.pID 
 group by oder.oID;
select customer.cName,customer.cAge,oder.oDate,product.pName,orderdetail.odQTY
 from customer left join oder on customer.cID = oder.cID
 join orderdetail on oder.oID = orderdetail.oID 
 join product on product.pID = orderdetail.pID  ;
 select  customer.cName , Oder.cID
 from customer  left  join oder on customer.cID = oder.cID  where oder.cID is null ;
