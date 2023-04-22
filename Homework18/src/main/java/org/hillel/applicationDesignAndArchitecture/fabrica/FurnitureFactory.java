package org.hillel.applicationDesignAndArchitecture.fabrica;

class FurnitureFactory {
  Furniture createFurniture(String type) {
    switch (type) {
      case "Table":
        return new Table();
      case "Chair":
        return new Chair();
      case "Shelf":
        return new Shelf();
      default:
        return null;
    }
  }
}
