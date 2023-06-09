-- create database QuanLySinhVien;

use QuanLySinhVien;

create table class(
    Class_id int not null auto_increment primary key,
    Class_name varchar(60) not null,
    StartDate DateTime not null,
    Status  bit
);

create table Student(
    Student_id int not null auto_increment primary key,
    Student_name varchar(30) not null,
    address varchar(50),
    Phone varchar(20) unique,
    Status bit,
    Classid int not null,
    foreign key(Classid) references class(Class_id)  
);
create table Subject(
    Sub_id int not null auto_increment primary key,
    Sub_name varchar(30) not null,
    Credit tinyint default 1,
    check(Credit >= 1 ),
    status Bit default 1 
);
create table Mark(
      Mark_id int not null auto_increment primary key,
      Sub_id int not null,
      Students_Id int not null,
      Mark float default 0 ,
      check(Mark between 0 and 100),
      ExamTimes tinyint default 1 ,
      unique(Sub_id,Students_id),
      foreign key(Sub_id) references Subject(Sub_id),
      foreign key(Students_Id) references Student(Student_id)
);
insert into class(Class_name,StartDate,Status) values ('A1','2008-12-20',1);
insert into class(Class_name,StartDate,Status) values ('A2','2008-12-22',1);
insert into class(Class_name,StartDate,Status) values ('B3',current_date(),0);

insert into Student(Student_name,address,Phone,status,Classid) values('Hung','Ha Noi',0912113113,1,1);
insert into Student(Student_name,address,status,Classid) values('Hoa','Hai Phong',1,1);
insert into Student(Student_name,address,Phone,status,Classid) values('Manh','HCM',0123123123,0,2);

insert into Subject (Sub_name,Credit,status) values ('CF',5,1);
insert into Subject (Sub_name,Credit,status) values ('C',6,1);
insert into Subject (Sub_name,Credit,status) values ('HDJ',5,1);
insert into Subject (Sub_name,Credit,status) values ('RDBMS',10,1);

insert into Mark(Sub_id,Students_Id,Mark,ExamTimes) values (1,1,8,1);
insert into Mark(Sub_id,Students_Id,Mark,ExamTimes) values (1,2,10,2);
insert into Mark(Sub_id,Students_Id,Mark,ExamTimes) values (2,1,12,1);


Select* from Student;
Select * from Student Where Status = 1 ;
Select * from Subject where  Credit <10;
select  Student_id,Student_name,Class_name from Student join Class on Class_id = Student_id;
select Student_id,Student_name,Class_name  from Student join Class on Class_id = Student_id where Class_name ='A1';
select  Student.Student_id,Student.Student_name,Subject.Sub_name,Mark.Mark from Student  join  Mark on Student.Student_id =Mark.Mark_id join Subject on Mark.sub_id = Subject.sub_id;
select  Student.Student_id,Student.Student_name,Subject.Sub_name,Mark.Mark from Student  join  Mark on Student.Student_id =Mark.Mark_id join Subject on Mark.sub_id = Subject.sub_id where subject.sub_name = 'CF';



