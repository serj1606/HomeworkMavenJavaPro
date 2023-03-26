package org.hillel.unitTest;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArrayElementsTest {
  ArrayElements arrayElements = new ArrayElements();

  @Test
  public void getAllElementsAfterFourTest() {
    int[] array = {2, 3, 7, 4, 9, 6, 6, 8};
    int[] expectedArray = {9, 6, 6, 8};
    Assertions.assertArrayEquals(expectedArray, arrayElements.getAllElementsAfterFour(array));
  }

  @Test
  public void getAllElementsDoesNotContainFourTest() {
    int[] array = {2, 3, 7, 9, 6, 6, 8};

    Assertions.assertThrows(RuntimeException.class,
        () -> arrayElements.getAllElementsAfterFour(array));
  }

  @Test
  public void isArrayContainsOnlyOneAndFourTest() {
    int[] array = {1, 4, 1, 4,};
    Assertions.assertTrue(arrayElements.isArrayContainsSearchingNumbers(array));
  }

  @Test
  public void ArrayNotContainOneTest() {
    int[] array = {4, 4, 4, 4};
    Assertions.assertFalse(arrayElements.isArrayContainsSearchingNumbers(array));
  }

  @Test
  public void ArrayNotContainFourTest() {
    int[] array = {1, 1, 1, 1};
    Assertions.assertFalse(arrayElements.isArrayContainsSearchingNumbers(array));
  }

}
