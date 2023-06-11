SELECT * FROM quanlysinhvien.subject;

select * from subject where Credit >= all (select Credit from subject );
select sub_name, Mark from mark inner join subject on mark.Sub_id = subject.Sub_id
 where mark.Mark >= all(select mark.Mark from mark );
 select student.Student_id, student.Student_name,student.address,student.Phone, avg(mark.Mark) as DTB_sinhvien
 from student inner join mark on student.Student_id = mark.Students_Id group by student.Student_id order by avg(mark.Mark) desc;
