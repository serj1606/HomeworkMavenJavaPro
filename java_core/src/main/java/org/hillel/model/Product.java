package org.hillel.model;

import java.util.Objects;

public class Product {
  private long id;
  private double price;
  private String name;

  public Product(long id, double price, String name) {
    this.id = id;
    this.price = price;
    this.name = name;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Product product = (Product) o;
    return id == product.id && Objects.equals(price, product.price) &&
        Objects.equals(name, product.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, price, name);
  }

  @Override
  public String toString() {
    return "Product{" +
        "id=" + id +
        ", price=" + price +
        ", name='" + name + '\'' +
        '}';
  }
}
