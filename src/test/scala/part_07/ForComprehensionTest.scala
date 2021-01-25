package part_07

import munit.FunSuite
import ForComprehension._

class ForComprehensionTest extends FunSuite {

  test("basic composition") {
    println("before evaluation A")
    val i = lazyResultA.get
    println(s"lazyResultA = $i")
    println("after evaluation A")
  }

  test("basic for comprehension") {
    println("before evaluation B")
    val i = lazyResultB.get
    println(s"lazyResultB = $i")
    println("after evaluation B")
  }

  test("test filters") {
    assert(processAllA.isEmpty)
    assertEquals(processAllB, Some(24))
  }

  test("for comprehension with filter") {
    assert(result contains (10, 0, 4))
    assert(result contains (9, 1, 3))
    assert(result contains (2, 3, 1))
    assert(!(result contains (3, 4, 0)))
    assert(!(result contains (3, 4, 0)))
  }

}
