package part_03

import munit.FunSuite
import SumTypes._

class SumTypesTest extends FunSuite {

  test("onlyEven") {
    assertEquals(onlyEven(4), Some(4))
    assertEquals(onlyEven(3), None)
    assertEquals(onlyEven(-3), None)
    assertEquals(onlyEven(-4), Some(-4))
  }

  test("realFactorial") {
    assertEquals(realFactorial(1), Right(1))
    assertEquals(realFactorial(3), Right(6))
    assert(realFactorial(-3).isLeft)
  }
}
