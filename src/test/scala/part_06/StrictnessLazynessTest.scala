package part_06

import munit.FunSuite
import StrictnessLazyness._

class StrictnessLazynessTest extends FunSuite {

  test("printTwice") {
    assertEquals(printTwice({ println("Evalualting Code 2x"); 1 }), 2)
  }

  test("raiseException") {
    assertEquals(
      raiseException(false, { throw new Exception("This will work") }),
      ()
    )
    interceptMessage[Exception]("This will not work") {
      raiseException(true, { throw new Exception("This will not work") })
    }

  }

  test("printOnce") {
    assertEquals(printOnce({ println("Evalualting Code 1x"); 1 }), 2)
  }

  test("fibonacci") {
    assertEquals(fibonacci().take(6).toList, List(1L, 1L, 2L, 3L, 5L, 8L))
    assertEquals(
      fibonacci().takeWhile(_ < 20L).toList,
      List(1L, 1L, 2L, 3L, 5L, 8L, 13L)
    )
  }

  test("willBreakEventually") {
    assert(willBreakEventually.take(Int.MaxValue).isInstanceOf[LazyList[Int]])
    assertEquals(
      willBreakEventually.take(3).toList,
      List(1 * 1 * 1, 2 * 2 * 2, 3 * 3 * 3)
    )
  }

}
