package org.hillel.workingWithGraphs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class SimpleTreeTest {

  @Test
  public void testAdd() {
    SimpleTree tree = new SimpleTree();

    tree.add(5);
    tree.add(3);
    tree.add(8);
    tree.add(1);
    tree.add(4);
    tree.add(7);
    tree.add(10);

    assertEquals(tree.getRoot().getValue(), 5);
    assertEquals(tree.getRoot().getLeft().getValue(), 3);
    assertEquals(tree.getRoot().getRight().getValue(), 8);
    assertEquals(tree.getRoot().getLeft().getLeft().getValue(), 1);
    assertEquals(tree.getRoot().getLeft().getRight().getValue(), 4);
    assertEquals(tree.getRoot().getRight().getLeft().getValue(), 7);
    assertEquals(tree.getRoot().getRight().getRight().getValue(), 10);
  }

  @Test
  public void testInOrderTraversal() {
    SimpleTree tree = new SimpleTree();

    tree.add(5);
    tree.add(3);
    tree.add(8);
    tree.add(1);
    tree.add(4);
    tree.add(7);
    tree.add(10);

    tree.inOrderTraversal(); // повинно вивести "1 3 4 5 7 8 10 "
  }
}
