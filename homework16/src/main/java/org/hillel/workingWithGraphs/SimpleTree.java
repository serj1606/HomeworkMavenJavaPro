package org.hillel.workingWithGraphs;

public class SimpleTree {
  // Tree root
  private Node root;

  public Node getRoot() {
    return root;
  }

  // method of adding an element to the tree
  public void add(int value) {
    root = addRecursive(root, value);
  }

  private Node addRecursive(Node current, int value) {
    if (current == null) {
      return new Node(value);
    }

    if (value < current.getValue()) {
      current.setLeft(addRecursive(current.getLeft(), value));
    } else if (value > current.getValue()) {
      current.setRight(addRecursive(current.getRight(), value));
    }
    return current;
  }

  // method of iterating the tree in order in-order traversal
  public void inOrderTraversal() {
    inOrderTraversalRecursive(root);
  }

  private void inOrderTraversalRecursive(Node node) {
    if (node != null) {
      inOrderTraversalRecursive(node.getLeft());
      System.out.print(node.getValue() + " ");
      inOrderTraversalRecursive(node.getRight());
    }
  }
}
