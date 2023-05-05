package org.hillel.applicationDesignAndArchitecture.strategy;

public class AreaCalculator {
  private final Shape shape;

  public AreaCalculator(Shape shape) {
    this.shape = shape;
  }

  public double calculateArea() {
    return shape.getArea();
  }
}
