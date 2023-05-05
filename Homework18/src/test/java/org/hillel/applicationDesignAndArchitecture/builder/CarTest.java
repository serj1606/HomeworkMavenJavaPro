package org.hillel.applicationDesignAndArchitecture.builder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


import org.junit.jupiter.api.Test;

public class CarTest {
  @Test
  public void testBuildCar() {
    Car car = new Car.Builder()
        .brandName("BMW")
        .color("Red")
        .engine("V8")
        .body("Sedan")
        .build();
    assertEquals("BMW", car.getBrandName());
    assertEquals("Red", car.getColor());
    assertEquals("V8", car.getEngine());
    assertEquals("Sedan", car.getBody());
  }

  @Test
  public void testBuildCarWithoutEngine() {
    Car car = new Car.Builder()
        .brandName("Audi")
        .color("Black")
        .body("Hatchback")
        .build();

    assertNull(car.getEngine());
    assertEquals("Audi", car.getBrandName());
    assertEquals("Black", car.getColor());
    assertEquals("Hatchback", car.getBody());
  }
}
