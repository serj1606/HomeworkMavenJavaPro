package hillel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import hillel.dao.StudentDAO;
import hillel.entity.Student;
import hillel.util.HibernateSession;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class StudentDAOTest {

  private static StudentDAO studentDAO;

  @BeforeAll
  public static void setup() {
    studentDAO = new StudentDAO();
  }

  @AfterAll
  public static void teardown() {
    HibernateSession.getSessionFactory().close();
  }

  @Test
  public void testSaveAndGetById() {
    Student student = new Student("John Doe", "john@example.com");
    studentDAO.save(student);

    Student retrievedStudent = studentDAO.getById(student.getId());
    assertNotNull(retrievedStudent);
    assertEquals("John Doe", retrievedStudent.getName());
    assertEquals("john@example.com", retrievedStudent.getEmail());
  }

  @Test
  public void testGetAll() {
    List<Student> students = studentDAO.getAll();
    assertEquals(2, students.size());
  }

  @Test
  public void testUpdate() {
    studentDAO.update(new Student(25L, "Bob Dilan", "dilan@example.com"));
    Student updatedStudent = studentDAO.getById(25L);
    assertNotNull(updatedStudent);
    assertEquals("Bob Dilan", updatedStudent.getName());
    assertEquals("dilan@example.com", updatedStudent.getEmail());
  }

  @Test
  public void testDelete() {
    studentDAO.delete(26L);
    Student deletedStudent = studentDAO.getById(24L);
    assertNull(deletedStudent);
  }

}
