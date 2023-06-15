package OrderRest.repository;

import OrderRest.entity.Order;
import java.util.ArrayList;
import java.util.List;


public class OrderRepository {
  List<Order> storage;

  public OrderRepository() {
    this.storage = new ArrayList<>();
  }

  public Order addOrder(Order order) {
    storage.add(order);
    return order;
  }

  public Order getOrderId(int id) {
    return storage.get(id);
  }

  public List<Order> getAllOrders() {
    return storage;
  }

}
