CREATE DATABASE  IF NOT EXISTS `mydb`;
USE `mydb`;

--
-- Table structures
--

DROP TABLE IF EXISTS `authorities`;
DROP TABLE IF EXISTS `users`;
DROP TABLE IF EXISTS `grade`;
DROP TABLE IF EXISTS `courses_students`;
DROP TABLE IF EXISTS `student`;
DROP TABLE IF EXISTS `course`;

create table `users` (
    username varchar(50) not null primary key,
    password varchar(120) not null,
    enabled boolean not null
);

create table `authorities` (
    username varchar(50) not null,
    authority varchar(50) not null,
    foreign key (username) references users (username)
);

CREATE TABLE `course` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `syllabus` varchar(45) DEFAULT NULL,
  `year` int DEFAULT NULL,
  `semester` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `registration_year` int DEFAULT NULL,
  `semester` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE `courses_students` (
  `course_id` int(11) NOT NULL,
  `student_id` int(11) NOT NULL,
  FOREIGN KEY (`course_id`) REFERENCES `course`(`id`),
  FOREIGN KEY (`student_id`) REFERENCES `student`(`id`),
  PRIMARY KEY (`course_id`, `student_id`));

CREATE TABLE `grade` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `course_id` int(11) NOT NULL,
  `student_id` int(11) NOT NULL,
  `final_exam` int DEFAULT NULL,
  `project` int DEFAULT NULL,
  `project_weight` int DEFAULT NULL,
  FOREIGN KEY (`course_id`) REFERENCES `course`(`id`),
  FOREIGN KEY (`student_id`) REFERENCES `student`(`id`),
  PRIMARY KEY (`id`));

--
-- Data for users
--

insert into users(username, password, enabled)values('admin','{noop}admin',true);
insert into users(username, password, enabled)values('user','{noop}user',true);
insert into users(username, password, enabled)values('teacher','{noop}teacher',true);

insert into authorities(username,authority)values('admin','ROLE_ADMIN');
insert into authorities(username,authority)values('admin','ROLE_USER');
insert into authorities(username,authority)values('user','ROLE_USER');
insert into authorities(username,authority)values('teacher','ROLE_USER');

 
--
-- Data for other tables`
--

INSERT INTO `course` VALUES 
	(1,'Discrete Mathematics', 'syl1', 2021, 2);
INSERT INTO `course`(`id`, `name`) VALUES 
	(2,'Databases I'),
	(3,'Databases II'),
	(4,'PingPong Mastery III'),
	(5,'Tourism');

INSERT INTO `student` VALUES
    (1,'Makis Tsikos', 2002, 5),
	(2,'Giota Griva', 2007, 2),
	(3,'Giannis Kapsalis', 2012, 7),
	(4,'Xara Vera', 2012, 9),
	(5,'Makis Dimakis', 2022, 1);

INSERT INTO `courses_students` VALUES
    (1, 3),
	(2, 4),
    (3, 1),
    (4, 2),
    (5, 1);

INSERT INTO `grade` VALUES (1, 1, 1, 6, 9, 20);
INSERT INTO `grade`(`id`, `course_id`, `student_id`) VALUES
	(2, 2, 2),
    (3, 3, 3),
    (4, 4, 4),
    (5, 5, 5);

