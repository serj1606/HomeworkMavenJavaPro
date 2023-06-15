package OrderRest.entity;


import java.util.List;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@ToString
public class Order {
  private int id;
  private String date;
  private double cost;

  private List<Product> products;

  public Order() {
  }


}
