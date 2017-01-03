--<ScriptOptions statementTerminator=";"/>

CREATE TABLE classes (
	classId INT NOT NULL,
	className VARCHAR(255) NOT NULL,
	PRIMARY KEY (classId)
) ENGINE=InnoDB;

CREATE TABLE student_course (
	stuId INT NOT NULL,
	course_id INT NOT NULL,
	PRIMARY KEY (stuId,course_id)
) ENGINE=InnoDB;

CREATE TABLE person (
	PERSON_ID INT NOT NULL,
	password VARCHAR(255),
	hobbies VARCHAR(255),
	email VARCHAR(255),
	name VARCHAR(255) NOT NULL,
	gender VARCHAR(255) NOT NULL,
	birthday DATETIME,
	PRIMARY KEY (PERSON_ID)
) ENGINE=InnoDB;

CREATE TABLE student (
	stuId INT NOT NULL,
	password VARCHAR(255) NOT NULL,
	name VARCHAR(255) NOT NULL,
	gender VARCHAR(255) NOT NULL,
	birthday DATETIME,
	hobbies VARCHAR(255),
	email VARCHAR(255),
	classId INT,
	PRIMARY KEY (stuId)
) ENGINE=InnoDB;

CREATE TABLE course_students (
	course_id INT NOT NULL,
	stuId INT NOT NULL,
	PRIMARY KEY (course_id,stuId)
) ENGINE=InnoDB;

CREATE TABLE course (
	course_id INT NOT NULL,
	courseName VARCHAR(255),
	PRIMARY KEY (course_id)
) ENGINE=InnoDB;

CREATE INDEX FKa2ynkcetj1us2r7w815jmo5eu ON student (classId ASC);

CREATE INDEX FK2cn0cgnodepbvkcvr70xj53ic ON student_course (course_id ASC);

CREATE INDEX FKehxm8y38ir4kh39gv8aio63lj ON course_students (stuId ASC);

