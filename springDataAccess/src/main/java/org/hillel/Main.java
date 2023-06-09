package org.hillel;

import org.hillel.config.AppConfig;
import org.hillel.dao.CartDao;
import org.hillel.dao.ProductDao;
import org.hillel.model.Product;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.math.BigDecimal;

public class Main {
  public static void main(String[] args) {
    var context = new AnnotationConfigApplicationContext(AppConfig.class);

    ProductDao productDao = context.getBean(ProductDao.class);
    CartDao cartDao = context.getBean(CartDao.class);

    Product beer = new Product();
    beer.setName("beer");
    beer.setPrice(BigDecimal.valueOf(100));

    Product paper = new Product();
    paper.setName("paper");
    paper.setPrice(BigDecimal.valueOf(10));

//        productDao.save(beer);
//        productDao.delete(4);
    System.out.println(productDao.findById(1));
    System.out.println(productDao.findAllProducts());
//        cartDao.addCart(new Cart());
//        cartDao.delete(1);
//        cartDao.addProductInCart(1,2);
//        cartDao.addProductInCart(1,3);
    System.out.println(cartDao.findById(3));
//        productDao.save(paper);
  }
}
