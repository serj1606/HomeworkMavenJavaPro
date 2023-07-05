package org.hillel.mvc.repository;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import lombok.Data;
import org.hillel.mvc.entity.Order;
import org.springframework.stereotype.Repository;

@Repository
@Data
public class OrderRepository {
 private Map<UUID, Order> orders;

 public OrderRepository() {
  this.orders = new HashMap<>();
 }

 public void addOrder(Order order) {
  orders.put(order.getId(), order);
 }

 public Order getOrderById(UUID id) {
  return orders.get(id);
 }

 public List<Order> getAllOrders() {
  return new ArrayList<>(orders.values());
 }

}

