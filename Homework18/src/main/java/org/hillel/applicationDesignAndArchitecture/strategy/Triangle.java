package org.hillel.applicationDesignAndArchitecture.strategy;

public class Triangle implements Shape{
  private final double base;       // The base of the triangle
  private final double height;     // The height of the triangle

    public Triangle(double base, double height) {
    this.base = base;
    this.height = height;

  }

  @Override
  public double getArea() {
    return  0.5 * base * height;
  }
}
