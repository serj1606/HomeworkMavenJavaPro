package Dao;

import BaseConnection.DataBaseConnection;
import Entity.Homework;
import Entity.Lesson;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import lombok.SneakyThrows;

public class DaoLesson {
  DataBaseConnection dataBaseConnection = new DataBaseConnection();

  @SneakyThrows
  public List<Lesson> getAll() {
    String query = "SELECT * FROM Lesson JOIN Homework ON Lesson.homework_id = Homework.Id";

    List<Lesson> lessons = new ArrayList<>();

    try (Connection connection = dataBaseConnection.getConnection();
         Statement statement = connection.createStatement()) {

      ResultSet resultSet = statement.executeQuery(query);

      while (resultSet.next()) {

        Lesson lesson = Lesson.builder()
            .id(resultSet.getInt("id"))
            .name(resultSet.getString("name"))
            .homework(Homework.builder().id(resultSet.getInt("id"))
                .name(resultSet.getString("name"))
                .description(resultSet.getString("description"))
                .build())

            .build();
        lessons.add(lesson);
      }
      dataBaseConnection.close(dataBaseConnection.getConnection());
    }
    return lessons;
  }

  @SneakyThrows
  public void delete(int id) {
    String query = "DELETE FROM Lesson WHERE id = ?";

    try (Connection connection = dataBaseConnection.getConnection();
         PreparedStatement statement = connection.prepareStatement(query);
    ) {
      statement.setInt(1, id);
      statement.executeUpdate();
    }
  }

  @SneakyThrows
  public void add(Lesson item) {
    String query = "INSERT INTO Lesson ( name, homework_id) VALUES ( ?, ?)";
    try (Connection connection = dataBaseConnection.getConnection();
         PreparedStatement statement = connection.prepareStatement(query);
    ) {

      statement.setString(1, item.getName());
      statement.setInt(2, item.getHomework().getId());

      statement.executeUpdate();
    }
  }

  @SneakyThrows
  public Lesson getId(int id) {
    String query =
        "SELECT Lesson.id, Lesson.name, Homework.id, Homework.name, Homework.description "
            + "FROM Lesson "
            + "JOIN Homework ON Lesson.homework_id = Homework.id";

    try (Connection connection = dataBaseConnection.getConnection();
         PreparedStatement statement = connection.prepareStatement(query);
    ) {
      ResultSet resultSet = statement.executeQuery(query);
      while (resultSet.next()) {

        return Lesson.builder().id(resultSet.getInt("id")).name(resultSet.getString("name"))
            .homework(Homework.builder().id(resultSet.getInt("id"))
                .name(resultSet.getString("name"))
                .description(resultSet.getString("description"))
                .build()).build();
      }
    }
    return null;
  }

}
