package org.hillel.algorithms;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
      int[] array = new int[10000];
      for (int i = 0; i < array.length; i++) {
        array[i] = (int) (Math.random() * 11);
      }
      System.out.println("Source array: " + "\n" + Arrays.toString(array));
      int low = 0;
      int high = array.length - 1;

      Algorithms algorithms = new Algorithms();

      algorithms.quickSort(array, low, high);
      System.out.println("sorted array by quick sort method: " + "\n" + Arrays.toString(array));
      algorithms.cocktailSort(array);
      System.out.println("sorted array by cocktail sort method: " + "\n" + Arrays.toString(array));
    }
  }
