package org.hillel.homework17.generics.fruitsBoxes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class BoxTest {
  @Test
  public void addFruitToEmptyBoxTest() {
    Box<Apple> box = new Box<>();
    box.addFruit(new Apple());
    assertEquals(1.0f, box.getWeight(), 0.0f);
  }

  @Test
  public void getWeight_ReturnsWeightOfBoxTest() {
    Box<Apple> box = new Box<>();
    box.addFruit(new Apple());
    box.addFruit(new Apple());
    assertEquals(2.0f, box.getWeight(), 0.0f);
  }

  @Test
  public void getWeight_ReturnsZeroForEmptyBoxTest() {
    Box<Apple> box = new Box<>();
    assertEquals(0.0f, box.getWeight(), 0.0f);
  }

  @Test
  public void CompareTest() {
    Box<Apple> appleBox1 = new Box<>();
    appleBox1.addFruit(new Apple());
    appleBox1.addFruit(new Apple());

    Box<Apple> appleBox2 = new Box<>();
    appleBox2.addFruit(new Apple());
    appleBox2.addFruit(new Apple());

    Box<Orange> orangeBox = new Box<>();
    orangeBox.addFruit(new Orange());
    orangeBox.addFruit(new Orange());

    assertTrue(appleBox1.compare(appleBox2));
    assertFalse(appleBox1.compare(orangeBox));
  }

  @Test
  void mergeTest() {
    Box<Apple> box1 = new Box<>();
    box1.addFruit(new Apple());
    Box<Apple> box2 = new Box<>();
    box2.addFruit(new Apple());

    box1.merge(box2);

    assertEquals(2, box1.getFruits().size());
    assertEquals(0, box2.getFruits().size());
  }

  @Test
  public void MergeDifferentTypeTest() {
    Box<Apple> appleBox1 = new Box<>();
    appleBox1.addFruit(new Apple());
    appleBox1.addFruit(new Apple());

    Box<Apple> appleBox2 = new Box<>();
    appleBox2.addFruit(new Apple());
    appleBox2.addFruit(new Apple());

    appleBox1.merge(appleBox2);

    assertEquals(4, appleBox1.getFruits().size());
    assertEquals(0, appleBox2.getFruits().size());
  }

  @Test
  public void MergeEmptyBoxTest() {
    Box<Apple> box1 = new Box<>();
    Box<Apple> box2 = new Box<>();
    box1.addFruit(new Apple());
    box1.merge(box2);
    assertEquals(1.0f, box1.getWeight(), 0.01f);
    assertEquals(0.0f, box2.getWeight());
  }
}
