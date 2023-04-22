package org.hillel.applicationDesignAndArchitecture.strategy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ShapeTest {
  @Test
  public void testRectangleArea() {
    Shape rectangle = new Rectangle(5, 10);
    AreaCalculator rectangleAreaCalculator = new AreaCalculator(rectangle);
    assertEquals(50.0, rectangleAreaCalculator.calculateArea());
  }

  @Test
  public void testTriangleArea() {
    Shape triangle = new Triangle(5, 10);
    AreaCalculator triangleAreaCalculator = new AreaCalculator(triangle);
    assertEquals(25.0, triangleAreaCalculator.calculateArea());
  }
}
