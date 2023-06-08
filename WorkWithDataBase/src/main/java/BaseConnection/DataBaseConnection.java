package BaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import lombok.SneakyThrows;


public class DataBaseConnection {

  public static final String DB_URL = "jdbc:mysql://localhost:3306/db";
  public static final String DB_USER = "root";
  public static final String DB_PASSWORD = "0482398351";


  @SneakyThrows
  public Connection getConnection() {
    return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
  }

  @SneakyThrows
  public void close(Connection connect) {
    if (connect != null) {
      connect.close();
    }
  }
}


