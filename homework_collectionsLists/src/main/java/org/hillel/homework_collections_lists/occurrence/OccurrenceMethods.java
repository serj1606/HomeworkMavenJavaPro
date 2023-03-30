package org.hillel.homework_collections_lists.occurrence;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class OccurrenceMethods {
  public static int countOccurrence(List<String> strings, String target) {
    int occurrence = 0;

    for (String string : strings) {
      if (target.equals(string)) {
        occurrence++;
      }
    }
    return occurrence;
  }

  public List<Integer> toList(int[] array) {
    List<Integer> list = new ArrayList<>();
    for (int i : array) {
      list.add(i);
    }
    return list;
  }

  public List<Integer> findUnique(List<Integer> list) {
    return new ArrayList<>(new HashSet<>(list));
  }


  public void calcOccurrence(List<String> strings) {
    for (String unique : findUniqueStrings(strings)) {
      System.out.println(unique + ": " + countOccurrence(strings, unique));
    }
  }

  public static List<StringOccurrences> findOccurrence(List<String> strings) {
    List<StringOccurrences> occurrences = new ArrayList<>();

    for (String unique : findUniqueStrings(strings)) {
      occurrences.add(new StringOccurrences(unique, countOccurrence(strings, unique)));
    }
    return occurrences;
  }

  private static List<String> findUniqueStrings(List<String> strings) {
    List<String> uniqueStrings = new ArrayList<>();

    for (String unique : strings) {
      if (uniqueStrings.contains(unique)) {
        continue;
      }
      uniqueStrings.add(unique);
    }
    return uniqueStrings;
  }
}