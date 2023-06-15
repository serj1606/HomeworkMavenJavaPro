package hillel.util;


import hillel.entity.Student;
import java.util.Properties;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;


public class HibernateSession {
  private static SessionFactory sessionFactory;

  public static SessionFactory getSessionFactory() {
    if (sessionFactory == null) {

      try {
        Configuration configuration = new Configuration();
        Properties properties = new Properties();
        properties.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
        properties.put(Environment.URL, "jdbc:mysql://localhost:3306/homeworkhiber");
        properties.put(Environment.USER, "root");
        properties.put(Environment.PASS, "0482398351");
        properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
        properties.put(Environment.SHOW_SQL, "true");
        properties.put(Environment.HBM2DDL_AUTO, "update");


        configuration.setProperties(properties);
        configuration.addAnnotatedClass(Student.class);

        sessionFactory = configuration.buildSessionFactory();
      } catch (Exception e) {

        System.out.println("Some error: " + e.getMessage());
      }
    }
    return sessionFactory;
  }
}

