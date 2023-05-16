CREATE TABLE Homework (
id INT NOT NULL AUTO_INCREMENT,
name VARCHAR(50) NOT NULL,
description TEXT,
PRIMARY KEY (id)
);

CREATE TABLE Lesson (
id INT NOT NULL AUTO_INCREMENT,
name VARCHAR(50) NOT NULL,
updatedAt DATE,
homework_id INT NOT NULL,
PRIMARY KEY (id),
FOREIGN KEY (homework_id) REFERENCES Homework(id)
);

CREATE TABLE Schedule (
id INT NOT NULL AUTO_INCREMENT,
name VARCHAR(50) NOT NULL,
updatedAt DATE,
PRIMARY KEY (id)
);

CREATE TABLE ScheduleLesson (
schedule_id INT NOT NULL,
lesson_id INT NOT NULL,
PRIMARY KEY (schedule_id, lesson_id),
FOREIGN KEY (schedule_id) REFERENCES Schedule(id),
FOREIGN KEY (lesson_id) REFERENCES Lesson(id)
);

INSERT INTO Homework (name, description) VALUES
('homework 1', 'do tasks 1 and 2'),
('homework 2', 'do tasks 3 and 4'),
('homework 3', 'write code in SQL');

INSERT INTO Lesson (name, updatedAt, homework_id) VALUES
('lesson 1', '2023-01-31', 1),
('lesson 2', '2023-02-03', 2),
('lesson 3', '2023-02-04', 3);

INSERT INTO Schedule (name, updatedAt) VALUES
('schedule 1', '2023-01-31'),
('schedule 2', '2023-02-03'),
('schedule 3', '2023-02-04');

INSERT INTO ScheduleLesson (schedule_id, lesson_id) VALUES
(1, 1),
(2, 1),
(3, 2),
(1, 3),
(2, 3);

