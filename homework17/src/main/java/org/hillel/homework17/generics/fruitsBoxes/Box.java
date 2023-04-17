package org.hillel.homework17.generics.fruitsBoxes;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;


@Data
public class Box<T extends Fruit> {
  private List<T> fruits;

  public Box() {
    fruits = new ArrayList<>();
  }

  public void addFruit(T fruit) {
    if (fruits.size() == 0 || fruits.get(0).getClass().equals(fruit.getClass())) {
      fruits.add(fruit);
    } else {
      System.out.println("Cannot add fruit of different type");
    }
  }

  public void addFruits(List<T> fruitsToAdd) {
    for (T fruit : fruitsToAdd) {
      addFruit(fruit);
    }
  }

  public float getWeight() {
    if (fruits.size() == 0) {
      return 0.0f;
    } else {
      float weight = fruits.size() * fruits.get(0).getWeight();
      return weight;
    }
  }

  public boolean compare(Box<? extends Fruit> otherBox) {
    return this.getWeight() == otherBox.getWeight();
  }

  public void merge(Box<T> otherBox) {
    if (this.fruits.size() == 0 || otherBox.fruits.size() == 0 ||
        this.fruits.get(0).getClass().equals(otherBox.fruits.get(0).getClass())) {
      this.fruits.addAll(otherBox.fruits);
      otherBox.fruits.clear();
    } else {
      System.out.println("Cannot merge boxes of different fruit types");
    }
  }
}

