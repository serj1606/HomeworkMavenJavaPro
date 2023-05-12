package org.hillel.Multithreading2.ThreadSafeList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ThreadSafeList<E> {
    private final List<E> list = Collections.synchronizedList(new ArrayList<>());

    public synchronized void add(E data) {
      list.add(data);
    }

    public synchronized void remove(E data) {
      list.remove(data);
    }

  public synchronized E get(int index) {
    try {
      return list.get(index);
    } catch (IndexOutOfBoundsException e) {
      throw new IndexOutOfBoundsException("Index out of bounds: " + index);
    }
  }
}


