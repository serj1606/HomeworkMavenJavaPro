package Multithreading;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.hillel.Multithreading.ValueCalculator;
import org.junit.jupiter.api.Test;

public class ValueCalculatorTest {
  @Test
  void testValueCalculatorSize() {
    int size = 1000000;
    ValueCalculator calculator = new ValueCalculator(size);
    assertEquals(size, calculator.getSize());
  }

  @Test
  void testValueCalculatorHalfSize() {
    int size = 1000000;
    ValueCalculator calculator = new ValueCalculator(size);
    assertEquals(size / 2, calculator.getHalfSize());
  }

  @Test
  public void testCalculate() {
    ValueCalculator calculator = new ValueCalculator(1000000);
    calculator.calculate();
    for (int i = 0; i < calculator.getArray().length; i++) {
      float expectedValue =
          (float) (Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
      assertEquals(expectedValue, calculator.getArray()[i]);
    }
  }
}
