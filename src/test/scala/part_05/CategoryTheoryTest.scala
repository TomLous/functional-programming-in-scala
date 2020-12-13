package part_05

import munit.FunSuite
import CategoryTheory._

class CategoryTheoryTest extends FunSuite {

  test("Container c1") {
    assertEquals(mapped1a, mapped1b)
    assertEquals(mapped1b, mapped1b)
  }

  test("Container c2") {
    assertEquals(mapped2, Container(List(1, 2, 3)))
  }

  test("sequenceOption") {
    assertEquals(
      sequenceOption(List(Some(3), Some(5), Some(9))),
      Some(List(3, 5, 9))
    )
    assertEquals(sequenceOption(List(Some(3), None, Some(9))), None)
    assertEquals(sequenceOption(List.empty[Option[Int]]), Some(List()))
  }

  test("flatMap") {
    assertEquals(l5, List(1, 2, 3, 4, 5, 6, 7))
  }

  test("noSevens") {
    assertEquals(
      noSevens,
      List(0, 1, 2, 3, 4, 5, 6, 8, 9, 10, 11, 12, 13, 14, 15, 16, 18, 19, 20,
        21, 22, 23, 24, 25, 26, 28, 29, 30, 31, 32, 33, 34, 35, 36, 38, 39, 40,
        41, 42, 43, 44, 45, 46, 48, 49, 50, 51, 52, 53, 54, 55, 56, 58, 59, 60,
        61, 62, 63, 64, 65, 66, 68, 69, 80, 81, 82, 83, 84, 85, 86, 88, 89, 90,
        91, 92, 93, 94, 95, 96, 98, 99)
    )
  }

}
