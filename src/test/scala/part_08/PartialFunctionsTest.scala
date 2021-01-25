package part_08

import munit.FunSuite
import PartialFunctions._

class PartialFunctionsTest extends FunSuite {

  test("partial applied ") {

    assertEquals(sum(1, 2, 3), sumPartA(3, 2, 1))
    assertEquals(sum(1, 2, 3), sumPartB(3))
  }

  test("Partial Functions trait") {
    assertEqualsDouble(sqrt9, 3.0, 0.0001)
    assertEquals(sqrtNeg11.compareTo(Double.NaN), 0)
  }

  test("Partial Functions case") {
    assertEqualsDouble(divOk, 3.0, 0.0001)
    assertEquals(divErr.compareTo(Double.NaN), 0)
  }

  test("Chain action") {
    assertEquals(chainAction(2), 9)
    assertEquals(chainAction(3), 14)
    assertEquals(chainAction(-5), -10)

  }

}
