package org.hillel.applicationDesignAndArchitecture.fabrica;

public class Chair extends Furniture {
  @Override
  public void create() {
    System.out.println("The chair is created");
  }
}
