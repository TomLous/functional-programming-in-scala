package part_04

import munit.FunSuite
import HigherOrderFunctions._

class HigherOrderFunctionsTest extends FunSuite {

  test("sums") {
    assertEquals(sumInts(1, 5), sumIntsBasic(1, 5))
    assertEquals(sumCubes(2, 6), sumCubesBasic(2, 6))
    assertEquals(sumFactorials(3, 7), sumFactorialsBasic(3, 7))
  }

  test("sumSquares") {
    assertEquals(sumSquares(1, 5), 1 * 1 + 2 * 2 + 3 * 3 + 4 * 4 + 5 * 5)
    assertEquals(sumSquares(2, 4), 2 * 2 + 3 * 3 + 4 * 4)
  }

}
