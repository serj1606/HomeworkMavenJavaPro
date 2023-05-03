package org.hillel.StreamAPI;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductUtillsTest {
  @Test
  void testGetAllExpensiveBooks() {
    Product book1 = new Product("Book", 300, false, LocalDateTime.now(), 1);
    Product book2 = new Product("Book", 260, false, LocalDateTime.now(), 2);
    Product cheapBook = new Product("Book", 50, false, LocalDateTime.now(), 3);
    Product notABook = new Product("CD", 100, false, LocalDateTime.now(), 4);

    List<Product> productList = new ArrayList<>();
    productList.add(book1);
    productList.add(book2);
    productList.add(cheapBook);
    productList.add(notABook);

    List<Product> expensiveBooks = ProductUtils.getAllExpensiveBooks(productList);

    assertEquals(2, expensiveBooks.size());
    assertTrue(expensiveBooks.contains(book1));
    assertTrue(expensiveBooks.contains(book2));
  }

  @Test
  public void testGetAllBooksWithDiscount() {
    List<Product> products = new ArrayList<>();
    products.add(new Product("Book", 100.0, true, LocalDateTime.now(), 1));
    products.add(new Product("Book", 150.0, false, LocalDateTime.now(), 2));
    products.add(new Product("Toy", 50.0, true, LocalDateTime.now(), 3));

    List<Product> discountedProducts = ProductUtils.getAllBooksWithDiscount(products);

    assertEquals(1, discountedProducts.size());
    assertEquals(90.0, discountedProducts.get(0).getPrice());
  }

  @Test
  void testGetCheapestBookWhenListContainsMultipleBooks() {
    List<Product> productList = new ArrayList<>();
    productList.add(new Product("Book", 50, false, LocalDateTime.now(), 1));
    productList.add(new Product("Book", 75, true, LocalDateTime.now(), 2));
    productList.add(new Product("Book", 30, false, LocalDateTime.now(), 3));
    productList.add(new Product("Book", 80, false, LocalDateTime.now(), 4));
    Product cheapestBook = ProductUtils.getCheapestBook(productList);
    assertEquals(30, cheapestBook.getPrice());
  }

  @Test
  void testGetCheapestBookWhenListDoesNotContainBooks() {
    List<Product> productList = new ArrayList<>();
    productList.add(new Product("Laptop", 1000, false, LocalDateTime.now(), 1));
    assertThrows(NoSuchElementException.class, () -> ProductUtils.getCheapestBook(productList));
  }

  @Test
  public void testGetLastAddedProductsEmptyList() {
    List<Product> products = new ArrayList<>();
    List<Product> lastAddedProducts = ProductUtils.getLastAddedProducts(products);
    assertTrue(lastAddedProducts.isEmpty());
  }

  @Test
  public void testGetLastAddedProductsMoreThanLimit() {
    List<Product> products = Arrays.asList(
        new Product("Book", 100, false, LocalDateTime.of(2023, 4, 28, 10, 0), 1),
        new Product("Book", 50, false, LocalDateTime.of(2023, 4, 28, 12, 0), 2),
        new Product("CD", 10, false, LocalDateTime.of(2023, 4, 28, 14, 0), 3),
        new Product("DVD", 20, false, LocalDateTime.of(2023, 4, 28, 16, 0), 4),
        new Product("Book", 150, true, LocalDateTime.of(2023, 4, 28, 18, 0), 5)
    );
    List<Product> lastAddedProducts = ProductUtils.getLastAddedProducts(products);
    assertEquals(ProductUtils.NUMBER_OF_PRODUCTS_LIMIT, lastAddedProducts.size());
  }

  @Test
  public void testCalculateSumOfCheapBooksPricesOfCurrentYearWithMultipleCheapBooks() {
    List<Product> products = new ArrayList<>();
    products.add(new Product("Book", 60.0, false, LocalDateTime.of(2023, 1, 1, 0, 0), 1));
    products.add(new Product("Book", 70.0, false, LocalDateTime.of(2023, 1, 1, 0, 0), 2));
    products.add(new Product("Book", 80.0, false, LocalDateTime.of(2023, 1, 1, 0, 0), 3));
    products.add(new Product("Book", 50.0, false, LocalDateTime.of(2022, 1, 1, 0, 0), 4));
    Assertions.assertEquals(130,
        ProductUtils.calculateSumOfCheapBooksPricesOfCurrentYear(products));
  }
  @Test
  public void testGroupingByTypeContainsCorrectProductLists() {
    List<Product> products = Arrays.asList(
        new Product("Book", 10.0, false, LocalDateTime.now(), 1),
        new Product("Book", 20.0, false, LocalDateTime.now(), 2),
        new Product("Toy", 100.0, false, LocalDateTime.now(), 3)
    );
    Map<String, List<Product>> result = ProductUtils.groupingByType(products);
    assertEquals(2, result.get("Book").size());
    assertEquals(1, result.get("Toy").size());
  }
  @Test
  public void testGroupingByTypeDoesNotContainExtraKeys() {
    List<Product> products = Arrays.asList(
        new Product("Book", 10.0, false, LocalDateTime.now(), 1),
        new Product("CD", 5.0, false, LocalDateTime.now(), 3)
    );
    Map<String, List<Product>> result = ProductUtils.groupingByType(products);
    assertFalse(result.containsKey("Toy"));
  }
}

