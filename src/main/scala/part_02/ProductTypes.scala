package part_02

object ProductTypes {

  // case classes
  case class Course(title: String, description: String, durationHours: Int)

  // Exercise: Create two courses that pass the unit test
  val course1: Course =
    Course("Data for DevOps", "How to build CI/CD for data products", 4)
  val course2: Course =
    Course("Functional Programming in Scala", "Learn Scala & FP", 5)

  // companion objects
  object Course {
    val defaultDurationHours = 4

    // Exercise: Complete static function
    def defaultCourse(name: String, description: String): Course =
      Course(name, description, defaultDurationHours)
  }

  // sealed traits
  sealed trait Person
  case class Teacher(name: String) extends Person
  case class Student(firstName: String, lastName: String, age: Int)
      extends Person

  // Exercise: handle Person in function with pattern matching
  def personToString(p: Person): String =
    p match {
      case Teacher(n)       => n
      case Student(f, l, _) => s"$f $l"
    }

  // tuples: basic product types
  val tuple1: (String, Int, Double) = ("Some value", 33, 4.5)
  val tuple2: (Int, Boolean, Double) = (44, true, 7.99)

  // Exercise: handle tuples with doubles in 3rd position
  def tupleToDouble(t: (Any, Any, Double)): Double = {
    t._3
  }

  // List. (standard library)
  // immutable, recursive & homogeneous
  val list1: List[String] = List("A", "list", "of", "Strings")
  val list2: List[Int] = List(1, 1, 2, 3, 5, 8)
  val list3: List[List[Int]] = List(List(1, 2, 3), List(4, 5, 6, 7), List(8))
  val list4: List[Nothing] = List()
  val list5: List[Any] = List(1, "2", 3.4)

  // using constructors
  val list6: List[Nothing] = Nil
  val list7: List[Int] = 1 :: 2 :: 3 :: 4 :: Nil
  val list8: List[Int] = Nil.::(4).::(3).::(2).::(1)
  val list9: List[Int] = 1 :: list7
  val list10: List[Int] = list7 :+ 5

  // Exercise: reverse all integers in the list
  def reverseInts(list: List[Int]): List[Int] =
    list match {
      case Nil          => Nil
      case head :: tail => reverseInts(tail) :+ head
    }
}
