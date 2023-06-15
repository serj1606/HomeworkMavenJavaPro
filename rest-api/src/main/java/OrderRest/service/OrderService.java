package OrderRest.service;

import OrderRest.entity.Order;
import OrderRest.repository.OrderRepository;
import java.util.List;

public class OrderService {
  OrderRepository orderRepository = new OrderRepository();

  public Order addOrder(Order order) {
    return orderRepository.addOrder(order);
  }

  public Order getOrderId(int id) {
    return orderRepository.getOrderId(id);
  }

  public List<Order> getAllOrders() {
    return orderRepository.getAllOrders();
  }
}
