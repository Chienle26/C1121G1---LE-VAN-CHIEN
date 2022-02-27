use quan_ly_sinh_vien;

-- thị tất cả các thông tin môn học (bảng subject) có credit lớn nhất.
select * from subject
where Credit = (select max(Credit) from subject);

-- Hiển thị các thông tin môn học có điểm thi lớn nhất.
select subject.* from subject
inner join mark on subject.SubId = mark.SubId
where mark = (select max(mark) from mark);

-- Hiển thị các thông tin sinh viên và điểm trung bình của mỗi sinh viên, xếp hạng theo thứ tự điểm giảm dần
select student.*, avg(mark.mark) as dtb from student
inner join mark on student.StudentId = mark.StudentId
group by StudentId
order by dtb desc;

