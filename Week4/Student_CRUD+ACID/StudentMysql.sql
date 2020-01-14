create schema pascal2;

use pascal2;

-- MEMBUAT TABLE -- 
create table ms_student(
	id int primary key,
    nama VARCHAR(100),
    birth_place VARCHAR(100),
    birth_date DATE,
    gender VARCHAR(1)
    
    
);

create table ms_Subject(
	id int primary key,
    subject_name VARCHAR(100),
    pic VARCHAR(100)
);

create table tr_student_subject(
	id int primary key,
    student_id int,
    subject_id INT
);

create table ms_gender(
	code VARCHAR(1) primary key,
    genderName VARCHAR(20)
);

--  MEMASUKAN INPUTAN KE DALAM TABEL -- 
insert into ms_student(id, nama, birth_place, birth_date, gender)
VALUES 
(1, 'Tony Blank','Jakarta','1972-06-29','M'),
(2, 'Elon Musk', 'Jakarta','1971-06-28','M'),
(3, 'Nicola Tesla','Bandung','1856-07-10','M'),
(4, 'Alan Turing','Surabaya','1912-06-23','M');

-- drop table ms_student;
insert into ms_subject(id, subject_name, pic)
VALUES
(1, 'Algorithm', 'heri'),
(2, 'Data Structure', 'anto'),
(3, 'Database System', 'anti'),
(4, 'Commercial Law', 'bagas'),
(5, 'Philosophy', 'bagus'),
(6, 'Electro Dynamic', 'agus'),
(7, 'Electro Magnetic Fields', 'nico');

insert into tr_student_subject(id, student_id, subject_id)
Values
(1,1,1),
(2,1,2),
(3,1,3),
(4,2,1),
(5,2,2),
(6,3,6),
(7,3,7),
(8,4,4),
(9,4,5);

insert into ms_gender(code, genderName)
values
('M', 'Male'),
('F', 'Female');

create table tr_score(
	id INT,
    student_subject_id INT,
    score INT
);


select * from tr_score;
insert INTO tr_score(id,student_subject_id,score)
VALUES
(1,2,50),
(2,5,50),
(3,1,75),
(4,3,80);

SELECT * from ms_student;
SELECT * from ms_subject;
SELECT * from tr_student_subject;
SELECT * from tr_score;
SELECT id,nama,birth_place,birth_date,gender from ms_student;
SELECT id,subject_name,pic from ms_subject;

-- MENAMPILKAN ID SISWA,NAMA SISWA , SUBJECT SISWA , KOTA SISWA , TANGGAL LAHIR , JENIS KELAMIN
SELECT ms.id,ms.nama,msj.subject_name,ms.birth_place,ms.birth_date,g.genderName 
			from 
            tr_student_subject tr 
							INNER JOIN ms_student ms on tr.student_id = ms.id
							INNER JOIN ms_subject msj on tr.subject_id = msj.id
							INNER JOIN ms_gender g on ms.gender = g.code
							order by id asc ;

-- MEMBUAT UNIQ SUPAYA TIDAK BISA MENGAMBIL MATA PELAJARAN YANG SAMA
ALTER TABLE tr_student_subject
ADD CONSTRAINT student_id
UNIQUE (student_id,subject_id);




 -- MENAMPILKAN DATA DALAM BENTUK RESULT GRID -- 
-- select * from ms_student;
-- select * from tr_student_subject;

-- select tr.id, s.nama,sub.subject_name from tr_student_subject tr
-- inner join ms_student s on s.id = tr.student_id
-- inner join ms_subject sub on sub.id = tr.subject_id
-- where sub.id =2;

-- select * from ms_subject;
-- select * from ms_gender;

-- SELECT s.nama,s.birth_place,g.genderName from ms_student s
-- INNER join ms_gender g
-- on g.code = s.gender;

-- SELECT s.nama,s.birth_place,g.genderName from ms_student s
-- INNER join ms_gender g
-- on g.code = s.gender;



-- select /*mst.nama,ms.subject_name,tsc.score */ * from tr_student_subject tr
-- INNER join ms_subject ms on ms.id = tr.subject_id
-- INNER join ms_student mst on mst.id = tr.student_id
-- INNER join tr_score tsc on tsc.student_subject_id = tr.id
-- where ms.id = 2
-- ;


-- select s.id,nama,sum(score),count(*),avg(score) from tr_score score
-- inner join tr_student_subject ss on ss.id = score.student_subject_id
-- inner join ms_student s on s.id = ss.student_id
-- where s.nama = 'tony blank'

-- group by s.id, nama
-- having avg(score) > 50;





-- ALTER TABLE ms_gender add testing int;
-- ALTER TABLE ms_gender CHANGE testing testingaja int;
-- ALTER TABLE ms_gender drop COLUMN testingaja;

-- select * from ms_student WHERE birth_place != 'Jakarta';
-- select * from ms_student WHERE nama like '%n%' AND nama like '%lA%'  and nama not like '%N';
-- select * from ms_student WHERE year(birth_date) = 1856;
-- select * from ms_student WHERE id > 2;
-- select * from ms_student WHERE id > 0 ORDER BY id;
-- select * from ms_student WHERE year(birth_date) <= 1950 AND year(birth_date) >= 1900;
-- select * from ms_student WHERE year(birth_date) BETWEEN 1900 and 1950;
   
-- SELECT *
-- from ms_gender
-- ;

-- UPDATE ms_gender
-- set
-- 	gender_name = 'Female'
-- WHERE
-- 	gender_code = 'F'
-- ;

-- drop table ms_student;

-- create table ms_student(
-- 	id int primary key,
--     nama VARCHAR(100),
--     birth_place VARCHAR(100),
--     birth_date DATE,
--     gender VARCHAR(1),
--     FOREIGN KEY(gender) REFERENCES ms_gender(gender_code)
--     )
--     ;
    
    



	
    





-- ALTER TABLE tr_student_subject  ADD UNIQUE student_id (student_id ASC) VISIBLE, ADD UNIQUE subject_id (subject_id ASC) VISIBLE
