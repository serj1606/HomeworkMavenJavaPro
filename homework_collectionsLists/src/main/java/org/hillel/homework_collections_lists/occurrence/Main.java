package org.hillel.homework_collections_lists.occurrence;

import java.util.Arrays;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    OccurrenceMethods occurrenceMethods = new OccurrenceMethods();
    List<String> strings = Arrays.asList("bird", "cat", "bird", "fox", "cat", "cat");
    int[] array = {1, 2, 3, 4};
    List<Integer> arrayOfInteger = Arrays.asList(1, 2, 3, 4, 5, 5, 1);

    System.out.println(OccurrenceMethods.countOccurrence(strings, "cat"));
    System.out.println(occurrenceMethods.toList(array) + " converted to ArrayList");
    System.out.println(occurrenceMethods.findUnique(arrayOfInteger));
    occurrenceMethods.calcOccurrence(strings);
    System.out.println(OccurrenceMethods.findOccurrence(strings));
  }
}

