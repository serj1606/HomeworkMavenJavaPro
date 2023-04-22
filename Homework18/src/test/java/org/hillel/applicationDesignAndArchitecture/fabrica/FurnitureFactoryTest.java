package org.hillel.applicationDesignAndArchitecture.fabrica;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class FurnitureFactoryTest {
  @Test
  public void testCreateTable() {
    FurnitureFactory factory = new FurnitureFactory();
    Furniture table = factory.createFurniture("Table");
    assertTrue(table instanceof Table);
  }

  @Test
  public void testCreateChair() {
    FurnitureFactory factory = new FurnitureFactory();
    Furniture chair = factory.createFurniture("Chair");
    assertTrue(chair instanceof Chair);
  }

  @Test
  public void testCreateShelf() {
    FurnitureFactory factory = new FurnitureFactory();
    Furniture shelf = factory.createFurniture("Shelf");
    assertTrue(shelf instanceof Shelf);
  }

  @Test
  public void testInvalidType() {
    FurnitureFactory factory = new FurnitureFactory();
    Furniture furniture = factory.createFurniture("InvalidType");
    assertNull(furniture);
  }

}
