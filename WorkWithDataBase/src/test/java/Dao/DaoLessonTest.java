package Dao;

import Entity.Homework;
import Entity.Lesson;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

public class DaoLessonTest {

  @Test
  @SneakyThrows
  void getAllTest(){
    new DaoLesson().getAll().forEach(System.out::println);
     }

  @Test
  @SneakyThrows
  void deleteTest(){
    new DaoLesson().delete(12);
  }

  @Test
  @SneakyThrows
  void addTest() {
    Lesson lesson = Lesson.builder()
        .name("Lesson 15")
        .homework(Homework.
            builder()
            .id(3)
            .build())
        .build();

    new DaoLesson().add(lesson);
  }

  @Test
  @SneakyThrows
  void getIdTest1() {
    System.out.println(new DaoLesson().getId(1));
  }

}
