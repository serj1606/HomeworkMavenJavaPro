package org.hillel.unitTest;

import java.util.stream.IntStream;

public class ArrayElements {

  /**
   * adds a new array after 4
   */

  public int[] getAllElementsAfterFour(int[] array) {
    int lenghtNewArray = -1;
    int number = 4;
    for (int i = array.length - 1; i >= 0; i--) {
      if (array[i] == number) {
        lenghtNewArray = array.length - 1 - i;
        break;
      }
    }
    if (lenghtNewArray == -1) {
      throw new RuntimeException("array does not contain searching number");
    }
    int[] newArray = new int[lenghtNewArray];
    System.arraycopy(array, array.length - newArray.length, newArray, 0, newArray.length);
    return newArray;
  }

  /**
   * checks if the array consists of the numbers 1 and 4
   */

  public boolean isArrayContainsSearchingNumbers(int[] array) {
    boolean containsWrong =
        IntStream.of(array).filter(i -> i != 1).filter(i -> i != 4).count() != 0;
    boolean containsOne = IntStream.of(array).filter(i -> i == 1).count() != 0;
    boolean containsFour = IntStream.of(array).filter(i -> i == 4).count() != 0;
    return !containsWrong && containsOne && containsFour;

  }
}

// з початку зробив цій метод, нажаль він невідповідає умовам завдання (він тільки перевіряє наявність 1 та 4 в масиві, не враховуючи інші значення)
// довелося переробити на це :-)) -> той що вище, хоча простіше було мабуть через foreach та if

/*  public boolean isArrayContainsSearchingNumbers(int[] array) {
    int a = 1;
    int b = 4;
    return Arrays.stream(array).anyMatch(x -> x == a) && Arrays.stream(array).anyMatch(x -> x == b);
  }*/



