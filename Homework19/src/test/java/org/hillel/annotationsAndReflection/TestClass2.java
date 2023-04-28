package org.hillel.annotationsAndReflection;

import lombok.SneakyThrows;
import org.hillel.annotationsAndReflection.anotation.Test;

public class TestClass2 {

  @Test(priority = 1)
  public static void test1() {
    System.out.println("Test 1");
  }

  @Test(priority = 2)
  public static void test2() {
    System.out.println("Test 2");
  }

  @Test(priority = 3)
  public static void test3() {
    System.out.println("Test 3");
  }

  //тестуємо без методів @BeforeSuite та @AfterSuite
  @SneakyThrows
  @org.junit.jupiter.api.Test
  public void testClass2() {
    TestRunner.start(TestClass2.class);
  }
}

