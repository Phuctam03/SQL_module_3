use Products_Customer;
create table Customer(
   cID int auto_increment primary key ,
   cName varchar(50) not null,
   cAge int ,
   check(cAge >= 0)
);

create table Oder(
    oID int auto_increment primary key,
    cID int not null unique,
    foreign key (cID) references Customer(cID),
	oDate date ,
    oToTalPrice double ,
    check (oTotalPrice >= 0 )
);

create table Product(
      pID int auto_increment primary key ,
      pName varchar(50),
      pPrice varchar(50)
);

create table OrderDetail(
       oID int not null ,
       pID int not null ,
       odQTY varchar(255),
       primary key(oID,pID),
       foreign key (oID) references Oder(oID),
       foreign key  (pID) references Product(pID)
);



