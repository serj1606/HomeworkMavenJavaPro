package org.hillel.annotationsAndReflection;

import lombok.SneakyThrows;
import org.hillel.annotationsAndReflection.anotation.AfterSuite;
import org.hillel.annotationsAndReflection.anotation.BeforeSuite;
import org.hillel.annotationsAndReflection.anotation.Test;

public class TestClass1 {
  @BeforeSuite
  public static void beforeSuite() {
    System.out.println("Before Suite");
  }

  @Test(priority = 1)
  public static void test1() {
    System.out.println("Test 1");
  }

  @Test(priority = 3)
  public static void test3() {
    System.out.println("Test 3");
  }

  @Test(priority = 2)
  public static void test2() {
    System.out.println("Test 2");
  }

  @AfterSuite
  public static void afterSuite() {
    System.out.println("After Suite");
  }

  // Перевіряємо виконання методів і їх порядок виконання
  @SneakyThrows
  @org.junit.jupiter.api.Test
  public void testClass1() {
    TestRunner.start(TestClass1.class);
  }
}

