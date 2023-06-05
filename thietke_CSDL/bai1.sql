
create database  thietke_csdl;
create table PHIEUXUAT(
   SoPX int auto_increment primary key ,
   ngay_xuat date 
);
insert into PHIEUXUAT(ngay_xuat) values ('2023-06-05');

select * from PHIEUXUAT;

create table VATTU(
      MAVTU int auto_increment primary key ,
      tenVTU varchar(50) 
);
insert into VATTU(tenVTU) values ('ABC');
select * from VATTU;

create table CHITIET_PHIEUXUAT(
     SoPX int  not null  ,
     MaVTU int  not null  ,
     primary key (SoPX,MaVTU),
     DGXuat double,
     check(DGXuat >= 0),
     SLXuat int ,
     check(SLXuat >= 0),
     foreign key (SoPX) references PHIEUXUAT(SoPX),
     foreign key (MaVTU) references VATTU(MAVTU)
);
select * from CHITIET_PHIEUXUAT;
insert into CHITIET_PHIEUXUAT(SoPX,MaVTU,DGXuat,SLXuat) values (1,1,245.6,30);

create table PHIEUNHAP(
       SoPN int auto_increment primary key ,
       ngay_nhap date 
);
insert into PHIEUNHAP(ngay_nhap) values ('2023-12-23');
select * from PHIEUNHAP;

create table CHITIET_PHIEUNHAP(
    MaVTU int not null  , 
    SoPN int  not null ,
    primary key(MaVTU,SoPN),
    DGNhap double ,
    check(DGNhap >= 0),
    SLNhap int ,
    check(SLNhap >= 0),
    foreign key(MaVTU) references VATTU(MAVTU),
    foreign key(SoPN) references  PHIEUNHAP(SoPN)
);

insert into CHITIET_PHIEUNHAP(MaVTU,SoPN,DGNhap,SLNhap) values (1,1,450.6,20);
select * from CHITIET_PHIEUNHAP;

create table DONDH(
      SoDH int auto_increment primary key ,
      NgayHD date ,
      MaNCC int not null ,
     foreign key (MaNCC) references NHACC(MaNCC)
);
insert into DONDH(NgayHD) values('2023-07-05');
create table CHITIET_DONDATHANG(
      MaVTU int not null,
      SoDH int not null,
      primary key(MaVTU,SoDH),
      foreign key(MaVTU) references  VATTU(MAVTU),
      foreign key(SoDH) references    DONDH(SoDH)
);
insert into CHITIET_DONDATHANG(MaVTU,SoDH) values (1,1);
select * from CHIITIET_DONDATHANG;

use thietke_csdl;
create table NHACC(
  MaNCC int auto_increment primary key ,
  TenNCC varchar(50),
  dia_Chi varchar(255) ,
  SDT varchar(50) unique not null,
  SoDH int 
);



