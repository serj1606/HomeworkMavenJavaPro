package org.hillel.dictionaries;

public class Main {
  public static void main(String[] args) {
    FileNavigator fileNavigator = new FileNavigator();

    fileNavigator.add("path/test/1", new FileData("firstApp.java", 1,"path/test/1"));
    fileNavigator.add("path/test/55", new FileData("fiftyFifthApp.java", 55,"path/test/55"));
    fileNavigator.add("path/test/2", new FileData("secondApp.java", 2,"path/test/2"));
    fileNavigator.add("path/test/3", new FileData("thirdApp.java", 3,"path/test/3"));
    fileNavigator.add("path/test/1", new FileData("firstAppConfig.java", 30,"path/test/1"));

    System.out.println(fileNavigator.find("path/test/1"));
    System.out.println(fileNavigator.filterBySize(3));
    System.out.println(fileNavigator.allFilesToList());
    System.out.println(fileNavigator.sortBySize());
    fileNavigator.remove("path/test/1");
    System.out.println(fileNavigator.allFilesToList());
    System.out.println(fileNavigator.sortBySize());
  }
}

