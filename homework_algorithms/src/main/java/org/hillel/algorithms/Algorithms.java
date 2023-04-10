package org.hillel.algorithms;


public class Algorithms {
  // sorting methods
  // cocktail shaker sort method
  public void cocktailSort(int[] array) {
    boolean isSwapped = true;
    int start = 0;
    int end = array.length;

    while (isSwapped) {
      isSwapped = false;
      for (int i = start; i < end - 1; ++i) {
        if (array[i] > array[i + 1]) {
          int temp = array[i];
          array[i] = array[i + 1];
          array[i + 1] = temp;
          isSwapped = true;
        }
      }
      if (!isSwapped) {
        break;
      }
      isSwapped = false;
      end = end - 1;

      for (int i = end - 1; i >= start; i--) {
        if (array[i] > array[i + 1]) {
          int temp = array[i];
          array[i] = array[i + 1];
          array[i + 1] = temp;
          isSwapped = true;
        }
      }
      start = start + 1;
    }
  }
// Quicksort method
  public void quickSort(int[] array, int low, int high) {
    if (low >= high) {
      return;
    }
    int pivot = array[low + (high - low) / 2];
    int i = low, j = high;
    while (i <= j) {
      while (array[i] < pivot) {
        i++;
      }
      while (array[j] > pivot) {
        j--;
      }
      if (i <= j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        i++;
        j--;
      }
    }
    if (low < j) {
      quickSort(array, low, j);
    }
    if (high > i) {
      quickSort(array, i, high);
    }
  }
}
// я так зрозумів що ця ДЗ для того щоб ми побачили різницю в швидкості сортування, та згадали про різні види сортування