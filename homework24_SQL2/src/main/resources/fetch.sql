SELECT * FROM Homework;

SELECT Lesson.id, Lesson.name, Lesson.updatedAt, Homework.id, Homework.name, Homework.description 
FROM Lesson 
INNER JOIN Homework ON Lesson.homework_id = Homework.id;

SELECT Lesson.id, Lesson.name, Lesson.updatedAt, Homework.id, Homework.name, Homework.description 
FROM Lesson 
INNER JOIN Homework 
ON Lesson.homework_id = Homework.id ORDER BY Lesson.updatedAt DESC;

SELECT Schedule.*, Lesson.id, Lesson.name, Lesson.updatedAt
FROM Schedule 
INNER JOIN ScheduleLesson 
ON Schedule.id = ScheduleLesson.schedule_id 
INNER JOIN Lesson 
ON ScheduleLesson.lesson_id = Lesson.id; 

SELECT Schedule.*, COUNT(ScheduleLesson.lesson_id) AS num_lessons 
FROM Schedule 
LEFT JOIN ScheduleLesson 
ON Schedule.id = ScheduleLesson.schedule_id 
GROUP BY Schedule.id;

