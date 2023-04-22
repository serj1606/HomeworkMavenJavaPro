package org.hillel.applicationDesignAndArchitecture.fabrica;

public class Shelf extends Furniture {
  @Override
  void create() {
    System.out.println("The shelf is created");
  }
}
