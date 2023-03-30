package org.hillel.homework_collections_lists.phonebook;

public class Recording {
  private final String name;
  private final String phone;

  public Recording(String name, String phone) {
    this.name = name;
    this.phone = phone;
  }

  public String getName() {
    return name;
  }

  @Override
  public String toString() {
    return "Recording{" +
        "name='" + name + '\'' +
        ", phone='" + phone + '\'' +
        '}';
  }
}