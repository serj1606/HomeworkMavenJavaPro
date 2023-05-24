package LoggerHW;

import java.util.LinkedList;
import java.util.Queue;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CoffeeOrderBoard2 {

  private int number = 0;

  private final Queue<Order> orders = new LinkedList<>();

  public void add(String name) {

    orders.add(new Order(++number, name));
    log.info("Adding order for " + name);
  }

  public void deliver() {
        orders.poll();
    log.info("Delivering order");
  }

  public void deliver(int number) {

    for (Order order : orders) {
      if (order.number == number) {
        orders.remove(order);
        log.info("Delivering order #" + number);
        break;
      }
    }
  }

  public void draw() {
    log.info("Drawing board");
    System.out.println("=============\nNum   |  Name");
    for (Order order : orders) {
      System.out.println(order);
    }
    System.out.println();
  }

  public int getNumber(String name) {
         for (Order order : orders) {
      if (order.name.equals(name)) {
        log.info("Getting number for " + name);
        return order.number;
      }
    }
    String errorMessage = "Can not find order with name " + name;
     log.error(errorMessage);
    throw new IllegalArgumentException("Can not find order with name " + name);
  }

  private static class Order {
    private final int number;
    private final String name;

    public Order(int number, String name) {
      this.number = number;
      this.name = name;
    }


    @Override
    public String toString() {
      return number + "   |  " + name;
    }
  }
}
