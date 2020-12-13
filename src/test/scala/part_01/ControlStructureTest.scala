package part_01

import munit.FunSuite
import ControlStructure._

class ControlStructureTest extends FunSuite {

  test("square") {
    assertEquals(square(3.0), 9.0)
    assertEquals(square(-3.0), 9.0)
  }

  test("abs") {
    assertEquals(abs(-33.0), 33.0)
    assertEquals(abs(-123.4), 123.4)
    assertEquals(abs(99.9), 99.9)
  }

  test("factorial") {
    assertEquals(factorial(0), 1)
    assertEquals(factorial(1), 1)
    assertEquals(factorial(5), 120)
  }

  test("sqrt") {
    assertEqualsDouble(sqrt(9), 3.0000, 0.001)
    assertEqualsDouble(sqrt(2), 1.4142, 0.001)
  }

}
