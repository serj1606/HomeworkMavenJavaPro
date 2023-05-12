package org.hillel.Multithreading2.ThreadSafeList;


import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class ThreadSafeListTest {
  @Test
  void testAddAndGet() {
    ThreadSafeList<Integer> list = new ThreadSafeList<>();
    list.add(1);
    list.add(2);
    list.add(3);

    assertEquals(1, list.get(0));
    assertEquals(2, list.get(1));
    assertEquals(3, list.get(2));
  }

  @Test
  void testRemove() {
    ThreadSafeList<Integer> list = new ThreadSafeList<>();
    list.add(1);
    list.add(2);
    list.add(3);

    list.remove(2);

    assertEquals(1, list.get(0));
    assertEquals(3, list.get(1));
  }
  @Test
  void testGet() {
    ThreadSafeList<Integer> list = new ThreadSafeList<>();
    list.add(1);
    list.add(2);
    list.add(3);
    assertEquals(1, list.get(0));
    assertEquals(2, list.get(1));
    assertEquals(3, list.get(2));
  }
}




