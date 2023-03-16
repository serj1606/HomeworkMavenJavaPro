package org.hillel.homework11;

import org.Hillel.mathematic.Mathematic;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MathematicTest {
  Mathematic mathematic = new Mathematic();

  @Test
  public void additionTest() {
    Assertions.assertEquals(4, mathematic.addition(2, 2));
  }
  @Test
  public void exponentiationTest(){
    Assertions.assertEquals(9,mathematic.exponentiation(3,2));
  }
}
