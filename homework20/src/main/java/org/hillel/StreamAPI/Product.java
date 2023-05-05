package org.hillel.StreamAPI;

import java.time.LocalDateTime;

public class Product {
  private final String category;
  private final double price;
  private final boolean neededDiscount;
  private final LocalDateTime createDate;
  private final int identificationNumber;

  public Product(String category, double price, boolean neededDiscount, LocalDateTime createDate, int identificationNumber) {
    this.category = category;
    this.price = price;
    this.neededDiscount = neededDiscount;
    this.createDate = createDate;
    this.identificationNumber = identificationNumber;
  }

  public String getCategory() {
    return category;
  }

  public double getPrice() {
    return price;
  }

  public boolean isNeededDiscount() {
    return neededDiscount;
  }

  public LocalDateTime getCreateDate() {
    return createDate;
  }

  public int getIdentificationNumber() {
    return identificationNumber;
  }

  @Override
  public String toString() {
    return "Product{" +
        "category='" + category + '\'' +
        ", price=" + price +
        ", neededDiscount=" + neededDiscount +
        ", createDate=" + createDate +
        ", identificationNumber=" + identificationNumber +
        '}' + "\n";
  }
}

