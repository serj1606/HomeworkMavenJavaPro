package org.hillel.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.hillel.model.Product;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository {

  private final Map<Long, Product> products;

  public ProductRepository() {
    products = new HashMap<>();
    products.put(1L, new Product(1, 5, "cola"));
    products.put(2L, new Product(2, 10, "fanta"));
    products.put(3L, new Product(3, 7, "sprite"));
    products.put(4L, new Product(4, 15, "coffee"));
  }

  public Optional<Product> findById(long id) {
    return Optional.ofNullable(products.get(id));
  }

  public List<Product> getAll() {
    return new ArrayList<>(products.values());
  }
}
