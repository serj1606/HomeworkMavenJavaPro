package org.hillel.homework_collections_lists.phonebook;

public class Main {
  public static void main(String[] args) {
    Phonebook phonebook = new Phonebook();
    phonebook.add(new Recording("Alan", "80677777777"));
    phonebook.add(new Recording("Alan", "80501111112"));
    phonebook.add(new Recording("Julia", "80973213213"));
    phonebook.add(new Recording("Julia", "80984564567"));
    phonebook.add(new Recording("Jim", "80953214789"));

    System.out.println(phonebook.find("Alan"));
    System.out.println(phonebook.findAll("Alan"));
    System.out.println(phonebook.find("Julia"));
    System.out.println(phonebook.findAll("Julia"));
    System.out.println(phonebook.findAll("Jimi"));
  }
}