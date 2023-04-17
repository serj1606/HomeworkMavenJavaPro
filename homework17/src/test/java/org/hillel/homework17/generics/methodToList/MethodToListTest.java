package org.hillel.homework17.generics.methodToList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.Test;

public class MethodToListTest {
  // перевіряємо роботу методу для масиву типу Integer
  @Test
  public void testToListInteger() {
    MethodToList methodToList = new MethodToList();

    Integer[] intArr = {1, 2, 3};
    List<Integer> intList = methodToList.toList(intArr);
    assertEquals(intList.size(), 3);
    assertTrue(intList.contains(1));
    assertTrue(intList.contains(2));
    assertTrue(intList.contains(3));
  }

  // перевіряємо роботу методу для масиву типу String
  @Test
  public void testToListString() {
    MethodToList methodToList = new MethodToList();

    String[] strArr = {"A", "B", "C"};
    List<String> strList = methodToList.toList(strArr);
    assertEquals(strList.size(), 3);
    assertTrue(strList.contains("A"));
    assertTrue(strList.contains("B"));
    assertTrue(strList.contains("C"));
  }
}


