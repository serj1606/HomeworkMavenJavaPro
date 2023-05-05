package org.hillel.Multithreading;

import java.util.Arrays;
import lombok.Getter;

@Getter
public class ValueCalculator {
  private final float[] array;
  private final int size;
  private final int halfSize;

  public ValueCalculator(int size) {
    if (size < 1000000) {
      size = 1000000;
    }
    this.size = size;
    this.halfSize = size / 2;
    this.array = new float[size];
  }

  public void calculate() {
    long start = System.currentTimeMillis();
    Arrays.fill(array, 1.0f);

    float[] a1 = new float[halfSize];
    float[] a2 = new float[halfSize];

    System.arraycopy(array, 0, a1, 0, halfSize);
    System.arraycopy(array, halfSize, a2, 0, halfSize);

    Thread thread1 = new Thread(() -> {
      for (int i = 0; i < halfSize; i++) {
        a1[i] = (float) (a1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) *
            Math.cos(0.4f + i / 2));
      }
    });

    Thread thread2 = new Thread(() -> {
      for (int i = 0; i < halfSize; i++) {
        a2[i] = (float) (a2[i] * Math.sin(0.2f + (i + halfSize) / 5) *
            Math.cos(0.2f + (i + halfSize) / 5) * Math.cos(0.4f + (i + halfSize) / 2));
      }
    });

    thread1.start();
    thread2.start();

    try {
      thread1.join();
      thread2.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    System.arraycopy(a1, 0, array, 0, halfSize);
    System.arraycopy(a2, 0, array, halfSize, halfSize);

    long end = System.currentTimeMillis();
    long elapsedTime = end - start;
    System.out.println("Elapsed time: " + elapsedTime + " milliseconds");
  }
}
