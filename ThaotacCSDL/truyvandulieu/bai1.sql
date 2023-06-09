select* from student where Student_name LIKE 'h%';
select* from class   where date_format(StartDate,'%m')='12';
select * from subject where Credit between 3 and 5 ;

SET SQL_SAFE_UPDATES=0;
update student set Classid = 2 where student_name='Hung';

select Student_name,Sub_name,Mark from student join subject on
student.Student_id = subject.sub_id join mark on mark.sub_id = subject.sub_id order by mark.mark desc;