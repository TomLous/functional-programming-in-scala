package part_04b

import part_02.ProductTypes.{Course, Person, Student, Teacher}

import scala.util.Try

object Refresher {

  // assignments are definitions. Immutable typed terms
  val listA = List("a", "b", "c")
  val intA = 34
  val doubleA = 22.4

  // to get a new value we pass these terms into functions or methods.
  def isOdd(number: Int): Boolean = {
    number % 2 == 1
  }

  val isNumEvenA: Boolean = !isOdd(intA)

  // or we create a method that returns a function to generalize
  def isDivisibleBy(denominator: Int): Int => Boolean =
    numerator => numerator % denominator == 0

  val isNumEvenB: Boolean = isDivisibleBy(2)(intA)

  val isEvenF: Int => Boolean = isDivisibleBy(2)

  val isNumEvenC: Boolean = isEvenF(intA)

  // product types
  val tupleA: (String, String, Int) = ("Title A", "Description A", 4)
  val caseClassA: Course = Course("Title B", "Description B", 5)

  val checkCourseDuration: Int => Course => Boolean =
    hours => course => course.durationHours > hours

  val isLongCourse: Course => Boolean = checkCourseDuration(4)

  val isCourseALong: Boolean = isLongCourse(caseClassA)

  // basic pattern matching

  val longText: String = tupleA match {
    case (title, _, _) if title.length > 20 => title
    case (title, description, _) if description.length < 40 =>
      title + description
    case (title, description, _) => title + description.take(40)
  }

  val teacherOrStudent: Person = Student("Alice", "Smith", 23)

  val nameA: String = teacherOrStudent match {
    case Teacher(name)                   => name
    case Student(firstName, lastName, _) => s"$firstName $lastName"
    case _                               => "unknown"
  }

  // sum types
  val dontDoThis: Int = 0 // <- null won't compile
//  val dontDoThis: Int = null
  def addOne(i: Int) = i + 1
  lazy val x: Int =
    addOne(
      dontDoThis
    ) // This will throw an exception, and we have to dig why. The fault is not of the function adding 1, but the function returning a null instead of a number

  def getEvenNumbersOnly(number: Int): Option[Int] = {
    if (isEvenF(number)) Some(number)
    else None
  }

  def unsafeIO() = throw new Exception("IO Failed!!!")

  def doSomeIOStuff: Either[Throwable, String] =
    Try {
      unsafeIO
    }.toEither

  val handleIO: Option[String] = doSomeIOStuff match {
    case Right(content) => Some(content)
    case Left(exception) =>
      println(exception.toString)
      None
  }

  //

}
