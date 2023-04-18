package org.hillel.homework17.generics.methodToList;


import java.util.Arrays;
import java.util.List;

public class MethodToList {
  public <T> List<T> toList(T[] arr) {
    return Arrays.asList(arr); // виправив return new ArrayList<>(Arrays.asList(arr)) на return Arrays.asList(arr);
  }
}



