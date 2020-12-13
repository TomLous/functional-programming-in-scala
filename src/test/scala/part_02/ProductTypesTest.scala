package part_02

import munit.FunSuite
import ProductTypes._

class ProductTypesTest extends FunSuite {

  test("course1") {
    assertEquals(course1.title, "Data for DevOps")
    assertEquals(course1.durationHours, 4)
    assertEquals(course1.description, "How to build CI/CD for data products")
  }

  test("course2") {
    assertEquals(course2.title, "Functional Programming in Scala")
    assertEquals(course2.durationHours, 5)
  }

  test("course companion object") {
    val d = Course.defaultCourse(
      "Data for DevOps",
      "How to build CI/CD for data products"
    )

    assertEquals(d, course1)
  }

  test("personToString") {
    val p1 = Teacher("Tom")
    val s1 = personToString(p1)

    assertEquals(p1.name, s1)

    val p2 = Student("Alice", "Smith", 33)
    val s2 = personToString(p2)

    assertEquals(p2.firstName + " " + p2.lastName, s2)
  }

  test("tupleToDouble") {
    assertEqualsDouble(tupleToDouble(tuple1), 4.5, 0.01)
    assertEqualsDouble(tupleToDouble(tuple2), 7.99, 0.01)
  }

  test("list reversal") {
    assertEquals(List(1, 2, 3), reverseInts(List(3, 2, 1)))
    assertEquals(List.empty[Int], reverseInts(List.empty[Int]))
    assertEquals(List(1), reverseInts(List(1)))
  }

}
