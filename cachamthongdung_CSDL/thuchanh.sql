SELECT * FROM quanlysinhvien.student;

select address , count(student_id) as soluongsinhvien from student group by address;
select student.Student_id,student.Student_name,avg(mark) as DTB_hocvien
 from student  join mark on student.Student_id = mark.Students_Id
 group by student.Student_id,student.Student_name;
 select  student.Student_id,student.Student_name, avg(Mark) 
 from  student  inner join mark on student.Student_id = mark.Students_Id 
 group by student.Student_id 
 having avg(Mark) >15;
 select student.Student_id,student.Student_name,avg(Mark)
 from student inner join mark on student.Student_id = mark.Students_Id 
 group by student.Student_id having avg(mark) >= all (select  avg(mark)  from mark  group by mark.Students_Id );
 
 