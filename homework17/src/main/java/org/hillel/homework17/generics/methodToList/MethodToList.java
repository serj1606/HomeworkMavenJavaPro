package org.hillel.homework17.generics.methodToList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MethodToList {
  public <T> List<T> toList(T[] arr) {
    return new ArrayList<>(Arrays.asList(arr));
  }
}



