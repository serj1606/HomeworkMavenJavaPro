package org.hillel.applicationDesignAndArchitecture.fabrica;

public class Table extends Furniture {
  @Override
  public void create() {
    System.out.println("The table is created");
  }
}
