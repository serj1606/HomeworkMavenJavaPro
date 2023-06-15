package hillel.dao;


import hillel.entity.Student;
import hillel.util.HibernateSession;
import java.util.List;
import lombok.SneakyThrows;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class StudentDAO {
  @SneakyThrows
  public void save(Student student) {
    Transaction transaction;
    try (Session session = HibernateSession.getSessionFactory().openSession()) {
      transaction = session.beginTransaction();
      session.save(student);
      transaction.commit();
    }
  }

  @SneakyThrows
  public Student getById(long id) {
    try (Session session = HibernateSession.getSessionFactory().openSession()) {
      return session.get(Student.class, id);
    }
  }


  @SneakyThrows
  public void delete(long id) {
    Transaction transaction;
    try (Session session = HibernateSession.getSessionFactory().openSession()) {
      transaction = session.beginTransaction();
      session.delete(session.get(Student.class, id));
      transaction.commit();
    }
  }

  @SneakyThrows
  public void update(Student student) {
    Transaction transaction;
    try (Session session = HibernateSession.getSessionFactory().openSession()) {
      transaction = session.beginTransaction();
      session.update(student);
      transaction.commit();
    }
  }

  @SneakyThrows
  public List<Student> getAll() {
    try (Session session = HibernateSession.getSessionFactory().openSession()) {
      return session.createQuery("FROM  Student", Student.class).list();
    }
  }
}



