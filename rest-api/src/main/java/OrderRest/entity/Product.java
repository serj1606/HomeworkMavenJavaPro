package OrderRest.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@ToString
public class Product {
  private int id;
  private String name;
  private double cost;

  public Product() {
  }

  public Product(String name, double cost) {
    this.name = name;
    this.cost = cost;
  }

  public Product(int id, String name, double cost) {
    this.id = id;
    this.name = name;
    this.cost = cost;
  }
}
