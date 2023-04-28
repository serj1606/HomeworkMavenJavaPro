package org.hillel.annotationsAndReflection;

import lombok.SneakyThrows;
import org.hillel.annotationsAndReflection.anotation.AfterSuite;
import org.hillel.annotationsAndReflection.anotation.BeforeSuite;

public class TestClass3 {
  @BeforeSuite
  public static void beforeSuite() {
    System.out.println("Before Suite");
  }

  @AfterSuite
  public static void afterSuite() {
    System.out.println("After Suite");
  }

  //тестуємо без методів @Test
  @SneakyThrows
  @org.junit.jupiter.api.Test
  public void testClass3() {
    TestRunner.start(TestClass3.class);
  }
}