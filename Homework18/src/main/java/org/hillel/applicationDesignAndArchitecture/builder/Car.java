package org.hillel.applicationDesignAndArchitecture.builder;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class Car {
  private final String brandName;
  private final String color;
  private final String engine;
  private final String body;

  private Car(Builder builder) {
    this.brandName = builder.brandName;
    this.color = builder.color;
    this.engine = builder.engine;
    this.body = builder.body;
  }
  public static class Builder {
    private String brandName;
    private String color;
    private String engine;
    private String body;

    public Builder brandName(String brandName) {
      this.brandName = brandName;
      return this;
    }

    public Builder color(String color) {
      this.color = color;
      return this;
    }

    public Builder engine(String engine) {
      this.engine = engine;
      return this;
    }

    public Builder body(String body) {
      this.body = body;
      return this;
    }

    public Car build() {
      return new Car(this);
    }
  }
}
