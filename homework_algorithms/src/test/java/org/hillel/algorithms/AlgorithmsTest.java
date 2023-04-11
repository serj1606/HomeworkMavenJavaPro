package org.hillel.algorithms;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AlgorithmsTest {
  @Test
  public void cocktailSortedArrayTest() {
    Algorithms algorithms = new Algorithms();
    int[] sortedArray = new int[] {1, 4, 6, 7, 8};
    algorithms.cocktailSort(sortedArray);
    Assertions.assertArrayEquals(new int[] {1, 4, 6, 7, 8}, sortedArray);
  }
  @Test
  public void cocktailUnsortedArrayTest() {
    Algorithms algorithms = new Algorithms();
    int[] unsortedArray = new int[] {1, 8, 6, 7, 4};
    algorithms.cocktailSort(unsortedArray);
    Assertions.assertArrayEquals(new int[] {1, 4, 6, 7, 8}, unsortedArray);
  }
  @Test
  public void cocktailEmptyArrayTest() {
    Algorithms algorithms = new Algorithms();
    int[] emptyArray = new int[0];
    algorithms.cocktailSort(emptyArray);
    Assertions.assertArrayEquals(new int[] {}, emptyArray);
  }
  @Test
  public void quickSortedArrayTest() {
    Algorithms algorithms = new Algorithms();
    int[] sortedArray = new int[] {1, 2, 3, 4, 5};
    algorithms.quickSort(sortedArray, 0, sortedArray.length - 1);
    Assertions.assertArrayEquals(new int[] {1, 2, 3, 4, 5}, sortedArray);
  }
  @Test
  public void quickSortedUnsortedArrayTest() {
    Algorithms algorithms = new Algorithms();
    int[] unsortedArray = new int[] {5, 4, 3, 2, 1};
    algorithms.quickSort(unsortedArray, 0, unsortedArray.length - 1);
    Assertions.assertArrayEquals(new int[] {1, 2, 3, 4, 5}, unsortedArray);
  }
  @Test
  public void quickSortedEmptyArrayTest() {
    Algorithms algorithms = new Algorithms();
    int[] emptyArray = new int[0];
    algorithms.quickSort(emptyArray, 0, emptyArray.length - 1);
    Assertions.assertArrayEquals(new int[] {}, emptyArray);
  }
}
