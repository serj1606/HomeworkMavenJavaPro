package org.hillel.workingWithGraphs;

import lombok.Data;

@Data
// class for tree nodes
public class Node {
  private int value;
  private Node left, right;

  public Node(int value) {
    this.value = value;
  }
}

